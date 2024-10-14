package com.task.Task.Management.repository;

import com.task.Task.Management.modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    Task findByTitle(String title);

    List<Task> findByDueDate(LocalDate dueDate);

    List<Task> findByStatus(String status);

    List<Task> findByPriority(String priority);

    List<Task> findByCategory(String category);

}
