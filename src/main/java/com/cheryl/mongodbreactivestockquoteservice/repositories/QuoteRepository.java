package com.cheryl.mongodbreactivestockquoteservice.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cheryl.mongodbreactivestockquoteservice.domain.Quote;

/**
 * 
 * @author corcutt
 *
 */
public interface QuoteRepository extends ReactiveMongoRepository<Quote, String> {

}
