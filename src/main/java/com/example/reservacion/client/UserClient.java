package com.example.reservacion.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String AUTH_URL = "http://localhost:8080/api/auth/exists/";

    public boolean existeUsuario(String userId) {
        try {
            restTemplate.getForObject(AUTH_URL + userId, String.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
