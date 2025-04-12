package br.com.senai.futurodev.service;

import br.com.senai.futurodev.model.Database;
import br.com.senai.futurodev.model.Task;
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
    public List<Task> ready(){
        return taskRepository.findAll();
    }

    //Cadastrar a task no banco de dados
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    //Atualizar uma task
    public Task update(Long id, Task taskUpdate) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isPresent()){
            task.get().setDescription(taskUpdate.getDescription());
            task.get().setStatus(taskUpdate.getStatus());
            task.get().setEndDate(taskUpdate.getEndDate());
            taskRepository.save(task.get());
        }

        return task.get();
    }

    //Deletar uma task
    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
