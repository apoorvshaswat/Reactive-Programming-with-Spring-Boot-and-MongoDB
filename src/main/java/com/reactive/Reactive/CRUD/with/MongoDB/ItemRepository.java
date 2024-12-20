package com.reactive.Reactive.CRUD.with.MongoDB;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface ItemRepository extends ReactiveMongoRepository<Item, String> {
    Mono<Item> findById(String id);
    Flux<Item> findAll();
}

