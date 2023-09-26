package com.kodilla.rentalfe.vehicles.service;

import org.springframework.web.client.RestTemplate;

public class CurrenciesService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8084/v1/currencies";

}
