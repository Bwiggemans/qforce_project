package nl.qnh.qforce.domain.qforce_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    // Attribute
    private List<String> persons = new ArrayList<>();

    //Constructor
    public PersonController() {
        persons.add("Jan");
        persons.add("Klaas");
        persons.add("Frans");
        persons.add("Johan");
    }

    @GetMapping(value = "/persons")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getPersons(){
        return persons;
    }

    @GetMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getPerson(@PathVariable int id){
        return persons.get(id);
    }

    @DeleteMapping(value = "/persons/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletePerson(@PathVariable int id){
        persons.remove(id);
        return "Deleted";
    }

    @PostMapping(value = "/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public String addPerson(@RequestBody String person) {
        persons.add(person);
        return "Added!";
    }

}
