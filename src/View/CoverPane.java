package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class CoverPane extends VBox{
	public Image image;
	public ImageView i1;
	
	
	public CoverPane(){
		this.image = new Image(getClass().getResourceAsStream("pics/placeholder.png"));
		this.i1 = new ImageView(image);
		this.getChildren().add(i1);
	}
}
