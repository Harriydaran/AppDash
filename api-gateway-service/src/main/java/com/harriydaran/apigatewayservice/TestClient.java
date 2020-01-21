package com.harriydaran.apigatewayservice;

import org.springframework.web.client.RestTemplate;

public class TestClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String id = "3";
        User user = restTemplate.getForObject("http://user-service:8080/api/v1/users/" + id, User.class);
        System.out.println(user.getFirstName());
        System.out.println(user.getAddress().getCountry());
    }



}
