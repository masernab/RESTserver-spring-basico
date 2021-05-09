package com.example.demo.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "product")
public class Product {
	@Id
	private final UUID id;
	@NonNull
	private final String name;
	private final String desc;
	private final double price;
	public Product(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("desc") String desc, @JsonProperty("price") double price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public double getPrice() {
		return price;
	}
	
}
