package Tokens;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.geom.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ColorSwapper {
    Point2D location;
    Node view;
    public ColorSwapper(Point2D location) throws FileNotFoundException {
        this.location = location;
        this.view = makeImage("images/swap.png", location.getX(), location.getY(), 100, 100, true);
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
}
