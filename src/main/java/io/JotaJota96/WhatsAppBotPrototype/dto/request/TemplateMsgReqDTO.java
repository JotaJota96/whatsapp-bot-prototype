package io.JotaJota96.WhatsAppBotPrototype.dto.request;

public class TemplateMsgReqDTO extends MessageReqDTO {

    private TemplateDTO template;

    //==========================================================================
    // Constructors
    //==========================================================================

    public TemplateMsgReqDTO(String to, String name, String language) {
        super(to, "template");
        this.template = new TemplateDTO(name, new LanguageDTO(language));
    }

    //==========================================================================
    // Getters and setters
    //==========================================================================

    public TemplateDTO getTemplate() {
        return template;
    }

    public TemplateMsgReqDTO setTemplate(TemplateDTO template) {
        this.template = template;
        return this;
    }

    //==========================================================================
    // Inner classes
    //==========================================================================

    public record TemplateDTO(String name, LanguageDTO language) { }

    public record LanguageDTO(String code) { }
}
