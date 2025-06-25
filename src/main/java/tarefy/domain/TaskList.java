package tarefy.domain;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private String name;
    private List<Task> tasks = new ArrayList<>();

    public TaskList(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Task> getTasks() { return tasks; }
}
