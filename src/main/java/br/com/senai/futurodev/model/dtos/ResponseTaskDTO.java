package br.com.senai.futurodev.model.dtos;

import br.com.senai.futurodev.model.entity.Assignee;
import br.com.senai.futurodev.model.enums.TaskPriorityEnum;
import br.com.senai.futurodev.model.enums.TaskStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTaskDTO {

    private Long id;
    private String description;
    private LocalDate startDate;
    private TaskStatusEnum status;
    private TaskPriorityEnum priority;
    private Assignee assignee;
}
