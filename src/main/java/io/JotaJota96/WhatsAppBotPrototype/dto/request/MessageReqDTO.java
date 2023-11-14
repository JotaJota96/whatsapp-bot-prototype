package io.JotaJota96.WhatsAppBotPrototype.dto.request;

/**
 * Esta clase representa el cuerpo de las peticiones que se envían a la API de WhatsApp.
 */
public abstract class MessageReqDTO {

    protected String messaging_product = "whatsapp";

    protected String to;

    protected String type;

    //==========================================================================
    // Constructors
    //==========================================================================

    public MessageReqDTO(String to, String type) {
        this.to = to;
        this.type = type;
    }

    //==========================================================================
    // Getters and setters
    //==========================================================================

    public String getMessaging_product() {
        return messaging_product;
    }

    public MessageReqDTO setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
        return this;
    }

    public String getTo() {
        return to;
    }

    public MessageReqDTO setTo(String to) {
        this.to = to;
        return this;
    }

    public String getType() {
        return type;
    }

    public MessageReqDTO setType(String type) {
        this.type = type;
        return this;
    }
}
