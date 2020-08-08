package com.educom.restclient.client;


import com.educom.restclient.model.Kurs;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

@Log4j2
public class KursClient implements HttpService<Kurs> {
    static final String URL_UPDATE_Kurs = "http://localhost:8082/api/kurs/updateKurs/{id}";
    static final String URL_FINDBYLASTNAME = "http://localhost:8082/api/kurs/findByLastName/{lastname}";
    static final String URL_FINDBYFIRSNAME = "http://localhost:8082/api/kurs/findByName/{firstname}";
    static final String URL_FINDBYEMAIL = "http://localhost:8082/api/kurs/findByEmail/{email}";
    static final String URL_DELETEBYID = "http://localhost:8082/api/kurs/deletebyId/{id}";
    static final String URL_ADDKurs = "http://localhost:8082/api/kurs/kurs";
    static final String URL_KursLIST = "http://localhost:8082/api/kurs/Kurslist";
    static final String URL_GETBYID = "http://localhost:8082/api/kurs/{id}";
//    @Autowired
//    private final WebClient webClient;
    @Autowired
    RestTemplate restTemplate;


    public KursClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    @Override
    public String delete(Long id) {
        final String uri = URL_DELETEBYID;
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        System.out.println(id);
        restTemplate.delete(uri, params);
        return "removed";
    }



    @Override
    public List<Kurs> findByName(String firstname) {
        final String uri = URL_FINDBYFIRSNAME;
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("firstname", firstname);
        ResponseEntity<Kurs[]> entity = restTemplate.getForEntity(uri,
                Kurs[].class,
                urlParameters);
        return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();

    }

    public List<Kurs> findByLastName(String lastname) {

        final String uri = URL_FINDBYLASTNAME;
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("lastname", lastname);
        ResponseEntity<Kurs[]> entity = restTemplate.getForEntity(uri,
                Kurs[].class,
                urlParameters);
        return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();

    }



    @Override
    public String update(Long id, Kurs kurs) {
        final String uri = URL_UPDATE_Kurs;
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", String.valueOf(id));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(uri, kurs, params);
        return "updated";
    }

    @Override
    public ResponseEntity<String> add(Kurs kurs) {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = null;
        try {
            final String baseUrl = URL_ADDKurs;
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(kurs);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, kurs, String.class);
        return result;
    }


    public List<Kurs> findByLehre(String lehre) {
        final String uri = URL_FINDBYLASTNAME;
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("lehre", lehre);
        ResponseEntity<Kurs[]> entity = restTemplate.getForEntity(uri,
                Kurs[].class,
                urlParameters);
        return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();
    }

    public List<Kurs> findByRaum(String raum) {
        final String uri = URL_FINDBYLASTNAME;
        Map<String, String> urlParameters = new HashMap<>();
        urlParameters.put("raum", raum);
        ResponseEntity<Kurs[]> entity = restTemplate.getForEntity(uri,
                Kurs[].class,
                urlParameters);
        return entity.getBody() != null ? Arrays.asList(entity.getBody()) : Collections.emptyList();
    }


}
