package com.resotech.TaskManager.repository;

import com.resotech.TaskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);

    void deleteById(Long id);

    boolean existsById(Long id);
}
