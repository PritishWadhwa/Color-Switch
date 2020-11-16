package sample;

import Menus.MainMenu;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            HBox hbox = new HBox();
            Scene scene = new Scene(hbox, 280, 280);
            Stage newStage;
            BackgroundFill background_fill = new BackgroundFill(Color.PINK, CornerRadii.EMPTY, Insets.EMPTY);
            Background background = new Background(background_fill);
            hbox.setBackground(background);
            MainMenu mainMenu = new MainMenu();
            newStage = mainMenu.getMainStage();
            primaryStage.setScene(scene);

            primaryStage.show();
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
