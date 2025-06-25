package tarefy.persistence;

import tarefy.domain.TaskList;

import java.io.IOException;
import java.util.List;

public interface TaskRepository {
    List<TaskList> load() throws IOException;
    void save(List<TaskList> lists) throws IOException;
}
