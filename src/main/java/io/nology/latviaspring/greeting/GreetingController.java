package io.nology.latviaspring.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/greet")
public class GreetingController {
	@GetMapping
	public String greet() { 
		return "Hello world";
	}
}
