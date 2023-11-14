package io.JotaJota96.WhatsAppBotPrototype.controllers;

import io.JotaJota96.WhatsAppBotPrototype.services.SendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendController {

    //==========================================================================
    // ATENCIÓN: Este controlador es solo para pruebas.
    //           En un entorno de producción no debería ser posible enviar mensajes
    //           a los usuarios simplemente llamando a una URL pública desprotegida.
    //==========================================================================

    @Autowired
    SendingService sendingService;

    @GetMapping("/template/hello_world/{phoneNumber}")
    public String sendHelloWorldTemplate(@PathVariable String phoneNumber) {
        try {
            sendingService.sendHelloWorldTemplate(phoneNumber);
            return "Plantilla 'hello_world' enviada al número " + phoneNumber;
        } catch (Exception e) {
            return "Error al enviar plantilla 'hello_world' al número " + phoneNumber + ": " + e.getMessage();
        }
    }

    @GetMapping("/message/{text}/{phoneNumber}")
    public String sendTextMessage(@PathVariable String text, @PathVariable String phoneNumber) {
        try {
            sendingService.sendTextMessage(phoneNumber, text);
            return "Mensaje '" + text + "' enviada al número " + phoneNumber;
        } catch (Exception e) {
            return "Error al enviar plantilla '" + text + "' al número " + phoneNumber + ": " + e.getMessage();
        }
    }

}
