package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
    @Override
    public void start (Stage primaryStage) {
        try {

            primaryStage.setTitle("Text/File IO Utility");

            BorderPane root = new BorderPane();

            VBox rightVBox = new VBox(7);

            TextArea textArea = new TextArea ();


            rightVBox.setPrefWidth(90);
            textArea.setPrefWidth(250);
            textArea.setMinHeight(100);
            textArea.setPrefHeight(120);
            textArea.setMaxHeight(1200);
            rightVBox.setPadding(new Insets(10, 10, 10, 10));
            Button insertFilebtn = new Button("Insert file");
            Button clearTextbtn = new Button("Clear text");
            Button runUtilitybtn = new Button("Run Utility");
            Button saveFilebtn = new Button("Save file");
            Button helpbtn = new Button("Help");
            Button aboutbtn = new Button("About");
            Button exitbtn = new Button("Exit");


            BorderedTitledPane btpTextArea = new BorderedTitledPane("My Title", textArea);
            BorderedTitledPane btpVBox = new BorderedTitledPane("My Title", rightVBox);

            root.setRight(btpVBox);
            root.setLeft(btpTextArea);
            insertFilebtn.setMinWidth(rightVBox.getPrefWidth());
            clearTextbtn.setMinWidth(rightVBox.getPrefWidth());
            runUtilitybtn.setMinWidth(rightVBox.getPrefWidth());
            saveFilebtn.setMinWidth(rightVBox.getPrefWidth());
            helpbtn.setMinWidth(rightVBox.getPrefWidth());
            aboutbtn.setMinWidth(rightVBox.getPrefWidth());
            exitbtn.setMinWidth(rightVBox.getPrefWidth());

            rightVBox.getStyleClass().add("rightVBox");
            //textArea.getStyleClass().add("textArea");

            rightVBox.getChildren().addAll(insertFilebtn, clearTextbtn, runUtilitybtn,saveFilebtn,helpbtn,aboutbtn,exitbtn);
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