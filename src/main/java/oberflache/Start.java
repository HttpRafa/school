package oberflache;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

    public static void main(String[] args) {
        Application.launch(Start.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("GUI.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Java FX Anwendung");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
