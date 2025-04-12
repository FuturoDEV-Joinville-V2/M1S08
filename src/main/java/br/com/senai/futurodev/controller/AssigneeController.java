package br.com.senai.futurodev.controller;

import br.com.senai.futurodev.model.Assignee;
import br.com.senai.futurodev.service.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/assignee")
public class AssigneeController {

    @Autowired
    AssigneeService assigneeService;

    @PostMapping
    public ResponseEntity<Assignee> create(@RequestBody Assignee assignee){
        return ResponseEntity.status(HttpStatus.CREATED).body(assigneeService.create(assignee));
    }
}
