package com.task.Task.Management.controller;

import com.task.Task.Management.dto.TaskDTO;
import com.task.Task.Management.modal.Task;
import com.task.Task.Management.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public TaskDTO addTask(@Valid @RequestBody TaskDTO taskDTO){
        return taskService.addTask(taskDTO);
    }

    @GetMapping("/getAllTask")
    public List<TaskDTO> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/getTaskById/{taskId}")
    public TaskDTO getTaskById(@PathVariable long taskId){
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/update/{taskId}")
    public TaskDTO updateTask(@PathVariable long taskId,@Valid @RequestBody TaskDTO taskDTO){
        return taskService.updateTask(taskId,taskDTO);
    }

    @DeleteMapping("/delete/{taskId}")
    public TaskDTO deleteTask(@PathVariable long taskId){
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/getByTitle/{title}")
    public TaskDTO getTaskByTitle(@PathVariable String title){
        return taskService.getTaskByTitle(title);
    }

    @GetMapping("/getByDueDate/{dueDate}")
    public List<TaskDTO> getTaskByDueDate(@PathVariable LocalDate dueDate){
        return taskService.getTaskByDueDate(dueDate);
    }

    @GetMapping("/getTaskByStatus/{status}")
    public List<TaskDTO> getTaskByStatus(@PathVariable String status){
        return taskService.getTaskByStatus(status);
    }

    @GetMapping("/getTaskByPriority/{priority}")
    public List<TaskDTO> getTaskByPriority(@PathVariable String priority){
        return taskService.getTaskByPriority(priority);
    }

    @GetMapping("/getTaskByCategory/{category}")
    public List<TaskDTO> getTaskByCategory(@PathVariable String category){
        return taskService.getTaskByCategory(category);
    }

    @PutMapping("/assignUser/{taskId}/{userId}")
    public TaskDTO assignUserToTask(@PathVariable long taskId, @PathVariable long userId){
        return taskService.assignTaskToUser(taskId,userId);
    }

    @PutMapping("/assignCategory/{taskId}/{categoryId}")
    public TaskDTO assignCategoryToTask(@PathVariable long taskId, @PathVariable long categoryId){
        return taskService.assignCategoryOfTask(taskId,categoryId);
    }
}
