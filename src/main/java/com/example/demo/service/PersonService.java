package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {
	
	//PersonDao es una interfaz
	private final PersonDao personDao;
	
	//para inyeccion de dependencia en el constructor
	@Autowired
	//Como saber a que clase que implementa PersonDao se debe enviar?
	//R: se agrega @Qualifier en el contructor del servicio y @Repository en la clase
	public PersonService(@Qualifier("fakePersonDao") PersonDao personDao) {
		this.personDao = personDao;
	}

	public Person addPerson(UUID id, Person person) {
		return personDao.addPerson(id, person);
	}

	public Person addPerson(Person person) {
		return personDao.addPerson(person);
	}

	public List<Person> getPeople() {
		return personDao.getPeople();
	}

	public Optional<Person> getPersonById(UUID id) {
		return personDao.getPersonById(id);
	}

	public int updatePerson(UUID id, Person person) {
		return personDao.updatePerson(id, person);
	}

	public String deletePerson(UUID id) {
		return personDao.deletePerson(id);
	}
}
