package com.resotech.TaskManager.serviceImpl;

import com.resotech.TaskManager.dto.TaskDTO;
import com.resotech.TaskManager.entity.Task;
import com.resotech.TaskManager.exceptions.TaskNotFoundException;
import com.resotech.TaskManager.repository.TaskRepository;
import com.resotech.TaskManager.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskServiceIMPL implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return (Task) taskRepository.findById(id).orElse(null);
    }

    public Task createTask(Task task) {
        return  taskRepository.save(task);
    }

    public Task updateTask(Long id, TaskDTO taskDTO) {
        if (taskRepository.existsById(id)) {
            Task existingTask = taskRepository.findById(id).orElse(null);
            if (existingTask != null) {
                modelMapper.map(taskDTO, existingTask);
                return taskRepository.save(existingTask);
            }else{
                throw new TaskNotFoundException(id);
            }
        }
        return null;
    }
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
