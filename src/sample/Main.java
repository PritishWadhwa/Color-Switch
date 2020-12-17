package sample;

import Menus.LoadGameMenu;
import Menus.MainMenu;
import Menus.RespawnMenu;
import PlayArena.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private static int totalScore = 0;
    public MainMenu menu;
    //    public RespawnMenu respawnMenu;
    public Main() throws Exception {
        try {
            SaveTotalPoints data = (SaveTotalPoints) ResourceManager.load("points.save");
            totalScore = data.totalScore;
        }catch (Exception e){
            totalScore = 0;
        }
        System.out.println(totalScore);
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