package com.example.demo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Resources for API
@RestController
@RequestMapping(path = "api/")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service){
        this.service = service;
    }

    @GetMapping(path = "{questionNumber}")
    public void firstQuestion(@PathVariable String questionNumber) {
        service.callFirst();
    }

    @GetMapping(path = "{questionNumber}")
    public void secondQuestion(@PathVariable String questionNumber) {
        service.callSecond();
    }

}
