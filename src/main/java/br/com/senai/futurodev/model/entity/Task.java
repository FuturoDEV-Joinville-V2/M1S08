package br.com.senai.futurodev.model.entity;

import br.com.senai.futurodev.model.enums.TaskPriorityEnum;
import br.com.senai.futurodev.model.enums.TaskStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate startDate;
    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate endDate;
    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatusEnum status;
    @Column
    @Enumerated(EnumType.STRING)
    private TaskPriorityEnum priority;
    @ManyToOne
    @JoinColumn(name="fk_assignee")
    private Assignee assignee;
}
