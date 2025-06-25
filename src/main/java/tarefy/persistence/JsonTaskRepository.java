package tarefy.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import tarefy.domain.TaskList;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonTaskRepository implements TaskRepository {
    private final Path file;
    private final Gson gson = new Gson();

    public JsonTaskRepository(Path file) {
        this.file = file;
    }

    @Override
    public List<TaskList> load() throws IOException {
        if (!Files.exists(file)) {
            return new ArrayList<>();
        }
        try (Reader reader = Files.newBufferedReader(file)) {
            Type type = new TypeToken<List<TaskList>>(){}.getType();
            List<TaskList> data = gson.fromJson(reader, type);
            return data != null ? data : new ArrayList<>();
        }
    }

    @Override
    public void save(List<TaskList> lists) throws IOException {
        try (Writer writer = Files.newBufferedWriter(file)) {
            gson.toJson(lists, writer);
        }
    }
}
