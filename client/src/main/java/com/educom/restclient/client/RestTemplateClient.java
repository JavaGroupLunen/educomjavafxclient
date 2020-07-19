package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTemplateClient {

    private final RestTemplate restTemplate;
    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    static final String URL_UPDATE_LEHRE = "http://localhost:8080/api/lehre";

    public void deleteEmployee(Lehre lehre)
    {

        final String uri = "http://localhost:8080/api/deletebyId/{id}";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(lehre.getId()));
        restTemplate.delete ( uri,  params );
        System.out.println("removed");
    }

public String updateLehre(Lehre lehre){
    HttpHeaders headers = new HttpHeaders();
    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
    HttpEntity<Lehre> requestBody = new HttpEntity<>(lehre, headers);

    // Send request with PUT method.
    restTemplate.put(URL_UPDATE_LEHRE, requestBody, new Object[] {});

    String resourceUrl = URL_UPDATE_LEHRE + "/" + lehre.getId();


    Lehre e = restTemplate.getForObject(resourceUrl, Lehre.class);

    if (e != null) {
        System.out.println("(Client side) Employee after update: ");
         return "Employee: " + e.getId() + " - " + e.getEmailId();
    }
    return "not successfull";
}


}
