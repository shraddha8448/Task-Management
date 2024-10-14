package com.task.Task.Management.service;

import com.task.Task.Management.dto.UserDTO;
import com.task.Task.Management.exception.UserNotFoundException;
import com.task.Task.Management.modal.User;
import com.task.Task.Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public UserDTO mapToUserDTO(User user){

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setPassword(user.getPassword());

        return  userDTO;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {

        User user = new User();

        user.setUserName(userDTO.getUserName());
        user.setUserEmail(userDTO.getUserEmail());
        user.setPassword(userDTO.getPassword());

        return mapToUserDTO(userRepository.save(user));
    }


    @Override
    public List<UserDTO> getAllUsers() {

        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(this::mapToUserDTO)
                .toList();
    }

    @Override
    public UserDTO getUserById(long userId) {

        return mapToUserDTO(userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User Not Found")));
    }

    @Override
    public UserDTO updateUser(long userId, UserDTO userDTO){

        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));

        user.setUserName(userDTO.getUserName());
        user.setUserEmail(userDTO.getUserEmail());
        user.setPassword(userDTO.getPassword());

        return mapToUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO removeUser(long userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));
        userRepository.deleteById(userId);
        return  mapToUserDTO(user);
    }

    @Override
    public List<UserDTO> getUserByName(String userName) {
        List<User> users = userRepository.findByUserName(userName);
        if (users.isEmpty()) {
            throw new RuntimeException("No USer found with name: " + userName);
        }
        return users.stream()
                .map(this::mapToUserDTO)
                .toList();
    }


    @Override
    public UserDTO getUserByEmail(String userEmail){
        User user = userRepository.findByUserEmail(userEmail);
        return  mapToUserDTO(user);
    }
}
