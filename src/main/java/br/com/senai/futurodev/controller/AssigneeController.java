package br.com.senai.futurodev.controller;

import br.com.senai.futurodev.model.dtos.RequestAssigneeDTO;
import br.com.senai.futurodev.model.dtos.ResponseAssigneeDTO;
import br.com.senai.futurodev.model.entity.Assignee;
import br.com.senai.futurodev.service.AssigneeService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignees")
public class AssigneeController {

    @Autowired
    AssigneeService assigneeService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Assignee> create(@RequestBody @Valid RequestAssigneeDTO assigneeDto){
        Assignee assignee = modelMapper.map(assigneeDto, Assignee.class); //mapear a classe dto em uma entity
        return ResponseEntity.status(HttpStatus.CREATED).body(assigneeService.create(assignee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseAssigneeDTO> update(@PathVariable Long id, @RequestBody @Valid RequestAssigneeDTO assigneeDTO){
        Assignee assignee = modelMapper.map(assigneeDTO, Assignee.class);
        Assignee assigneeUpdate = assigneeService.update(id, assignee);

        return ResponseEntity.ok(modelMapper.map(assigneeUpdate, ResponseAssigneeDTO.class));
    }
}
