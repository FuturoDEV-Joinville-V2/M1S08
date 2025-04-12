package br.com.senai.futurodev.service;

import br.com.senai.futurodev.model.Assignee;
import br.com.senai.futurodev.repository.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssigneeService {

    @Autowired
    AssigneeRepository assigneeRepository;

    //Cadastrar
    public Assignee create(Assignee assignee){
        return assigneeRepository.save(assignee);
    }
}
