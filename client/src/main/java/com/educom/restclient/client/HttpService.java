package com.educom.restclient.client;

import com.educom.restclient.model.Schuler;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

import java.util.List;

public interface HttpService<E> {
    String updateschuler(Long id, E e);
    ResponseEntity<String> add(E e);
    Flux<Schuler>  getById(Long symbol);
    Flux<Schuler> getList();
    String delete(Long id);
    List<E> findByName(String name);

}
