package br.com.senai.futurodev.service;

import br.com.senai.futurodev.model.entity.Task;
import br.com.senai.futurodev.model.exceptions.ResourceNotFoundException;
import br.com.senai.futurodev.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    //Listar todas as tasks
    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    //Buscar uma task pelo id
    public Task findTaskById(Long id){
        return taskRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Task not found with id " + id)
        );
    }

    //Cadastrar a task no banco de dados
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    //Atualizar uma task
    public Task update(Long id, Task taskUpdate) {
        Task existingTask = findTaskById(id);
        existingTask.setDescription(taskUpdate.getDescription());
        existingTask.setEndDate(taskUpdate.getEndDate());
        existingTask.setStatus(taskUpdate.getStatus());
        existingTask.setPriority(taskUpdate.getPriority());
        existingTask.setAssignee(taskUpdate.getAssignee());
        return taskRepository.save(existingTask);
    }

    //Deletar uma task
    public void delete(Long id){
        Task task = findTaskById(id);
        taskRepository.delete(task);
    }
}
