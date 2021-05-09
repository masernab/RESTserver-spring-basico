package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {
	
	Person addPerson(UUID id, Person person);
	default Person addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return addPerson(id, person);
	}
	public List<Person> getPeople();
	public Optional<Person> getPersonById(UUID id);
	public int updatePerson(UUID id, Person person);
	public String deletePerson(UUID id);
}
