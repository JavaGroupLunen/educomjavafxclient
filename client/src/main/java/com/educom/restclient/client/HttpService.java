package com.educom.restclient.client;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HttpService<E> {
    String updateschuler(Long id, E e);
    ResponseEntity<String> add(E e);
    String delete(Long id);
    List<E> findByName(String name);

}
