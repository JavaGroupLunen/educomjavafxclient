package com.mechanitis.demo.client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockClient {
       Flux<Lehre> getLehreById(Long symbol);
        Flux<Lehre> getLehreList();
}
