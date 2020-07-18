package com.educom.restclient.client;

import com.educom.restclient.client.StockClient;
import com.educom.restclient.model.Lehre;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Log4j2
public class WebClientStockClient implements StockClient {
    private final WebClient webClient;

    public WebClientStockClient(WebClient webClient) {
        this.webClient = webClient;
    }

//    @Override
//    public Flux<StockPrice> pricesFor(String symbol) {
//        log.info("WebClientStockClient");
//        return webClient.get()
//                        .uri("http://localhost:8080/lehre/{symb}", symbol)
//                        .retrieve()
//                        .bodyToFlux(StockPrice.class)
//                        .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
//                        .doOnError(IOException.class,
//                                   e -> log.info(() -> "Closing stream for " + symbol + ". Received " + e.getMessage()));
//    }


    @Override
    public Flux<Lehre> getLehreById(Long id) {
        log.info("WebClientStockClient");
        return webClient.get()
                .uri("localhost:8080/api/getbyId/{id}", id)
                .retrieve()
                .bodyToFlux(Lehre.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + id + ". Received " + e.getMessage()));
    }

    @Override
    public Flux<Lehre> getLehreList() {
        log.info("WebClientStockClient");
        return webClient.get()
                .uri("localhost:8080/api/lehrelist")
                .retrieve()
                .bodyToFlux(Lehre.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + ". Received " + e.getMessage()));
    }

    @Override
    public Flux<Lehre> save(Lehre lehre) {
        return webClient.post()
                .uri("localhost:8080/api/lehre")
                .retrieve()
                .bodyToFlux(Lehre.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + ". Received " + e.getMessage()));
    }

    public ResponseEntity<String> saveLehre(Lehre lehre) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = null;
        try {
            final String baseUrl = "http://localhost:8080/api/lehre";
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();        }


        ResponseEntity<String> result = restTemplate.postForEntity(uri, lehre, String.class);
        return result;
    }
}
