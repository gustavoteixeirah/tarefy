package tarefy.ui;

import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import tarefy.domain.Task;
import tarefy.domain.TaskList;

public class DailyView {
    public Scene createScene(TaskList list) {
        BorderPane pane = new BorderPane();
        ListView<Task> tasks = new ListView<>();
        tasks.getItems().addAll(list.getTasks());
        pane.setCenter(tasks);
        return new Scene(pane, 400, 300);
    }
}
