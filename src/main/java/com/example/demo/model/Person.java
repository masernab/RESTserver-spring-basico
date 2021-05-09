package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	private final UUID id;
	private final String name;
	private final int age;
	
	public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("age") int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}
