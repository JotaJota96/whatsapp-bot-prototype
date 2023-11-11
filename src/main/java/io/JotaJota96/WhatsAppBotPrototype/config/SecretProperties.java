package io.JotaJota96.WhatsAppBotPrototype.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "meta.api")
@PropertySource("file:secrets.properties")
public class SecretProperties {

    /** URL base de la API graph de Meta */
    private String baseURL;

    /** Token de acceso a la API graph de Meta */
    private String apiToken;

    /** Token de verificación para el webhook */
    private String webhookToken;

    //==========================================================================
    // Constructors
    //==========================================================================

    public SecretProperties() {
    }

    //==========================================================================
    // Getters and setters
    //==========================================================================

    public String getBaseURL() {
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public String getApiToken() {
        return apiToken;
    }

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getWebhookToken() {
        return webhookToken;
    }

    public void setWebhookToken(String webhookToken) {
        this.webhookToken = webhookToken;
    }

}
