package com.cheryl.mongodbreactivestockquoteservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cheryl.mongodbreactivestockquoteservice.client.StockQuoteClient;
import com.cheryl.mongodbreactivestockquoteservice.domain.Quote;

import reactor.core.publisher.Flux;

/**
 * 
 * 
 * @author corcutt
 *
 * CommandLineRunner is special SpringBoot class
 * Will run on startup anything that implements CommandLineRunner.
 * If comment out @Component, will not start, so will not stream quotes.
 * 
 */
@Component
public class QuoteRunner implements CommandLineRunner {

  private final StockQuoteClient stockQuoteClient;
  
  public QuoteRunner(StockQuoteClient stockQuoteClient) {
    this.stockQuoteClient = stockQuoteClient;
  }
  
  @Override
  public void run(String... args) throws Exception {
    Flux<Quote> quoteFlux = stockQuoteClient.getQuoteStream();
    // nothing happens until we request data
    quoteFlux.subscribe(System.out::println);
  }

}
