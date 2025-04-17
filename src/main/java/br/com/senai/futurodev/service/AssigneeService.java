package br.com.senai.futurodev.service;

import br.com.senai.futurodev.model.entity.Assignee;
import br.com.senai.futurodev.model.exceptions.ResourceNotFoundException;
import br.com.senai.futurodev.repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssigneeService {

    @Autowired
    AssigneeRepository assigneeRepository;

    //Método para cadastrar um assignee
    public Assignee create(Assignee assignee){
        return assigneeRepository.save(assignee);
    }

    //Método para listar os assignee
    public List<Assignee> findAllAssignees(){
        return assigneeRepository.findAll();
    }

    //Método para listar um assignee pelo ID
    public Assignee findAssigneeById(Long id){
        return assigneeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Assignee not found with id " + id)
        );
    }

    //Método para atualizar um assignee
    public Assignee update(Long id, Assignee assigneeUpdate){
        Assignee existingAssignee = findAssigneeById(id);
        existingAssignee.setName(assigneeUpdate.getName());
        return assigneeRepository.save(existingAssignee);
    }

    //Método para deletar um assignee
    public void delete(Long id){
        Assignee assignee = findAssigneeById(id);
        assigneeRepository.delete(assignee);
    }
}
