package nl.qnh.qforce.domain.qforce_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    public List<String> getNames(){
        return names;
    }

    @GetMapping(value = "/names/{id}")
    public String getName(@PathVariable int id){
        return names.get(id);
    }

}
