package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RestTemplateClient {

    static final String URL_UPDATE_LEHRE = "http://localhost:8080/api/lehre";
    @Autowired
    RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void deleteEmployee(Lehre lehre) {

        final String uri = "http://localhost:8080/api/deletebyId/{id}";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(lehre.getId()));
        restTemplate.delete(uri, params);
        System.out.println("removed");
    }

   public List<Lehre> findByEmailId(String emailId){

       final String uri = "http://localhost:8080/api/findByEmailId/{emailId}";
       Map<String, String> urlParameters = new HashMap<>();
    //   urlParameters.put("page", Integer.toString(page));
       urlParameters.put("emailId", emailId);
       ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
               Lehre[].class,
               urlParameters);
       return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

   }
    public List<Lehre> findByName(String firstname){

        final String uri = "http://localhost:8080/api/findByName/{firstname}";
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("firstname", firstname);
        ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
                Lehre[].class,
                urlParameters);
        return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

    }
    public List<Lehre> findByLastName(String lastname){

        final String uri = "http://localhost:8080/api/findByLastName/{lastname}";
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("lastname", lastname);
        ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
                Lehre[].class,
                urlParameters);
        return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

    }


    public String updateLehre(Lehre lehre) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Lehre> requestBody = new HttpEntity<>(lehre, headers);

        // Send request with PUT method.
        restTemplate.put(URL_UPDATE_LEHRE, requestBody);

        String resourceUrl = URL_UPDATE_LEHRE + "/" + lehre.getId();


        Lehre e = restTemplate.getForObject(resourceUrl, Lehre.class);

        if (e != null) {
            System.out.println("(Client side) Employee after update: ");
            return "Employee: " + e.getId() + " - " + e.getEmailId();
        }
        return "not successfull";
    }



}
