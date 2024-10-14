package com.task.Task.Management.dto;

import com.task.Task.Management.modal.Task;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @NotEmpty(message="Category Name should not be empty")
    private String categoryName;

    private List<Task> taskList;
}
