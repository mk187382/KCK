package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Text/File IO Utility");
            BorderPane root = new BorderPane();
            VBox rightVBox = new VBox();
            VBox leftVBox = new VBox(2);
            HBox sourceHBox = new HBox();
            HBox reportHBox = new HBox();

            Label sourceLabel = new Label("Source:");
            TextField sourceTF = new TextField();

            Label reportLabel = new Label("Report:");
            TextField reportTF = new TextField();

            Button browseBtn1 = new Button("Browse...");
            Button browseBtn2 = new Button("Browse...");


            BorderedTitledPane textZone = new BorderedTitledPane("Text IO Zone", leftVBox);
            BorderedTitledPane runTimeOptions = new BorderedTitledPane("Run Time Options", rightVBox);

            Button runBtn = new Button("Runtime the utility");
            Button helpBtn = new Button("Help");
            Button aboutBtn = new Button("About");
            Button exitBtn = new Button("Exit afer save");

            root.setRight(runTimeOptions);
            runTimeOptions.setPadding(new Insets(10, 10, 10, 10));

            root.setLeft(textZone);
            textZone.setPadding(new Insets(10, 10, 10, 10));

            textZone.getChildren().add(leftVBox);
            runTimeOptions.getChildren().add(rightVBox);

            rightVBox.getChildren().addAll(runBtn, helpBtn, aboutBtn, exitBtn);
            leftVBox.getChildren().addAll(sourceHBox, reportHBox);

            sourceHBox.getChildren().addAll(sourceLabel, sourceTF, browseBtn1);
            reportHBox.getChildren().addAll(reportLabel, reportTF, browseBtn2);

            rightVBox.getStyleClass().add("rightVBox");

            rightVBox.setPrefWidth(150);
            rightVBox.setPrefHeight(600);
            rightVBox.setPadding(new Insets(10, 10, 10, 10));

            runBtn.setPrefWidth(rightVBox.getPrefWidth());
            runBtn.setPrefHeight(rightVBox.getPrefHeight() * 0.25);
            System.out.print(runTimeOptions.getPrefHeight());

            helpBtn.setPrefWidth(rightVBox.getPrefWidth());
            helpBtn.setPrefHeight(rightVBox.getPrefHeight() * 0.25);

            aboutBtn.setPrefWidth(rightVBox.getPrefWidth());
            aboutBtn.setPrefHeight(rightVBox.getPrefHeight() * 0.25);

            exitBtn.setPrefWidth(rightVBox.getPrefWidth());
            exitBtn.setPrefHeight(rightVBox.getPrefHeight() * 0.25);

            runBtn.disableProperty().set(true);

            leftVBox.setPrefWidth(250);
            leftVBox.setPadding(new Insets(10, 10, 10, 10));

            sourceLabel.setPrefWidth(60);
            sourceTF.setPrefWidth(100);

            browseBtn1.setPrefWidth(100);
            browseBtn2.setPrefWidth(100);

            reportLabel.setPrefWidth(60);
            reportTF.setPrefWidth(100);
            reportTF.setPadding(new Insets(0, 0, 10, 0));

            Scene scene = new Scene(root, 470, 215);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e)

        {
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
