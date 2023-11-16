package io.JotaJota96.WhatsAppBotPrototype.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping({"", "/", "/api", "/status"})
    public String index() {
        return "App is running!";
    }

}
