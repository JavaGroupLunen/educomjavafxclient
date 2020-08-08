package com.educom.restclient.client;

import com.educom.restclient.model.Kurs;
import com.educom.restclient.model.Lehre;
import com.educom.restclient.model.Schuler;
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


    @Override
    public Flux<Lehre> getLehreById(Long id) {
        log.info("WebClientStockClient");
        return webClient.get()
                .uri("localhost:8082/api/lehre/getbyId/{id}", id)
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
                .uri("localhost:8082/api/lehre/lehrelist")
                .retrieve()
                .bodyToFlux(Lehre.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + ". Received " + e.getMessage()));
    }

    public Flux<Schuler> getSchulerList() {
        log.info("WebClientStockClient");
        return webClient.get()
                .uri("localhost:8082/api/schuler/schulerlist")
                .retrieve()
                .bodyToFlux(Schuler.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + ". Received " + e.getMessage()));
    }

    public Flux<Kurs> getKursList() {
        log.info("WebClientStockClient");
        return webClient.get()
                .uri("localhost:8082/api/kurs/kurslist")
                .retrieve()
                .bodyToFlux(Kurs.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + ". Received " + e.getMessage()));
    }

    @Override
    public Flux<Lehre>  delete(Lehre lehre) {
        log.info("WebClientStockClient");
        return webClient.delete()
                .uri("localhost:8082/api/lehre/deletebyId/{id}", lehre.getId())
                .retrieve()
                .bodyToFlux(Lehre.class)
                .retryBackoff(5, Duration.ofSeconds(1), Duration.ofSeconds(5))
                .doOnError(IOException.class,
                        e -> log.info(() -> "Closing stream for " + lehre + ". deleted " + e.getMessage())).log();



    }
    @Override
    public ResponseEntity<String> saveLehre(Lehre lehre)  {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = null;
        try {
            final String baseUrl = "http://localhost:8082/api/lehre/lehre";
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();        }


        ResponseEntity<String> result = restTemplate.postForEntity(uri, lehre, String.class);
        return result;
    }




}
