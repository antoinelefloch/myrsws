/**
 *
 * Description: 
 *
 * Note: You can copy this source code, but you need to keep these 2 lines in your file header.
 * author:  https://github.com/antoinelefloch
 *
 */
package com.alefloch.services.myrsws;

import java.util.ArrayList;
import java.util.List;

public class ResponseObject {
	
	private List<Person> persons = null;
	
	public ResponseObject() {
	}
	
	public ResponseObject(ArrayList<Person> persons) {
		this.persons = persons;
	}
	
	// need these getter/setter for Jackson serialization to work
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public void addPerson(Person person) {
		this.persons.add(person);
	}

}
