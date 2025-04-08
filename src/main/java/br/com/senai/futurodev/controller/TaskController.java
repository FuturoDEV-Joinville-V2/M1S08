package br.com.senai.futurodev.controller;

import br.com.senai.futurodev.model.Task;
import br.com.senai.futurodev.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> list(){
        List<Task> tasks = this.taskService.list();
        return tasks.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) throws Exception{
        this.taskService.create(task);
        return ResponseEntity.ok(task);
        // return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id,@RequestBody Task task) throws Exception{
        Task taskUpdate = this.taskService.update(id, task);
        return ResponseEntity.ok(taskUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.taskService.delete(id);
        return ResponseEntity.ok("Task deletada com sucesso!");
    }
}
