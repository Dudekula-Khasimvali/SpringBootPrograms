package com.khasim.orm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.khasim.orm.Entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	List<Person>  findByEmail(String email);

	public Person findByfirstName(String string);
	
	List<Person> findByAgeBetween(int minage,int maxage);
	
	List<Person> findBycreateBy(String name);
	
}