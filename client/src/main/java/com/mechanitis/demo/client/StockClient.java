package com.mechanitis.demo.client;

import reactor.core.publisher.Flux;

public interface StockClient {
       Flux<Lehre> getLehreById(Long symbol);
       Flux<Lehre> getLehreList();
       Flux<Lehre> save(Lehre lehre);
}
