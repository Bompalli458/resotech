package com.resotech.TaskManager.controller;


import com.resotech.TaskManager.dto.TaskDTO;
import com.resotech.TaskManager.entity.Task;
import com.resotech.TaskManager.exceptions.TaskNotFoundException;
import com.resotech.TaskManager.repository.TaskRepository;
import com.resotech.TaskManager.service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/getAllTasks")
    public ResponseEntity<?> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>("No Tasks Found",HttpStatus.NOT_FOUND);
        }
        List<TaskDTO> taskDTO = tasks.stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(taskDTO);
    }
    @GetMapping("/{id}/getTaskById")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);

        if (task != null) {
            return ResponseEntity.ok(modelMapper.map(task, TaskDTO.class));
        }
        else {
            throw new TaskNotFoundException(id);
        }

    }
    @PostMapping("/createTask")
    public ResponseEntity<TaskDTO> createTask(@RequestBody @Valid TaskDTO taskDTO) {
        Task task=modelMapper.map(taskDTO, Task.class);
        Task createdTask = taskService.createTask(task);
        TaskDTO createdTaskDTO = modelMapper.map(createdTask, TaskDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTaskDTO);
    }

    @PutMapping("/{id}/updateTask")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDTO taskDTO) {
            taskDTO.setId(id);
            Task updatedTask = taskService.updateTask(id, taskDTO);
            if(updatedTask!=null){
                TaskDTO updatedTaskDTO = modelMapper.map(updatedTask, TaskDTO.class);
                return ResponseEntity.ok(updatedTaskDTO);
            }
            else {
            throw new TaskNotFoundException(id);
        }

    }
    @DeleteMapping("/{id}/deleteTask")
    public ResponseEntity<?> deleteTask(@PathVariable  Long id)  {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return new ResponseEntity<>(String.format("Task Id %d Deleted ",id),HttpStatus.OK);
        } else {
            throw new TaskNotFoundException(id);
        }
    }

}

