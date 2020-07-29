package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RestTemplateClient {

    static final String URL_UPDATE_LEHRE = "http://localhost:8082/api/updatelehre/{id}";
    @Autowired
    RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void deleteEmployee(Lehre lehre) {

        final String uri = "http://localhost:8082/api/deletebyId/{id}";
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(lehre.getId()));
        restTemplate.delete(uri, params);
        System.out.println("removed");
    }

   public List<Lehre> findByEmailId(String emailId){

       final String uri = "http://localhost:8082/api/findByEmailId/{emailId}";
       Map<String, String> urlParameters = new HashMap<>();
    //   urlParameters.put("page", Integer.toString(page));
       urlParameters.put("emailId", emailId);
       ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
               Lehre[].class,
               urlParameters);
       return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

   }
    public List<Lehre> findByName(String firstname){

        final String uri = "http://localhost:8082/api/findByName/{firstname}";
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("firstname", firstname);
        ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
                Lehre[].class,
                urlParameters);
        return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

    }
    public List<Lehre> findByLastName(String lastname){

        final String uri = "http://localhost:8082/api/findByLastName/{lastname}";
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("lastname", lastname);
        ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
                Lehre[].class,
                urlParameters);
        return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

    }


    public String updateLehre(Long id,Lehre lehre) {
        final String uri =URL_UPDATE_LEHRE;
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, lehre, params);
        return "success";
    }



}
