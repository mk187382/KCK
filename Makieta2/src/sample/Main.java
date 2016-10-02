package sample;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            primaryStage.setTitle("Screen IO Utility");

            BorderPane root = new BorderPane();
            VBox rightVBox = new VBox(5);
            VBox leftVBox = new VBox(2);
            TextArea topTextArea = new TextArea ();
            TextArea bottomTextArea = new TextArea();
            rightVBox.setPadding(new Insets(10, 10, 10, 10));
            rightVBox.getStyleClass().add("rightVBox");
            //rightVBox.setPrefWidth(105);
            leftVBox.setPrefSize(90,100);
            leftVBox.setPadding(new Insets(10,10,10,10));

            Button runUtilitybtn = new Button("Runtime utility");
            Button clearsrcbtn = new Button("Clear source");
            Button helpbtn = new Button("Help");
            Button aboutbtn = new Button("About");
            Button exitbtn = new Button("Exit after save");

            runUtilitybtn.setMinWidth(rightVBox.getPrefWidth());
            clearsrcbtn.setMinWidth(rightVBox.getPrefWidth());
            helpbtn.setMinWidth(rightVBox.getPrefWidth());
            aboutbtn.setMinWidth(rightVBox.getPrefWidth());
            exitbtn.setMinWidth(rightVBox.getPrefWidth());

            rightVBox.getStyleClass().add("rightVBox");


            BorderedTitledPane btprVBox = new BorderedTitledPane("Run Time options", rightVBox);
            btprVBox.setPrefWidth(600);
            root.setCenter(btprVBox);
            BorderedTitledPane btplVBox = new BorderedTitledPane("Text IO zone", leftVBox);
            root.setLeft(btplVBox);
            btplVBox.setPrefWidth(250);
            BorderedTitledPane btpTopText = new BorderedTitledPane("Source", topTextArea);
            BorderedTitledPane btpBottomText = new BorderedTitledPane("Output", bottomTextArea);

            runUtilitybtn.setPrefWidth(btprVBox.getPrefWidth());
            clearsrcbtn.setPrefWidth(btprVBox.getPrefWidth());
            helpbtn.setPrefWidth(btprVBox.getPrefWidth());
            aboutbtn.setPrefWidth(btprVBox.getPrefWidth());
            exitbtn.setPrefWidth(btprVBox.getPrefWidth());

            rightVBox.setPrefHeight(600);
            runUtilitybtn.setPrefHeight(rightVBox.getPrefHeight() * 0.2);
            clearsrcbtn.setPrefHeight(rightVBox.getPrefHeight() * 0.2);
            helpbtn.setPrefHeight(rightVBox.getPrefHeight() * 0.2);
            aboutbtn.setPrefHeight(rightVBox.getPrefHeight() * 0.2);
            exitbtn.setPrefHeight(rightVBox.getPrefHeight() * 0.2);

            helpbtn.disableProperty().set(true);

            leftVBox.getChildren().addAll(btpTopText,btpBottomText);
            rightVBox.getChildren().addAll(runUtilitybtn,clearsrcbtn,helpbtn,aboutbtn,exitbtn);
            Scene scene = new Scene(root,400,215);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public class BorderedTitledPane extends StackPane {

        public BorderedTitledPane(String titleString, Node content) {
            Label title = new Label(" " + titleString + " ");
            title.getStyleClass().add("bordered-titled-title");
            StackPane.setMargin(title, new Insets(0, 0, 0, 20));
            StackPane.setAlignment(title, Pos.TOP_LEFT);

            StackPane contentPane = new StackPane();
            contentPane.getChildren().add(content);

            getStyleClass().add("bordered-titled-border");
            getChildren().addAll(contentPane, title);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
