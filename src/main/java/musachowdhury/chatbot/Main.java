package musachowdhury.chatbot;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/ui_1.fxml"));
        root.setId("root");
        Scene temp = new Scene(root);
        temp.getStylesheets().add(getClass().getResource("/ui/design.css").toExternalForm());
        primaryStage.setScene(temp);
        primaryStage.setMinWidth(900.0D);
        primaryStage.setMinHeight(600.0D);
        primaryStage.show();

    }
}


