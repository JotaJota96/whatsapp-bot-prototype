package io.JotaJota96.WhatsAppBotPrototype.controllers;

import io.JotaJota96.WhatsAppBotPrototype.dto.webhook.ValueDTO;
import io.JotaJota96.WhatsAppBotPrototype.services.ReceptionService;
import io.JotaJota96.WhatsAppBotPrototype.services.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whatsapp")
public class WebhookController {

    @Autowired
    WebhookService webhookService;

    @Autowired
    ReceptionService receptionService;

    @GetMapping("")
    public String index() {
        return "Webhook is running!";
    }

    @GetMapping("/webhook")
    public String verifyWebhook(@RequestParam("hub.mode") String mode,
                                @RequestParam("hub.verify_token") String verifyToken,
                                @RequestParam("hub.challenge") String challenge) {
        boolean webhookCheck = webhookService.verifyWebhook(mode, verifyToken, challenge);
        // Si los parámetros son correctos, se devuelve el challenge
        if (webhookCheck) {
            System.out.println("Webhook verificado correctamente!");
            return challenge;
        } else {
            System.out.println("No se pudo verificar el webhook, parámetros: mode=" + mode + ", challenge=" + challenge + ", verifyToken=" + verifyToken);
            return "Error";
        }
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody String payloadJSON) {
        System.out.println("Evento de webhook recibido: " + payloadJSON.replace("\n", "\\n"));
        ValueDTO valueDTO;
        try {
            // Se procesa el JSON
            valueDTO = webhookService.getValueDTO(payloadJSON);
        } catch (Exception e) {
            System.out.println("Error al procesar el JSON: " + e.getMessage());
            return;
        }

        try {
            // Llamo al servicio que procesa los mensajes
            receptionService.handleWebhookEvent(valueDTO);
        } catch (Exception e) {
            System.out.println("Error al procesar el evento de webhook: " + e.getMessage());
        }
    }

}
