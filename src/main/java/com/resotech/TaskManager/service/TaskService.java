package com.resotech.TaskManager.service;

import com.resotech.TaskManager.dto.TaskDTO;
import com.resotech.TaskManager.entity.Task;
import com.resotech.TaskManager.exceptions.TaskNotFoundException;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    Task createTask(Task task);

    Task updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id) throws TaskNotFoundException;

//    void deleteTask(Long id)
}
