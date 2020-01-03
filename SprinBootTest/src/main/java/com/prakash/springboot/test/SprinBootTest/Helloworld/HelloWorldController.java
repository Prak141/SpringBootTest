package com.prakash.springboot.test.SprinBootTest.Helloworld;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException.NotImplemented;
//@Author Prakash Chidambaram
@RestController
public class HelloWorldController {
	@CrossOrigin(origins="http://localhost:8080")
	@GetMapping(path="/helloworld")
	public String HelloWorld() {
		return "Hello World";
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/helloworldbean")
	public Helloworldbean HelloWorldbean() {
		//throw new RuntimeException("Some Error occured at the service call");
		return new Helloworldbean("Hello World");
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping(path="/helloworldbean/path/{name}")
	public Helloworldbean HelloWorld(@PathVariable String name) {
		return new Helloworldbean(String.format("Hello World %s",name));
	}
}
