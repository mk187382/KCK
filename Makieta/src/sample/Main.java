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
    public void start(Stage primaryStage) {
        try {

            primaryStage.setTitle("Text/File IO Utility");

            BorderPane root = new BorderPane();
            VBox rightVBox = new VBox(7);
            TextArea textArea = new TextArea();

            Button insertFileBtn = new Button("Insert file");
            Button clearTextBtn = new Button("Clear text");
            Button runUtilityBtn = new Button("Run Utility");
            Button saveFileBtn = new Button("Save file");
            Button helpBtn = new Button("Help");
            Button aboutBtn = new Button("About");
            Button exitBtn = new Button("Exit");

            BorderedTitledPane borderTextArea = new BorderedTitledPane("Work Area", textArea);
            BorderedTitledPane borderVBox = new BorderedTitledPane("Run time", rightVBox);

            root.setRight(borderVBox);
            root.setLeft(borderTextArea);

            rightVBox.getChildren().addAll(insertFileBtn, clearTextBtn, runUtilityBtn, saveFileBtn, helpBtn, aboutBtn, exitBtn);
            rightVBox.getStyleClass().add("rightVBox");
            rightVBox.setPadding(new Insets(10, 5, 5, 5));
            //problem nachodzącego tła tekstu był spoowodowany przez konflikt nakładającego się atrybutu padding,
            //który był określony w pliku .java oraz .css.
            //Po pozostawieniu jednego z nich, makieta wygląda poprawnie.

            rightVBox.setPrefWidth(120);
            textArea.setPrefWidth(250);
            textArea.setMinHeight(100);
            textArea.setPrefHeight(120);
            textArea.setMaxHeight(1200);
            insertFileBtn.setMinWidth(rightVBox.getPrefWidth());
            clearTextBtn.setMinWidth(rightVBox.getPrefWidth());
            runUtilityBtn.setMinWidth(rightVBox.getPrefWidth());
            saveFileBtn.setMinWidth(rightVBox.getPrefWidth());
            helpBtn.setMinWidth(rightVBox.getPrefWidth());
            aboutBtn.setMinWidth(rightVBox.getPrefWidth());
            exitBtn.setMinWidth(rightVBox.getPrefWidth());


            Scene scene = new Scene(root, 430, 215);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public class BorderedTitledPane extends StackPane {

        public BorderedTitledPane(String titleString, Node content) {
            Label title = new Label(" " + titleString + " ");
            title.getStyleClass().add("bordered-titled-title");
            StackPane.setMargin(title, new Insets(7, 0, 15, 20));
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