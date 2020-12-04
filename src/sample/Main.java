//package sample;
//
//import Menus.MainMenu;
//import PlayArena.Gameplay;
//import javafx.application.Application;
//import javafx.stage.Stage;
//
//public class Main extends Application {
//    public MainMenu menu;
//    public Gameplay play;
////    public RespawnMenu respawnMenu;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    @Override
//    public void start(Stage primaryStage) {
//        try {
//
////            Gameplay play = new Gameplay();
////            primaryStage = play.getMainStage();
////            primaryStage.show();
////            Gameplay play = new Gameplay();
////            //good part start
////            menu = new MainMenu();
////            menu.start(primaryStage);
////            //good part end
//
//            play = new Gameplay();
//            play.start(primaryStage);
//
//            //LoadGameMenu loadGameMenu = new LoadGameMenu();
//            //primaryStage = menu.getMainStage();
//            //primaryStage.show();
////            LoadGameMenu loadGameMenu = new LoadGameMenu();
////            primaryStage = loadGameMenu.getMainStage();
////            primaryStage.show();
////            PauseGameMenu pauseGameMenu = new PauseGameMenu();
////            primaryStage = pauseGameMenu.getMainStage();
////            primaryStage.show();
////            respawnMenu = new RespawnMenu();
////            respawnMenu.start(primaryStage);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
////
////import javafx.animation.TranslateTransition;
////import javafx.application.Application;
////import javafx.scene.Group;
////import javafx.scene.Scene;
////import javafx.scene.control.Button;
////import javafx.stage.Stage;
////import javafx.util.Duration;
////
////public class Main extends Application {
////    @Override
////    public void start(Stage primaryStage) throws Exception {
////        Button btn = new Button("ClickMe");
////        Group group = new Group(btn);
////        Scene scene = new Scene(group, 600, 600);
////
////        //Duration = 2.5 seconds
////        Duration duration = Duration.millis(2500);
////        //Create new translate transition
////        TranslateTransition transition = new TranslateTransition(duration, btn);
////        //Move in X axis by +200
////        transition.setByX(200);
////        //Move in Y axis by +100
////        transition.setByY(100);
////        //Go back to previous position after 2.5 seconds
////        transition.setAutoReverse(true);
////        //Repeat animation twice
////        transition.setCycleCount(2);
////        transition.play();
////
////        primaryStage.setScene(scene);
////        primaryStage.show();
////    }
////    public static void main(String[] args) {
////        Application.launch(args);
////    }
////}


package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.shape.*;

public class Main extends Application {

    private ArrayList<Shape> nodes;

    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage primaryStage) {
        primaryStage.setTitle("Drag circles around to see collisions");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);

        nodes = new ArrayList<>();
        nodes.add(new Circle(15, 15, 30));
        nodes.add(new Circle(90, 60, 30));
        nodes.add(new Circle(40, 200, 30));
        for (Shape block : nodes) {
            setDragListeners(block);
        }
        root.getChildren().addAll(nodes);
        checkShapeIntersection(nodes.get(nodes.size() - 1));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setDragListeners(final Shape block) {
        final Delta dragDelta = new Delta();

        block.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                // record a delta distance for the drag and drop operation.
                dragDelta.x = block.getLayoutX() - mouseEvent.getSceneX();
                dragDelta.y = block.getLayoutY() - mouseEvent.getSceneY();
                block.setCursor(Cursor.NONE);
            }
        });
        block.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                block.setCursor(Cursor.HAND);
            }
        });
        block.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent mouseEvent) {
                block.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
                block.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
                checkShapeIntersection(block);
            }
        });
    }

    private void checkShapeIntersection(Shape block) {
        boolean collisionDetected = false;
        for (Shape static_bloc : nodes) {
            if (static_bloc != block) {
                static_bloc.setFill(Color.GREEN);

                Shape intersect = Shape.intersect(block, static_bloc);
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    collisionDetected = true;
                }
            }
        }

        if (collisionDetected) {
            block.setFill(Color.BLUE);
        } else {
            block.setFill(Color.GREEN);
        }
    }

    class Delta { double x, y; }
}