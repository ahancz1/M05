import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class MouseCircleColor extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create Pane to hold the circle
        Pane pane = new Pane();

        // create Circle
        Circle circle = new Circle(175, 175, 100);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // add mouse pressed event to change color to black
        circle.setOnMousePressed(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                circle.setFill(Color.BLACK);
            }
        });

        // add mouse released event to change color back to white
        circle.setOnMouseReleased(new javafx.event.EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                circle.setFill(Color.WHITE);
            }
        });

        // add circle to the Pane
        pane.getChildren().add(circle);

        // create Scene and place it in the Stage
        Scene scene = new Scene(pane, 350, 350);
        primaryStage.setTitle("15.7 Change Color Using Mouse");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
