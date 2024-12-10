// Import the necessary JavaFX libraries
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;

public class ScrollbarColor extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text("Hello World!");
        text.setStyle("-fx-font-size: 30px;");

        // scrollbars for red, green, blue, and opacity
        ScrollBar redScrollBar = new ScrollBar();
        ScrollBar greenScrollBar = new ScrollBar();
        ScrollBar blueScrollBar = new ScrollBar();
        ScrollBar opacityScrollBar = new ScrollBar();

        // set range for each scrollbar (0 to 255 for RGB, and 0 to 1 for opacity)
        redScrollBar.setMin(0);
        redScrollBar.setMax(255);
        greenScrollBar.setMin(0);
        greenScrollBar.setMax(255);
        blueScrollBar.setMin(0);
        blueScrollBar.setMax(255);
        opacityScrollBar.setMin(0);
        opacityScrollBar.setMax(1);

        // set initial values
        redScrollBar.setValue(0);
        greenScrollBar.setValue(0);
        blueScrollBar.setValue(0);
        opacityScrollBar.setValue(1); // fully visible

        // HBox layouts to group scroll bars with labels
        HBox redBox = createColorControl("Red", redScrollBar);
        HBox greenBox = createColorControl("Green", greenScrollBar);
        HBox blueBox = createColorControl("Blue", blueScrollBar);
        HBox opacityBox = createColorControl("Opacity", opacityScrollBar);

        // VBox to arrange Text and scroll bars vertically
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(text, redBox, greenBox, blueBox, opacityBox);
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        // add listeners to update text color when scrollbar value changes
        redScrollBar.valueProperty().addListener(ov -> updateTextColor(text, redScrollBar, greenScrollBar, blueScrollBar, opacityScrollBar));
        greenScrollBar.valueProperty().addListener(ov -> updateTextColor(text, redScrollBar, greenScrollBar, blueScrollBar, opacityScrollBar));
        blueScrollBar.valueProperty().addListener(ov -> updateTextColor(text, redScrollBar, greenScrollBar, blueScrollBar, opacityScrollBar));
        opacityScrollBar.valueProperty().addListener(ov -> updateTextColor(text, redScrollBar, greenScrollBar, blueScrollBar, opacityScrollBar));

        // create a scene and set it on the stage
        Scene scene = new Scene(vbox, 330, 250);
        primaryStage.setTitle("Scrollbar Color Selector");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // method to update color of text
    private void updateTextColor(Text text, ScrollBar red, ScrollBar green, ScrollBar blue, ScrollBar opacity) {
        // get values from scrollbars
        int redValue = (int) red.getValue();
        int greenValue = (int) green.getValue();
        int blueValue = (int) blue.getValue();
        double opacityValue = opacity.getValue();

        // set text color using values
        text.setFill(Color.rgb(redValue, greenValue, blueValue, opacityValue));
    }

    // helper method to create an HBox with label and scroll bar
    private HBox createColorControl(String labelText, ScrollBar scrollBar) {
        Text label = new Text(labelText);

        // HBox to group label and scrollbar
        HBox hbox = new HBox(10); // 10px spacing
        hbox.getChildren().addAll(label, scrollBar);
        hbox.setAlignment(Pos.CENTER);

        return hbox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
