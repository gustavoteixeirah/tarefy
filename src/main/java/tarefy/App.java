package tarefy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tarefy.domain.TaskList;
import tarefy.domain.TaskService;
import tarefy.persistence.JsonTaskRepository;

import java.nio.file.Paths;

public class App extends Application {
    private TaskService service;

    @Override
    public void start(Stage stage) throws Exception {
        service = new TaskService(new JsonTaskRepository(Paths.get("tarefy.json")));

        BorderPane root = new BorderPane();
        ListView<TaskList> listView = new ListView<>();
        listView.getItems().addAll(service.getLists());
        listView.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(TaskList item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getName());
            }
        });
        root.setCenter(listView);

        Button addList = new Button("Nova Lista");
        addList.setOnAction(e -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setHeaderText("Nome da lista");
            dialog.showAndWait().ifPresent(name -> {
                TaskList l = service.createList(name);
                listView.getItems().add(l);
                try { service.save(); } catch (Exception ex) { ex.printStackTrace(); }
            });
        });
        root.setTop(addList);

        stage.setScene(new Scene(root, 600, 400));
        stage.setTitle("Tarefy Dashboard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
