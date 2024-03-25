package com.khasim.orm.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDetails {

	private int id;
	private String firstName;
	private String lastname;
	private String email;
	private int age;
}