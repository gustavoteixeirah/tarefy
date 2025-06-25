package tarefy.domain;

import java.time.LocalDateTime;

public class Task {
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
    private long accumulatedMinutes;
    private TaskStatus status;

    public Task(String title) {
        this.title = title;
        this.createdAt = LocalDateTime.now();
        this.status = TaskStatus.BACKLOG;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getFinishedAt() { return finishedAt; }
    public long getAccumulatedMinutes() { return accumulatedMinutes; }
    public TaskStatus getStatus() { return status; }
    public void setStatus(TaskStatus status) { this.status = status; }
    public void finish() { this.finishedAt = LocalDateTime.now(); this.status = TaskStatus.TERMINADO; }
}
