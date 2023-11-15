package io.JotaJota96.WhatsAppBotPrototype.dto.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Esta clase representa el cuerpo de las peticiones que se reciben en el webhook.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ValueDTO(
        String messaging_product,
        List<ContactDTO> contacts,
        List<MessageDTO> messages
) { }
