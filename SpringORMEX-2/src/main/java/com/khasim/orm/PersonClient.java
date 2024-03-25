package com.khasim.orm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.khasim.orm.Entity.Person;
import com.khasim.orm.Model.PersonDetails;
import com.khasim.orm.Repository.PersonRepository;

@Component
public class PersonClient implements CommandLineRunner{

	@Autowired
	PersonMapper mapper;
	@Autowired
	PersonRepository personRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		PersonDetails personDetails = new PersonDetails();
		personDetails.setFirstName("Dudekula");
		personDetails.setLastname("khasimvali");
		personDetails.setEmail("kv61460@gmail.com");
		personDetails.setAge(20);
		
		Person person = mapper.ModelToEntity(personDetails);
		personRepository.save(person);
				
				
		PersonDetails personDetails1 = new PersonDetails();
		personDetails1.setFirstName("Nakka");
		personDetails1.setLastname("Vamshi");
		personDetails1.setEmail("vamshi023@gmail.com");
		personDetails1.setAge(22);
		
		PersonDetails personDetails2 = new PersonDetails();
		personDetails2.setFirstName("kalathuru");
		personDetails2.setLastname("Viswa");
		personDetails2.setEmail("KasiViswa143@gmail.com");
		personDetails2.setAge(21);
		
		PersonDetails personDetails3 = new PersonDetails();
		personDetails3.setFirstName("Konidala");
		personDetails3.setLastname("PawanKalyan");
		personDetails3.setEmail("pspk143142@gmail.com");
		personDetails3.setAge(58);
		
		PersonDetails personDetails4 = new PersonDetails();
		personDetails4.setFirstName("Islamic");
		personDetails4.setLastname("Allah");
		personDetails4.setEmail("allah143@gmail.com");
		personDetails4.setAge(68);
		
		List<PersonDetails> personsDetails = List.of(personDetails1,personDetails2,personDetails3,personDetails4);
		List<Person> persons = mapper.modelToEntityConversion(personsDetails);
			
		personRepository.saveAll(persons);
		
		System.out.println("*****FINDALL*****");
		List<Person> pers = personRepository.findAll();
		for(Person person1 : pers) {
			System.out.println(person1);
			}
		
		System.out.println("******COUNT*****");
		Long count = personRepository.count();
		System.out.println("the record cound ="+count);
		
		System.out.println("*****EXISTINGOBJECT*******");
		boolean res = personRepository.existsById(1);
		System.out.println(res);
		
		 List<Person> personList = personRepository.findByEmail("kv61460@gmail.com");
	        personList.forEach(p -> System.out.println(p));
	        
	        System.out.println("****FIND BY FIRSTNAME*****");
	        Person person2 = personRepository.findByfirstName("kalathuru");
	        System.out.println(person2);
		
	        System.out.println("*****AGE BETWEEN*****");
	        List<Person> personList2 = personRepository.findByAgeBetween(20, 30);
	        personList2.forEach(p ->System.out.println(p));
	        
//		System.out.println("*****DELETEBY ID***");
//		personRepository.deleteById(2);
}
}