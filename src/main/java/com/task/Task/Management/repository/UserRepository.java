package com.task.Task.Management.repository;

import com.task.Task.Management.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUserName(String userName);

    User findByUserEmail(String userEmail);
}
