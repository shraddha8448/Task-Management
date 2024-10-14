package com.task.Task.Management.exception;

import com.task.Task.Management.modal.Task;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(String msg) {
        super(msg);
    }

}