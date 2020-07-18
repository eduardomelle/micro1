package br.com.micro1.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonResource {

	private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/person")
	public String getPerson() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:8082/address",
				String.class);

		// ResponseEntity<String> re = restTemplate.getForEntity("http://127.0.0.1:8080/micro3-0.0.1-SNAPSHOT/phone", String.class);

		LOG.info("PERSON");
		LOG.warn("PERSON");
		LOG.error("PERSON");

		return "Eduardo Orlandi Melle - " + responseEntity.getBody() + " - (11) 99620-1490";
	}

}
