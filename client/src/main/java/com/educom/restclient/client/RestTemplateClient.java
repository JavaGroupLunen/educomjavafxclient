package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTemplateClient {

    private final RestTemplate restTemplate;
    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public void deleteEmployee(Lehre lehre)
    {

        final String uri = "http://localhost:8080/api/deletebyId/{id}";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(lehre.getId()));
        restTemplate.delete ( uri,  params );
        System.out.println("removed");
    }

}
