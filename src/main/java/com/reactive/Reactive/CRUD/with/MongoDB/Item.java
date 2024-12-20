package com.reactive.Reactive.CRUD.with.MongoDB;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data  // Lombok annotation to generate getters, setters, toString, equals, and hashCode methods automatically
public class Item {
    @Id
    private String id;
    private String name;
}

