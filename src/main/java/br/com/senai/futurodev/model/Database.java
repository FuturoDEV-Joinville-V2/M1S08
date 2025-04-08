package br.com.senai.futurodev.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Database {

    private static List<Task> tasks = new ArrayList<>();

    private Database(){}

    public static List<Task> list(){
        return Database.tasks;
    }
    //Para pesquisar uma Task
    public static Task search(Long id){
        Optional<Task> optionalTask = Database.tasks.stream()
                .filter(task -> task.getId().equals(id)).findFirst();

        return optionalTask.orElse(null);
    }

    //Para adicionar uma Task
    public static void add(Task task){
        Database.tasks.add(task);
    }

    //Para remover uma Task
    public static void delete(Long id){
        Database.tasks.removeIf(task -> task.getId().equals(id));
    }

    //Para atualizar uma Task
    public static Task update(Long id, Task task) throws Exception{
        Task taskToUpdate = Database.search(id);
        if(taskToUpdate != null){
            taskToUpdate.setDescription(
                task.getDescription() != null ? task.getDescription() : taskToUpdate.getDescription()
            );
            taskToUpdate.setEndDate(
                    task.getEndDate() != null ? task.getEndDate() : taskToUpdate.getEndDate()
            );
            taskToUpdate.setStatus(
                    task.getStatus() != null ? task.getStatus() : taskToUpdate.getStatus()
            );
            return taskToUpdate;
        }
        throw new Exception("A tarefa não foi encontrada!");
    }


}
