package io.JotaJota96.WhatsAppBotPrototype.services;

import io.JotaJota96.WhatsAppBotPrototype.dto.webhook.MessageDTO;
import io.JotaJota96.WhatsAppBotPrototype.dto.webhook.ValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionService {

    @Autowired
    SendingService sendingService;

    /**
     * Este método se encarga de manejar los eventos que llegan al webhook
     *
     * @param valueDTO Objeto que contiene la información del evento
     */
    public void handleWebhookEvent(ValueDTO valueDTO) {
        if (valueDTO == null) return;

        handleMessages(valueDTO.messages());
    }

    /**
     * Este método se encarga de manejar los mensajes entrantes (pueden ser de texto, imagen, audio, etc)
     *
     * @param messages Lista de mensajes
     */
    private void handleMessages(List<MessageDTO> messages) {
        if (messages == null) return;

        messages.forEach(message -> {
            if ("text".equalsIgnoreCase(message.type())) {
                this.handleTextMessage(message);
            } else {
                this.handleUnsupportedMessage(message);
            }
        });
    }

    /**
     * Este método se encarga de manejar los mensajes de texto entrantes
     *
     * @param message Mensaje de tipo texto
     */
    private void handleTextMessage(MessageDTO message) {
        System.out.println("Mensaje recibido: " + message.text().body());
        // Inicio de mensaje aleatorio (ej: "Eco del mensaje: ", "Tu mensaje fue: ", etc)
        String response = switch ((int) (Math.random() * 5)) {
            case 0 -> "Eco del mensaje: ";
            case 1 -> "Tu mensaje fue: ";
            case 2 -> "Mensaje recibido: ";
            case 3 -> "Has enviado: ";
            case 4 -> "Mensaje: ";
            default -> "";
        };

        response += message.text().body();

        // Envío la respuesta
        sendingService.sendTextMessage(message.from(), response);
    }

    /**
     * Este método se encarga de manejar los tipos de mensajes no soportados
     *
     * @param message Mensaje de cualquier tipo
     */
    private void handleUnsupportedMessage(MessageDTO message) {
        System.out.println("Mensajes de tipo '" + message.type() + "' no soportados");
        // mensaje aleatorio de respuesta
        String response = switch ((int) (Math.random() * 3)) {
            case 0 -> "Por el momento no soporto mensajes de tipo '" + message.type() + "'...";
            case 1 -> "No sé que hacer con mensajes que no sean de texto...";
            case 2 -> "Lo siento, no te entiendo, prueba con un mensaje de texto.";
            default -> "";
        };

        // Envío la respuesta
        sendingService.sendTextMessage(message.from(), response);
    }

}
