package com.example.displayimages;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class DisplayImages extends Application {

    @Override
    public void start(Stage primaryStage) {
        // creates gridpane layout for rows and columns
        GridPane gridPane = new GridPane();
        Image image1 = new Image("https://liveexample.pearsoncmg.com/book/image/germany.gif");
        Image image2 = new Image("https://liveexample.pearsoncmg.com/book/image/fr.gif");
        Image image3 = new Image("https://liveexample.pearsoncmg.com/book/image/china.gif");
        Image image4 = new Image("https://liveexample.pearsoncmg.com/book/image/us.gif");

        // create ImageView objects to diplay images
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);

        // add the ImageViews to GridPane
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 0, 1);
        gridPane.add(imageView4, 1, 1);

        // create scene to display GridPane 400x400 window size
        Scene scene = new Scene(gridPane, 350, 250);

        primaryStage.setTitle("Display Images assignment"); // window title
        primaryStage.setScene(scene); // add scene to stage
        primaryStage.show(); // display stage
    }

    public static void main(String[] args) {
        launch(args);
    }

}