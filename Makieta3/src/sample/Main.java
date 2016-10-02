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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text/File IO Utility");
        BorderPane root = new BorderPane();
        VBox rightVBox = new VBox(7);
        VBox leftVBox = new VBox(2);

        TextField sourceTF = new TextField();
        Label sourceLabel = new Label("Source:");

        TextField reportTF = new TextField();
        Label reportLabel = new Label("Report:");

        Button browse = new Button("Browse...");

        BorderedTitledPane textZone = new BorderedTitledPane("Text IO Zone", leftVBox);
        BorderedTitledPane runTimeOptions = new BorderedTitledPane("Run Time Options", rightVBox);

        Button 



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
