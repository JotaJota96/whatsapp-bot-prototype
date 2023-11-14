package io.JotaJota96.WhatsAppBotPrototype.dto.request;

public class TextMsgReqDTO extends MessageReqDTO {

    private TextContentDTO text;

    public TextMsgReqDTO(String to, String text) {
        super(to, "text");
        this.text = new TextContentDTO(text);
    }

    //==========================================================================
    // Getters and setters
    //==========================================================================

    public TextContentDTO getText() {
        return text;
    }

    public TextMsgReqDTO setText(TextContentDTO text) {
        this.text = text;
        return this;
    }

    //==========================================================================
    // Inner classes
    //==========================================================================

    public record TextContentDTO(String body) { }

}
