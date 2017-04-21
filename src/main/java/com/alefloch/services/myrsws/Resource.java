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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// Jackson 2
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Path("home")
public class Resource {

	// --- text version
	// --- http://127.0.0.1:2222/home/hello_string
	@GET
	@Path("hello_string")
	public String whateverText() {
		return "Hello, world!";
	}

	// --- jackson json version
	// --- http://127.0.0.1:2222/home/hello_jackson
	@GET
	@Path("hello_jackson")
	@Produces(MediaType.APPLICATION_JSON)
	public Response whateverJSON() {

		
		Person person1 = new Person("joe1", "scarff street", 90007, "LA");
		Person person2 = new Person("joe2", "scarff street", 90007, "LA");
		Person person3 = new Person("joe3", "scarff street", 90007, "LA");
		Person person4 = new Person("joe4", "scarff street", 90007, "LA");

		ArrayList<Person> myPersonList = new ArrayList<Person>();
		myPersonList.add(person1);
		myPersonList.add(person2);
		myPersonList.add(person3);
		myPersonList.add(person4);

		ResponseObject responseObject = new ResponseObject(myPersonList);
		
		// Jackson: object to JSON in String
		ObjectMapper jacksonMapper = new ObjectMapper();
		jacksonMapper.enable(SerializationFeature.INDENT_OUTPUT);

		String jsonInString = null;
		try {
			jsonInString = jacksonMapper.writeValueAsString(responseObject);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok(jsonInString).build();
	}
}
