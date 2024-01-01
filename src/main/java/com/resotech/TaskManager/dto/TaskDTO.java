package com.resotech.TaskManager.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private long id;

    @NotBlank(message = "Task Name should not be empty")
    private String taskName;

    @NotBlank(message = "Description should not be empty")
    private String description;
}
