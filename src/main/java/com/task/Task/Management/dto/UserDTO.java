package com.task.Task.Management.dto;

import com.task.Task.Management.modal.Task;
import com.task.Task.Management.modal.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty(message="User Name should not be empty")
    private String userName;

    @Email(message = "Invalid Email")
    private String userEmail;

    @NotEmpty(message="Password should not be empty")
    private String password;


    private List<Task> taskList;
}
