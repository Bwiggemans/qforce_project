package nl.qnh.qforce.domain.qforce_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestSpringBootController {

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/callclienthello")
    private String getHelloClient(){
        String uri = "http://localhost:8081/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/people")
    public List<Object> getPeople(){
        String url = "https://swapi.dev/api/people/";
        RestTemplate restTemplate = new RestTemplate();

        Object[] people = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(people);
    }
}
