package tarefy.domain;

import tarefy.persistence.TaskRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final TaskRepository repo;
    private List<TaskList> lists;

    public TaskService(TaskRepository repo) throws IOException {
        this.repo = repo;
        this.lists = repo.load();
    }

    public List<TaskList> getLists() { return lists; }

    public TaskList createList(String name) { TaskList list = new TaskList(name); lists.add(list); return list; }

    public void save() throws IOException { repo.save(lists); }
}
