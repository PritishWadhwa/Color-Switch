package Tokens;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Star {
    public Node view;
    public Point2D location;

    public Star(Point2D location, Group hg) throws FileNotFoundException {
        this.location = location;
        this.view = makeImage("images/star.png", location.getX(), location.getY(), 40, 40, true);
        hg.getChildren().add(this.view);
    }

    ImageView makeImage(String url, double xPos, double yPos, double height, double width, boolean preserveRatio) throws FileNotFoundException {
        Image img = new Image(new FileInputStream(url));
        ImageView viewImg = new ImageView(img);
        viewImg.setX(xPos);
        viewImg.setY(yPos);
        viewImg.setFitHeight(height);
        viewImg.setFitWidth(width);
        viewImg.setPreserveRatio(preserveRatio);
        return viewImg;
    }
    public double getpos(){
        return this.view.getBoundsInLocal().getDepth();
    }

}