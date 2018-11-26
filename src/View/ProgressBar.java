package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class ProgressBar extends GridPane {
	private ColumnConstraints progress = new ColumnConstraints();
	private ColumnConstraints time = new ColumnConstraints();
	public Slider progressSlider = new Slider();
	public Label timeLabel = new Label("0:00");
	
	public ProgressBar(){
		this.setStyle("-fx-background-color: lightgrey");
		progress.setPercentWidth(85);
		this.setAlignment(Pos.CENTER);
		this.getColumnConstraints().add(progress);
		this.add(progressSlider, 0, 0);
		timeLabel.setPadding(new Insets(0,0,0,10));
		this.add(timeLabel, 1, 0);
		this.setPadding(new Insets(10,20,10,20));
	}

}
