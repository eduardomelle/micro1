package br.com.micro1.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloResource {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello from Spring Boot!";
	}

	@RequestMapping("/chaining")
	public String chaining() {
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8081/hello", String.class);
		return "Chaining + " + response.getBody();
	}

}
