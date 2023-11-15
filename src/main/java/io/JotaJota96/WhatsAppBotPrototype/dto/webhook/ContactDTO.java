package io.JotaJota96.WhatsAppBotPrototype.dto.webhook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ContactDTO(String wa_id, ProfileDTO profile) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record ProfileDTO(String name) { }

}
