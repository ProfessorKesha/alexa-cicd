package com.keysoft.alex.alexacicd;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlexaController {
    @RequestMapping("/message")
    public String message(@RequestParam(value="text", defaultValue="Hello World") String message) {
        return message;
    }
}
