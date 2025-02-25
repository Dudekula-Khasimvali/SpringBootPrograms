package com.khasim.orm;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.khasim.orm.Entity.Person;
import com.khasim.orm.Model.PersonDetails;

@Component
public class PersonMapper {

	public Person ModelToEntity(PersonDetails personDetails) {
		
		Person person = new Person();
		person.setId(personDetails.getId());
		person.setFirstName(personDetails.getFirstName());
		person.setLastname(personDetails.getLastname());
		person.setEmail(personDetails.getEmail());
		person.setAge(personDetails.getAge());
		person.setCreatBy(System.getProperty("user.name"));
		person.setCreateAt(LocalDateTime.now());
		
		return person;
		
	}

	
public List<Person> modelToEntityConversion(List<PersonDetails> personDetailsList) {
	List<Person> persons = new ArrayList<>();
	
	for (PersonDetails proDetails : personDetailsList) {
		Person person = new Person();
		person.setId(proDetails.getId());
		person.setFirstName(proDetails.getFirstName());
		person.setLastname(proDetails.getLastname());
		person.setEmail(proDetails.getEmail());
		person.setAge(proDetails.getAge());
		person.setCreatBy(System.getProperty("user.name"));
		person.setCreateAt(LocalDateTime.now());
		persons.add(person); 
	}
	
	return persons;
}

}