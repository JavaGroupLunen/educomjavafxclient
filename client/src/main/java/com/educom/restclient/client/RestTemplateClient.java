package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class RestTemplateClient {

    static final String URL_UPDATE_LEHRE = "http://localhost:8082/api/lehre/updatelehre/{id}";
    static final String URL_FINDBYLASTNAME="http://localhost:8082/api/lehre/findByLastName/{lastname}";
    static final String URL_FINDBYFIRSNAME="http://localhost:8082/api/lehre/findByName/{firstname}";
    static final String URL_FINDBYEMAIL= "http://localhost:8082/api/lehre/findByEmailId/{emailId}";
    static final String URL_DELETEBYID="http://localhost:8082/api/lehre/deletebyId/{id}";
    @Autowired
    RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void deleteEmployee(Lehre lehre) {
        final String uri =URL_DELETEBYID;
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(lehre.getId()));
        restTemplate.delete(uri, params);
        System.out.println("removed");
    }

   public List<Lehre> findByEmailId(String emailId){
       final String uri = URL_FINDBYEMAIL;
       Map<String, String> urlParameters = new HashMap<>();
       urlParameters.put("emailId", emailId);
       ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
               Lehre[].class,
               urlParameters);
       return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

   }
    public List<Lehre> findByName(String firstname){
        final String uri =URL_FINDBYFIRSNAME;
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("firstname", firstname);
        ResponseEntity<Lehre[]> entity = restTemplate.getForEntity(uri,
                Lehre[].class,
                urlParameters);
        return entity.getBody() != null? Arrays.asList(entity.getBody()) :Collections.emptyList();

    }
    public List<Lehre> findByLastName(String lastname){

        final String uri = URL_FINDBYLASTNAME;
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
