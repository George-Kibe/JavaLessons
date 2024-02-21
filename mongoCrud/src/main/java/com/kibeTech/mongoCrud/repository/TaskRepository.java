package com.kibeTech.mongoCrud.repository;

import com.kibeTech.mongoCrud.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);
    @Query("{assignee: ?0 }")
    // @Query("{assignee: ?0, filedName: ?1 }")
    List<Task> getTasksByAssignee(String assignee);

}
