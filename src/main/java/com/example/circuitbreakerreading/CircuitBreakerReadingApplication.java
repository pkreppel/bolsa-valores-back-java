package com.example.circuitbreakerreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class CircuitBreakerReadingApplication {

  @Autowired
  private B3Service b3Service;
    private BookService bookService;

  @Bean
  public RestTemplate rest(RestTemplateBuilder builder) {
	return builder.build();
  }

  @RequestMapping("/to-read")
  public String toRead() {
	return bookService.readingList();
  }

  @CrossOrigin//(origins = "http://localhost:8081")
  @RequestMapping("/b3-ticker/{ticker}/{date}")
  public String getTicker(@PathVariable("ticker") String ticker, @PathVariable("date")  String date) {
      return b3Service.getTicker(ticker, date);
  }

  public static void main(String[] args) {
	SpringApplication.run(CircuitBreakerReadingApplication.class, args);
  }
}
