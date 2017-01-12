package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main extends Application {

    private static Stage primaryStage;
    private boolean outcome = false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("home-page.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();

    }

    public void setUpPage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("set-up-page.fxml"));
        primaryStage.setScene(new Scene(root, 500, 475));
    }

    public void beginPage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("begin-test-page.fxml"));
        primaryStage.setScene(new Scene(root, 500, 475));
    }

    public void progressPage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("progress-page.fxml"));
        primaryStage.setScene(new Scene(root, 500, 475));
    }

    public void outComePage() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("success-page.fxml"));
        primaryStage.setScene(new Scene(root, 500, 475));
    }

    public void beginTest() throws Exception{
        progressPage();
        Process p = Runtime.getRuntime().exec("python FRC.py");
        String s = "";
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }


    }

    public void setOutcome(boolean outcome){
        this.outcome = outcome;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
