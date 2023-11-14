package io.JotaJota96.WhatsAppBotPrototype.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.JotaJota96.WhatsAppBotPrototype.config.SecretProperties;
import io.JotaJota96.WhatsAppBotPrototype.dto.request.TemplateMsgReqDTO;
import io.JotaJota96.WhatsAppBotPrototype.dto.response.MessageResDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SendingService {

    @Autowired
    SecretProperties secretProperties;

    private RestClient getRestClient() {
        return RestClient.builder()
                .baseUrl(secretProperties.getBaseURL())
                .defaultHeader("Authorization", "Bearer " + secretProperties.getApiToken())
                .build();
    }

    /**
     * Este método envía el template hello_world al número de teléfono especificado.
     *
     * @param phoneNumber  Número de teléfono al que se le enviará el template.
     */
    public void sendHelloWorldTemplate(String phoneNumber) {
        final String templateName = "hello_world";
        String resultStr;

        // Envío la petición a la API de WhatsApp y guardo la respuesta en un String
        try {
            System.out.println("Enviando el template '" + templateName + "' al número " + phoneNumber + "...");

            TemplateMsgReqDTO message = new TemplateMsgReqDTO(phoneNumber, templateName, "en_US");

            resultStr = this.getRestClient().post()
                    .uri("")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(message)
                    .retrieve()
                    .body(String.class);
        } catch (Exception e) {
            System.out.println("Error al enviar el template '" + templateName + "' al número " + phoneNumber + ": " + e.getMessage());
            throw new RuntimeException(e);
        }

        // Convierto lo devuelto por la API de WhatsApp a un DTO
        try {
            MessageResDTO result = new ObjectMapper().readValue(resultStr, MessageResDTO.class);
            String messageID = result.getMessages().get(0).id();
            String messageStatus = result.getMessages().get(0).message_status();
            System.out.println("Respuesta de la API de WhatsApp: Status: " + messageStatus + ", ID: " + messageID);
        } catch (Exception e) {
            System.out.println("Error al parsear la respuesta de la API de WhatsApp: " + resultStr + "\n" + e.getMessage());
        }
    }
}
