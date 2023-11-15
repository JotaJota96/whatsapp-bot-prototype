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
                System.out.println("Mensajes de tipo '" + message.type() + "' no soportados");
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
    }

}
