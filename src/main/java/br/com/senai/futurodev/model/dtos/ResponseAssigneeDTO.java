package br.com.senai.futurodev.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAssigneeDTO {
    private Long id;
    private String name;
}
