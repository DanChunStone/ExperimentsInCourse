package PointOfLine;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.io.File;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane smallPane = new Pane();
        smallPane.setMinWidth(500);
        smallPane.setMinHeight(500);
        smallPane.setPadding(new Insets(40,40,40,40));
        GridPane mainPane = new GridPane();
        mainPane.setPadding(new Insets(10,10,10,10));
        mainPane.setAlignment(Pos.CENTER);
        mainPane.setVgap(10);
        mainPane.setHgap(10);
        Button btOK = new Button("确定");

        Label X1 = new Label("X1:");
        Label Y1 = new Label("Y1:");
        Label X2 = new Label("X2:");
        Label Y2 = new Label("Y2:");
        Label X3 = new Label("X3:");
        Label Y3 = new Label("Y3:");
        Label X4 = new Label("X4:");
        Label Y4 = new Label("Y4:");

        TextField X1Text = new TextField();
        TextField Y1Text = new TextField();
        TextField X2Text = new TextField();
        TextField Y2Text = new TextField();
        TextField X3Text = new TextField();
        TextField Y3Text = new TextField();
        TextField X4Text = new TextField();
        TextField Y4Text = new TextField();
//        X1Text.setMaxWidth(150);
//        Y1Text.setMaxWidth(150);
//        X2Text.setMaxWidth(150);
//        Y2Text.setMaxWidth(150);
//        X3Text.setMaxWidth(150);
//        Y3Text.setMaxWidth(150);
//        X4Text.setMaxWidth(150);
//        Y4Text.setMaxWidth(150);

        mainPane.add(smallPane,0,0,4,1);
        mainPane.add(btOK,0,5,4,1);
        btOK.setMinSize(150,20);
        GridPane.setHalignment(btOK,HPos.CENTER);
        GridPane.setHalignment(smallPane,HPos.CENTER);

        btOK.setOnAction(event ->{
//            smallPane.removeEventFilter();
            int x1 = Integer.parseInt(X1Text.getText());
            int y1 = Integer.parseInt(Y1Text.getText());
            int x2 = Integer.parseInt(X2Text.getText());
            int y2 = Integer.parseInt(Y2Text.getText());
            int x3 = Integer.parseInt(X3Text.getText());
            int y3 = Integer.parseInt(Y3Text.getText());
            int x4 = Integer.parseInt(X4Text.getText());
            int y4 = Integer.parseInt(Y4Text.getText());

            File file = new File("1.jpg");
            Image image = new Image(file.toURI().toString());
            ImageView imageView0 = new ImageView(image);
//            ImageView imageView1 = new ImageView(new Image("2.jpg"));
//            ImageView imageView2 = new ImageView(new Image("3.jpg"));
//            ImageView imageView3 = new ImageView(new Image("4.jpg"));

            smallPane.getChildren().add(imageView0);

            imageView0.setX(x1);
            imageView0.setY(y1);
//            imageView1.setX(x2);
//            imageView1.setY(y2);
//            imageView2.setX(x3);
//            imageView2.setY(y3);
//            imageView3.setX(x4);
//            imageView3.setY(y4);
        });

        mainPane.add(X1,0,1);
        mainPane.add(X1Text,1,1);
        mainPane.add(Y1,2,1);
        mainPane.add(Y1Text,3,1);
        mainPane.add(X2,0,2);
        mainPane.add(X2Text,1,2);
        mainPane.add(Y2,2,2);
        mainPane.add(Y2Text,3,2);

        mainPane.add(X3,0,3);
        mainPane.add(X3Text,1,3);
        mainPane.add(Y3,2,3);
        mainPane.add(Y3Text,3,3);
        mainPane.add(X4,0,4);
        mainPane.add(X4Text,1,4);
        mainPane.add(Y4,2,4);
        mainPane.add(Y4Text,3,4);

        Scene scene = new Scene(mainPane);
        primaryStage.setTitle("中心城市");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
