package br.com.senai.futurodev.model;

import br.com.senai.futurodev.model.enums.TaskPriorityEnum;
import br.com.senai.futurodev.model.enums.TaskStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public TaskPriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(TaskPriorityEnum priority) {
        this.priority = priority;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }
}
