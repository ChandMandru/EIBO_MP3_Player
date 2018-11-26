package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import java.io.File;

public class MenuBar extends GridPane{
	private GridPane middleNavigation = new GridPane();
	private GridPane rightNavigation = new GridPane();
	private ColumnConstraints left = new ColumnConstraints();
	private ColumnConstraints right = new ColumnConstraints();
	private ColumnConstraints mid = new ColumnConstraints();
	private Button playButton = new Button();
	private Button stopButton = new Button();
	private Button shuffleButton = new Button();
	private Button skipButton = new Button();
	private Button skipBackButton = new Button();
	private Button swapButton = new Button();
	private Slider volumeSlider = new Slider();

	private File playImg = new File("pics/Icons/Play.png");
	private File pauseImg = new File("pics/Icons/Play.png");
	private File skipImg = new File("pics/Icons/skip.png");
	private File backImg = new File("pics/Icons/back.png");
	private File shuffleImg = new File("pics/Icons/shuffel.png");
	private File stopImg = new File("pics/Icons/stop.png");
	private File swapImg = new File("pics/Icons/swap.png");


	public MenuBar(){

	/*	playButton.setText("P");
		stopButton.setText("O");
		shuffleButton.setText("X");
		skipButton.setText(">>");
		skipBackButton.setText("<<");
		*/
		this.setStyle("-fx-background-color: lightgrey");

		volumeSlider.setValue(50);

		playButton.setGraphic(new ImageView(new Image(playImg.toURI().toString())));
		skipButton.setGraphic(new ImageView(new Image(skipImg.toURI().toString())));
		skipBackButton.setGraphic(new ImageView(new Image(backImg.toURI().toString())));
		shuffleButton.setGraphic(new ImageView(new Image(shuffleImg.toURI().toString())));
		stopButton.setGraphic(new ImageView(new Image(stopImg.toURI().toString())));
		swapButton.setGraphic(new ImageView(new Image(swapImg.toURI().toString())));

		playButton.setStyle("-fx-background-color: transparent;");
		skipBackButton.setStyle("-fx-background-color: transparent;");
		shuffleButton.setStyle("-fx-background-color: transparent;");
		skipButton.setStyle("-fx-background-color: transparent;");
		swapButton.setStyle("-fx-background-color: transparent;");
		stopButton.setStyle("-fx-background-color: transparent;");

		this.getColumnConstraints().addAll(left,mid,right);
		
		middleNavigation = new GridPane();
		ColumnConstraints play = new ColumnConstraints();
		ColumnConstraints skip = new ColumnConstraints();
		ColumnConstraints skipBack = new ColumnConstraints();
		ColumnConstraints stop = new ColumnConstraints();
		middleNavigation.getColumnConstraints().addAll(skip,play,stop,skipBack);
		middleNavigation.add(skipBackButton, 0, 0);
		middleNavigation.add(playButton, 1, 0);
		middleNavigation.add(stopButton, 2, 0);
		middleNavigation.add(skipButton, 3, 0);
		middleNavigation.setAlignment(Pos.CENTER);
		shuffleButton.setAlignment(Pos.CENTER);
		
		rightNavigation = new GridPane();
		ColumnConstraints shuffle = new ColumnConstraints();
		ColumnConstraints swap = new ColumnConstraints();
		rightNavigation.getColumnConstraints().addAll(shuffle,swap);
		rightNavigation.add(shuffleButton, 0, 0);
		rightNavigation.add(swapButton,1,0);
		rightNavigation.setAlignment(Pos.CENTER);
		this.add(volumeSlider,0,0);
		this.add(middleNavigation, 1, 0);
		this.add(rightNavigation, 2, 0);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(20));

	}

	public Button getStopButton() {
		return stopButton;
	}

	public Button getShuffleButton() {
		return shuffleButton;
	}

	public Button getSkipButton() {
		return skipButton;
	}

	public Button getSkipBackButton() {
		return skipBackButton;
	}

	public Button getSwapButton() {
		return swapButton;
	}

	public Button getPlayButton() {
		return playButton;
	}
}
