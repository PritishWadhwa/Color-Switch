package sample;

import Menus.LoadGameMenu;
import Menus.MainMenu;
import Menus.PauseGameMenu;
import Menus.RespawnMenu;
import PlayArena.Gameplay;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public MainMenu menu;
//    public RespawnMenu respawnMenu;

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
            //good part start
            menu = new MainMenu();
            menu.start(primaryStage);
            //good part end
            //LoadGameMenu loadGameMenu = new LoadGameMenu();
            //primaryStage = menu.getMainStage();
            //primaryStage.show();
//            LoadGameMenu loadGameMenu = new LoadGameMenu();
//            primaryStage = loadGameMenu.getMainStage();
//            primaryStage.show();
//            PauseGameMenu pauseGameMenu = new PauseGameMenu();
//            primaryStage = pauseGameMenu.getMainStage();
//            primaryStage.show();
//            respawnMenu = new RespawnMenu();
//            respawnMenu.start(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}