package com.kibeTech.mongoCrud.service;

import com.kibeTech.mongoCrud.model.Task;
import com.kibeTech.mongoCrud.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    // CRUD Operations here
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }
    public List<Task> findAllTasks(){
        return repository.findAll();
    }
    public Task getTaskById(String taskId){
        return repository.findById(taskId).get();
    }
    public List<Task> getTaskBySeverity(int severity){
        return repository.findBySeverity(severity);
    }
    public List<Task> getTaskByAssignee(String assignee){
        return repository.getTasksByAssignee(assignee);
    }
    public Task updateTask(Task task){
        // get the existing task document from DB
        Task existingTask = repository.findById(task.getTaskId()).get();
        existingTask.setDescription(task.getDescription());
        existingTask.setSeverity(task.getSeverity());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setStoryPoint(task.getStoryPoint());
        return repository.save(existingTask);
    }
    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId + "Task deleted from Database successfully";
    }
}
