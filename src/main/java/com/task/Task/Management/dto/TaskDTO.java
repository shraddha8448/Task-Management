package com.task.Task.Management.dto;

import com.task.Task.Management.modal.Category;
import com.task.Task.Management.modal.User;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    @NotEmpty(message="Task Title should not be empty")
    private String title;

    @NotEmpty(message="Task description should not be empty")
    private String description;

    @FutureOrPresent
    private LocalDate dueDate;

    @NotEmpty(message="Task status should not be empty")
    private String status;

    @NotEmpty(message="Task priority should not be empty")
    private String priority;

    private User user;
    private Category category;

}
