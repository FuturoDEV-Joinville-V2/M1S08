package br.com.senai.futurodev.service;

import br.com.senai.futurodev.model.Database;
import br.com.senai.futurodev.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    //Retorna a minha lista de tarefas cadastradas
    public List<Task> list(){
        return Database.list();
    }

    //Cadastrar a task no banco de dados
    public void create(Task task) throws Exception{
        if (task != null){
            Database.add(task);
        }else{
            throw new Exception("Objeto Task com estado null");
        }
    }

    //Atualizar uma task
    public Task update(Long id, Task task) throws Exception{
        return Database.update(id, task);
    }

    //Deletar uma task
    public void delete(Long id){
        Database.delete(id);
    }
}
