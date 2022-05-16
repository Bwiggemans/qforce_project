package nl.qnh.qforce.domain.qforce_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NameController {

    // Attribute
    private List<String> names = new ArrayList<>();

    //Constructor
    public NameController() {
        names.add("Jan");
        names.add("Klaas");
        names.add("Frans");
        names.add("Johan");
    }

    @GetMapping(value = "/names")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getNames(){
        return names;
    }

    @GetMapping(value = "/names/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getName(@PathVariable int id){
        return names.get(id);
    }

    @DeleteMapping(value = "/names/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteName(@PathVariable int id){
        names.remove(id);
        return "Deleted";
    }

    @PostMapping(value = "/names")
    @ResponseStatus(HttpStatus.CREATED)
    public String addName(@RequestBody String name) {
        names.add(name);
        return "Added!";
    }

}
