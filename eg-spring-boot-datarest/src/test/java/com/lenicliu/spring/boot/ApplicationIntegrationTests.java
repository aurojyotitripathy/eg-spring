package com.lenicliu.spring.boot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class ApplicationIntegrationTests {

    private RestTemplate restTemplate = new TestRestTemplate();
    
    @Test
    public void testHome(){
    	ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080", String.class);
    	Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void testUsers(){
    	ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/users", String.class);
    	Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
    
    @Test
    public void testUsers1(){
    	ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/users/1", String.class);
    	Assert.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}