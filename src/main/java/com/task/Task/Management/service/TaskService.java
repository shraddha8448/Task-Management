package com.task.Task.Management.service;

import com.task.Task.Management.dto.TaskDTO;
import com.task.Task.Management.modal.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    TaskDTO addTask(TaskDTO taskDTO);

    List<TaskDTO> getAllTask();

    TaskDTO getTaskById(long taskId);

    TaskDTO updateTask(long taskId, TaskDTO taskDTO);

    TaskDTO deleteTask(long taskId);

    TaskDTO getTaskByTitle(String title);

    List<TaskDTO> getTaskByDueDate(LocalDate dueDate);

    List<TaskDTO> getTaskByStatus(String status);

    List<TaskDTO> getTaskByPriority(String priority);

    List<TaskDTO> getTaskByCategory(String category);

    TaskDTO assignTaskToUser(long taskId, long userId);

    TaskDTO assignCategoryOfTask(long taskId, long categoryId);

    TaskDTO updateStatus(long taskID,String status);
}
