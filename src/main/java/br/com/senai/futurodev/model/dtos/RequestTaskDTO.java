package br.com.senai.futurodev.model.dtos;

import br.com.senai.futurodev.model.entity.Assignee;
import br.com.senai.futurodev.model.enums.TaskPriorityEnum;
import br.com.senai.futurodev.model.enums.TaskStatusEnum;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTaskDTO {
    @NotBlank(message = "Descrição da Task é obrigatória")
    private String description;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "A data final deve ser uma data atual ou no futuro")
    private LocalDate endDate;

    @NotNull
    private TaskStatusEnum status;

    @NotNull
    private TaskPriorityEnum priority;

    @NotNull
    private Assignee assignee;
}
