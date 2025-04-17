package br.com.senai.futurodev.model.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestAssigneeDTO{

        @NotBlank(message = "O nome do Assignee é obrigatório")
        private String name;

}
