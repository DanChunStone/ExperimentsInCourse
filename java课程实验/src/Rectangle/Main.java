package Rectangle;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

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

            Double x1 = Double.parseDouble(X1Text.getText());
            Double y1 = Double.parseDouble(Y1Text.getText());
            Double x2 = Double.parseDouble(X2Text.getText());
            Double y2 = Double.parseDouble(Y2Text.getText());
            Double x3 = Double.parseDouble(X3Text.getText());
            Double y3 = Double.parseDouble(Y3Text.getText());
            Double x4 = Double.parseDouble(X4Text.getText());
            Double y4 = Double.parseDouble(Y4Text.getText());

            Double minX = Math.min(Math.min(x1,x2),Math.min(x3,x4));
            Double maxX = Math.max(Math.max(x1,x2),Math.max(x3,x4));
            Double minY = Math.min(Math.min(y1,y2),Math.min(y3,y4));
            Double maxY = Math.max(Math.max(y1,y2),Math.max(y3,y4));

            Line line1 = new Line(minX,minY,minX,maxY);
            Line line2 = new Line(maxX,minY,maxX,maxY);
            Line line3 = new Line(minX,minY,maxX,minY);
            Line line4 = new Line(minX,maxY,maxX,maxY);

            Circle circle1 = new Circle(x1,y1,3);
            Circle circle2 = new Circle(x2,y2,3);
            Circle circle3 = new Circle(x3,y3,3);
            Circle circle4 = new Circle(x4,y4,3);
            circle1.setFill(Color.RED);
            circle1.setStroke(Color.RED);
            circle2.setFill(Color.RED);
            circle2.setStroke(Color.RED);
            circle3.setFill(Color.RED);
            circle3.setStroke(Color.RED);
            circle4.setFill(Color.RED);
            circle4.setStroke(Color.RED);
            smallPane.getChildren().add(circle1);
            smallPane.getChildren().add(circle2);
            smallPane.getChildren().add(circle3);
            smallPane.getChildren().add(circle4);


            smallPane.getChildren().add(line1);
            smallPane.getChildren().add(line2);
            smallPane.getChildren().add(line3);
            smallPane.getChildren().add(line4);
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
        primaryStage.setTitle("边界矩形");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
