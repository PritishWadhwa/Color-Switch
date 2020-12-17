package sample;

import Menus.LoadGameMenu;
import Menus.MainMenu;
import Menus.RespawnMenu;
import PlayArena.Gameplay;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static int totalScore;
    public MainMenu menu;
    //    public RespawnMenu respawnMenu;
    public Main(){
        totalScore=0;
        //System.out.print("nck");

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            menu = new MainMenu();
            menu.start(primaryStage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getTotalScore(){
        return totalScore;
    }
    public static void setTotalScore(int inc){
        totalScore+=inc;
    }


}