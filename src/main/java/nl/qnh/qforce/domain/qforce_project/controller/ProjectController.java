package nl.qnh.qforce.domain.qforce_project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @GetMapping(value = "/start")
    @ResponseStatus(HttpStatus.OK)
    public String  startProject(){
        return "Start project, how are you?";
    }

    @GetMapping(value = "/stop")
    @ResponseStatus(HttpStatus.OK)
    public String  stopProject(){
        return "Stop project, have a nice day!";
    }

}
