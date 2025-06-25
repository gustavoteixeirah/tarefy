package tarefy.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import tarefy.domain.Task;

public class FocusView {
    public Scene createScene(Task task) {
        VBox box = new VBox(10);
        Label title = new Label(task.getTitle());
        Button finish = new Button("Finalizar");
        finish.setOnAction(e -> task.finish());
        box.getChildren().addAll(title, finish);
        return new Scene(box, 300, 200);
    }
}
