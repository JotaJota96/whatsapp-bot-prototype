package io.JotaJota96.WhatsAppBotPrototype.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.JotaJota96.WhatsAppBotPrototype.config.SecretProperties;
import io.JotaJota96.WhatsAppBotPrototype.dto.webhook.ValueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {

    @Autowired
    SecretProperties secretProperties;

    /**
     * Este método verifica el webhook de la aplicación.
     * @param mode        Este parámetro siempre debe ser "subscribe"
     * @param verifyToken El token debe coincidir con el especificado en la configuración
     * @param challenge   Valor aleatorio que debe ser devuelto a la API de WhatsApp
     * @return El valor de challenge si el token es correcto. Otra cosa en caso contrario.
     */
    public boolean verifyWebhook(String mode, String verifyToken, String challenge) {
        if ("subscribe".equals(mode) && secretProperties.getWebhookToken().equals(verifyToken)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este método convierte el JSON recibido por el webhook de String a un objeto ValueDTO que contiene los datos del evento.
     *
     * @param payloadJSON JSON recibido por el webhook
     * @return Objeto ValueDTO
     */
    public ValueDTO getValueDTO(String payloadJSON) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode valueNode = objectMapper.readTree(payloadJSON).at("/entry/0/changes/0/value");
        ValueDTO valueDTO = objectMapper.treeToValue(valueNode, ValueDTO.class);
        return valueDTO;
    }

}
