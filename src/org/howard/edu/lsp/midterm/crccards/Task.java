package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a Task with ID, description, and status.
 * @author Samuel Dadzie
 */
public class Task {

    private String taskId;
    private String description;
    private String status;

    /**
     * Constructor to initialize taskId and description.
     * Default status is OPEN.
     * @param taskId the task ID
     * @param description the task description
     */
    public Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "OPEN";
    }

    /**
     * Returns task ID.
     * @return task ID
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Returns task description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns task status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets task status. If invalid, sets to UNKNOWN.
     * @param status new status
     */
    public void setStatus(String status) {
        if ("OPEN".equals(status) || "IN_PROGRESS".equals(status) || "COMPLETE".equals(status)) {
            this.status = status;
        } else {
            this.status = "UNKNOWN";
        }
    }

    /**
     * Returns formatted task string.
     * @return formatted string
     */
    @Override
    public String toString() {
        return taskId + " " + description + " [" + status + "]";
    }
}