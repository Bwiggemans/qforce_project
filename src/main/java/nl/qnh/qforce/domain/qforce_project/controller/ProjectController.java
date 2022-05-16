package nl.qnh.qforce.domain.qforce_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @GetMapping(value = "/start")
    public String  startProject(){
        return "Start project, how are you?";
    }

    @GetMapping(value = "/stop")
    public String  stopProject(){
        return "Stop project, have a nice day!";
    }

}
