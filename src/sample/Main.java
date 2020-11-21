package sample;

import Menus.LoadGameMenu;
import Menus.MainMenu;
import Menus.PauseGameMenu;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
//            MainMenu mainMenu = new MainMenu();
//            primaryStage = mainMenu.getMainStage();
//            primaryStage.show();
//            LoadGameMenu loadGameMenu = new LoadGameMenu();
//            primaryStage = loadGameMenu.getMainStage();
//            primaryStage.show();
            PauseGameMenu pauseGameMenu = new PauseGameMenu();
            primaryStage = pauseGameMenu.getMainStage();
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}