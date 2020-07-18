package com.educom.restclient.client;

import com.educom.restclient.model.Lehre;
import reactor.core.publisher.Flux;

public interface StockClient {
       Flux<Lehre> getLehreById(Long symbol);
       Flux<Lehre> getLehreList();
       Flux<Lehre> save(Lehre lehre);
}
