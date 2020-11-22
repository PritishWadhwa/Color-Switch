package sample;

import Menus.LoadGameMenu;
import Menus.MainMenu;
import PlayArena.Gameplay;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static MainMenu menu;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

//            Gameplay play = new Gameplay();
//            primaryStage = play.getMainStage();
//            primaryStage.show();
//            Gameplay play = new Gameplay();
            menu = new MainMenu();
            menu.start(primaryStage);
            //LoadGameMenu loadGameMenu = new LoadGameMenu();
            //primaryStage = menu.getMainStage();
            //primaryStage.show();
//            LoadGameMenu loadGameMenu = new LoadGameMenu();
//            primaryStage = loadGameMenu.getMainStage();
//            primaryStage.show();
//            PauseGameMenu pauseGameMenu = new PauseGameMenu();
//            primaryStage = pauseGameMenu.getMainStage();
//            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}