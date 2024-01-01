package com.resotech.TaskManager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TaskNotFoundException extends ResponseStatusException {

    public TaskNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Task Id %d Not Found", id));
    }

    public String getErrorMessage() {
        return getMessage();
    }
}
