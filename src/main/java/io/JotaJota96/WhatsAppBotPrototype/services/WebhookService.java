package io.JotaJota96.WhatsAppBotPrototype.services;

import io.JotaJota96.WhatsAppBotPrototype.config.SecretProperties;
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

}
