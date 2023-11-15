package io.JotaJota96.WhatsAppBotPrototype.dto.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MessageDTO(
        String from,
        String id,
        String type,
        String timestamp,
        TextMessageDTO text
) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TextMessageDTO(
            String body
    ) { }

}
