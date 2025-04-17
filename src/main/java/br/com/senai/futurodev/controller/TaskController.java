package br.com.senai.futurodev.controller;

import br.com.senai.futurodev.model.dtos.RequestTaskDTO;
import br.com.senai.futurodev.model.dtos.ResponseTaskDTO;
import br.com.senai.futurodev.model.entity.Task;
import br.com.senai.futurodev.service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ResponseTaskDTO>> list(){
        List<ResponseTaskDTO> tasks = this.taskService.findAllTasks().stream()
                .map(task -> modelMapper.map(task, ResponseTaskDTO.class)).collect(Collectors.toList());

        return tasks.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<ResponseTaskDTO> create(@RequestBody @Valid RequestTaskDTO taskDTO) throws Exception{
        Task task = modelMapper.map(taskDTO, Task.class);
        Task createdTask = taskService.create(task);
        ResponseTaskDTO createdTaskDTO = modelMapper.map(createdTask, ResponseTaskDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseTaskDTO> update(@PathVariable Long id,@RequestBody RequestTaskDTO taskDTO) throws Exception{
        Task task = modelMapper.map(taskDTO, Task.class);
        Task taskUpdate = this.taskService.update(id, task);
        ResponseTaskDTO taskUpdatedDTO = modelMapper.map(taskUpdate, ResponseTaskDTO.class);

        return ResponseEntity.ok(taskUpdatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.ok("Task deletada com sucesso!");
    }
}
