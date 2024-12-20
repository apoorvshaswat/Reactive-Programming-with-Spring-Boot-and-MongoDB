package com.reactive.Reactive.CRUD.with.MongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Flux<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Mono<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    public Mono<Item> createItem(Item item) {
        return itemRepository.save(item);  // Save item to MongoDB
    }

    public Mono<Item> updateItem(String id, Item updatedItem) {
        return itemRepository.findById(id)
                .flatMap(item -> {
                    item.setName(updatedItem.getName());
                    return itemRepository.save(item);  // Save the updated item
                });
    }

    public Mono<Void> deleteItem(String id) {
        return itemRepository.deleteById(id);  // Delete item by id
    }
}

