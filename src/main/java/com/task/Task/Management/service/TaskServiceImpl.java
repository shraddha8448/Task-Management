package com.task.Task.Management.service;

import com.task.Task.Management.dto.TaskDTO;
import com.task.Task.Management.exception.CategoryNotFoundException;
import com.task.Task.Management.exception.TaskNotFoundException;
import com.task.Task.Management.exception.UserNotFoundException;
import com.task.Task.Management.modal.Category;
import com.task.Task.Management.modal.Task;
import com.task.Task.Management.modal.User;
import com.task.Task.Management.repository.CategoryRepository;
import com.task.Task.Management.repository.TaskRepository;
import com.task.Task.Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public TaskDTO mapToTaskDTO(Task task){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setPriority(task.getPriority());
        taskDTO.setDueDate(task.getDueDate());

        return taskDTO;
    }

    @Override
    public TaskDTO addTask(TaskDTO taskDTO){

        Task task = new Task();

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());
        task.setDueDate(taskDTO.getDueDate());

        return  mapToTaskDTO(taskRepository.save(task));
    }

    @Override
    public List<TaskDTO> getAllTask(){
        List<Task> taskList = taskRepository.findAll();

        return taskList.stream()
                .map(this::mapToTaskDTO)
                .toList();
    }

    @Override
    public TaskDTO getTaskById(long taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task Not found"));

        return mapToTaskDTO(task);
    }

    @Override
    public TaskDTO updateTask(long taskId, TaskDTO taskDTO){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task Not found"));

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setPriority(taskDTO.getPriority());
        task.setDueDate(taskDTO.getDueDate());

        return mapToTaskDTO(taskRepository.save(task));
    }

    @Override
    public TaskDTO deleteTask(long taskId){

        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task Not found"));
        taskRepository.deleteById(taskId);

        return mapToTaskDTO(task);
    }

    @Override
    public TaskDTO getTaskByTitle(String title){
        return  mapToTaskDTO(taskRepository.findByTitle(title));
    }

    @Override
    public List<TaskDTO> getTaskByDueDate(LocalDate dueDate){
        List<Task> taskList = taskRepository.findByDueDate(dueDate);

        return taskList.stream().map(this::mapToTaskDTO).toList();
    }

    // get Task by status
    @Override
    public List<TaskDTO> getTaskByStatus(String status){
        List<Task> taskList = taskRepository.findByStatus(status);
        return taskList.stream().map(this::mapToTaskDTO).toList();
    }

    // get task by priority
    @Override
    public List<TaskDTO> getTaskByPriority(String priority){
        List<Task> taskList = taskRepository.findByPriority(priority);
        return taskList.stream().map(this::mapToTaskDTO).toList();
    }

    // get task by category
    @Override
    public List<TaskDTO> getTaskByCategory(String category){
        List<Task> taskList = taskRepository.findByCategory(category);
        return taskList.stream().map(this::mapToTaskDTO).toList();
    }


    // assign the task to the user
    @Override
    public TaskDTO assignTaskToUser(long taskId, long userId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task Not Found"));
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));

        task.setUser(user);
        return mapToTaskDTO(taskRepository.save(task));
    }

    // category of the task
    @Override
    public TaskDTO assignCategoryOfTask(long taskId, long categoryId){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task not found"));
        Category category = categoryRepository.findById(categoryId).orElseThrow(()->new CategoryNotFoundException("Category not found"));

        task.setCategory(category);
        return  mapToTaskDTO(taskRepository.save(task));
    }

    // update the task status
    @Override
    public TaskDTO updateStatus(long taskId,String status){
        Task task = taskRepository.findById(taskId).orElseThrow(()->new TaskNotFoundException("Task not found"));
        task.setStatus(status);

        return mapToTaskDTO(taskRepository.save(task));
    }
}
