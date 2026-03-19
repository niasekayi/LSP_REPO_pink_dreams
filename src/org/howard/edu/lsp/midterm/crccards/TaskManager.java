package org.howard.edu.lsp.midterm.crccards;

import java.util.*;

/**
 * Manages Task objects.
 * Author: Nia Greene
 */
public class TaskManager {

    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException();
        }
        tasks.put(task.getTaskId(), task);
    }

    public Task findTask(String taskId) {
        return tasks.getOrDefault(taskId, null);
    }

    public List<Task> getTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();

        for (Task task : tasks.values()) {
            if (task.getStatus().equals(status)) {
                result.add(task);
            }
        }

        return result;
    }
}