package PlayArena;

import javafx.scene.Group;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class SaveData implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public int currScore;
    public double ballPos;
//    public Group obsGroup;
    public ArrayList<Shape> obstacleList;
}


//
//pauseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
//@Override
//public void handle(MouseEvent event) {
//        SaveData saveData = new SaveData();
//        saveData.currScore = curScore;
//        saveData.ballPos = ball.location.getY();
//        saveData.obstacleList = new ArrayList<Shape>(nodes);
////                saveData.obsGroup = new Group(headgroup);
//        try {
//        ResourceManager.save(saveData, "1.save");
//        } catch (Exception e) {
//        System.out.println("Couldn't save: " + e.getMessage());
//        }
////                saveData.obsGroup = headgroup;
////                System.out.println("pa");
//
//        }
//        });