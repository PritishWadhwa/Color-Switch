package sample;

import Menus.MainMenu;
import PlayArena.ResourceManager;
import PlayArena.SaveRandomData;
import PlayArena.SaveTotalPoints;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    static int logins;
    static int games;
    private static int totalScore;
    public MainMenu menu;

    //    public RespawnMenu respawnMenu;
    public Main() throws Exception {
        try {
            SaveTotalPoints data = (SaveTotalPoints) ResourceManager.load("points.save");
            totalScore = data.totalScore;
        } catch (Exception e) {
            totalScore = 0;
        }
        try {
            SaveRandomData data = (SaveRandomData) ResourceManager.load("randomData.save");
            games = data.totalGames;
            logins = data.totalLogin;
        } catch (Exception e) {
            games = 0;
            logins = 0;
        }
        logins++;
        System.out.println(totalScore);

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static int getTotalLogins() {
        return logins;
    }

    public static int getTotalGames() {
        return games;
    }

    public static void addTotalGames() {
        games++;
    }

    public static int getTotalScore() {
        return totalScore;
    }

    public static void setTotalScore(int inc) {
        totalScore += inc;
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


}