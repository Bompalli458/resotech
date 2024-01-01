package com.resotech.TaskManager.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name",nullable = false)
    @NotBlank(message = "Task Name should not be empty")
    private String taskName;

    @Column(name="description",nullable = false)
    @NotBlank(message = "Description should not be empty")
    private String description;

}
