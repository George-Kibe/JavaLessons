package com.kibe.udemyAdvanced.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/")
public class MainController {
    @GetMapping("/")
    public String testServer(){
        return "Sever health Check: Server is Running Fine.";
    }
    @GetMapping("/test")
    public Map<String, String> serverTest() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Server health Check: Server is Running Fine.");
        return response;
    }
}
