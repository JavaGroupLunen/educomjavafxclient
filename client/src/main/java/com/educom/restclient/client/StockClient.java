package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;

public interface StockClient {
       Flux<Lehre> getLehreById(Long symbol);
       Flux<Lehre> getLehreList();
       ResponseEntity<String> saveLehre(Lehre lehre);
       Flux<Lehre> delete(Lehre lehre);
}
