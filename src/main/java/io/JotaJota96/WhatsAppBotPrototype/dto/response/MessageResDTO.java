package io.JotaJota96.WhatsAppBotPrototype.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa el cuerpo de las peticiones que se envían a la API de WhatsApp.
 */
public class MessageResDTO {

    protected String messaging_product = "whatsapp";

    protected List<ContactDTO> contacts;

    protected List<MessageDTO> messages;

    //==========================================================================
    // Constructors
    //==========================================================================

    public MessageResDTO() {
        this.contacts = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    //==========================================================================
    // Getters and setters
    //==========================================================================

    public String getMessaging_product() {
        return messaging_product;
    }

    public MessageResDTO setMessaging_product(String messaging_product) {
        this.messaging_product = messaging_product;
        return this;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public MessageResDTO setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
        return this;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public MessageResDTO setMessages(List<MessageDTO> messages) {
        this.messages = messages;
        return this;
    }

    //==========================================================================
    // Inner classes
    //==========================================================================

    public record ContactDTO(String input, String wa_id) { }

    public record MessageDTO(String id, String message_status) { }

}
