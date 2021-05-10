package com.example.circuitbreakerreading;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class B3Service {

    private final RestTemplate restTemplate;

    public B3Service(RestTemplate rest) {
        this.restTemplate = rest;
    }
    @HystrixCommand(fallbackMethod = "reliable", commandProperties={
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="12000")})
    public String getTicker(String ticker, String data) {

        URI uri = URI.create("https://arquivos.b3.com.br/apinegocios/ticker/" + ticker + "/" + data);

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String reliable(String ticker, String data) {
        return ticker + "(err)";
    }

}
