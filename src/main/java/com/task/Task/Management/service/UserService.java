package com.task.Task.Management.service;

import com.task.Task.Management.dto.UserDTO;
import com.task.Task.Management.modal.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    UserDTO addUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(long userId);

    UserDTO updateUser(long userId, UserDTO userDTO);

    UserDTO removeUser(long userid);

    List<UserDTO> getUserByName(String userName);

    UserDTO getUserByEmail(String userEmail);
}
