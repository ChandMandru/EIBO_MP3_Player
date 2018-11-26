package View;
	
import Model.MP3Player;
import Model.Track;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;

import java.io.File;
import java.io.IOException;


public class Main extends Application {
	
			private MP3Player mp3Player;
	
			//private CoverPane coverPane = new CoverPane();
			private MenuBar menuBar = new MenuBar();
			private ProgressBar progressBar = new ProgressBar();
			private SongView songView = new SongView();
			private Node currNode;


			private BorderPane root = new BorderPane();
			private StackPane center = new StackPane();
			private StackPane playerCent = new StackPane();
			private VBox bottom = new VBox();
			private Scene library = new Scene(root,750,500);

			private File appIcon = new File("pics/Icons/Play.png");
			private Track currSel;

	@Override
	public void start(Stage primaryStage) {
			primaryStage.setTitle("MP3Player EIBO Chand Mandru, Raoul Sudiana");
			primaryStage.setMinHeight(400);
			primaryStage.setMinWidth(700);
			primaryStage.setMaxWidth(1920);
			primaryStage.setMaxHeight(1080);
			primaryStage.getIcons().add(new Image(appIcon.toURI().toString()));

			mp3Player = new MP3Player();
			playerView pView = new playerView(mp3Player);


			System.out.println(mp3Player.getPlaylistLibrary().Songs.size());

			songView.setItems(songView.getTrack(mp3Player.getPlaylistLibrary()));

			playerCent.getChildren().add(pView);
			center.getChildren().add(songView);
			bottom.getChildren().addAll(progressBar,menuBar);

			root.setCenter(playerCent);
			root.setBottom(bottom);
			currNode = root.getCenter();

			songView.setOnMouseClicked(e -> {
				currSel = songView.getSelectionModel().getSelectedItem();
				System.out.println(currSel.getSoundFile());
			});

			menuBar.getSwapButton().setOnAction(e -> {
				System.out.println("x");
				if(currNode==center){
					root.setCenter(playerCent);
					currNode = playerCent;
				}else if(currNode==playerCent){
					root.setCenter(center);
					currNode = center;
				}
			});

			menuBar.getPlayButton().setOnAction(e ->{
				try {
					mp3Player.play(currSel.getSoundFile());
					pView.setCurrSongTitle(currSel.getTitle());
					pView.setCurrSongArtist(currSel.getInterpret());
					pView.setCurrSongLength(currSel.getMinuteFormat());
				}catch(IOException a){

				}
				catch(InvalidDataException a){

				}
				catch(UnsupportedTagException a){

				}
			});

		menuBar.getStopButton().setOnAction(event -> mp3Player.stop());

		/*
		menuBar.getShuffleButton().setOnAction(e -> mp3Player.shuffle);{

		}
		menuBar.getSkipButton().setOnAction(e -> mp3Player.skip);{

		}
		menuBar.getSkipBackButton().setOnAction(e -> mp3Player.skipBack);{

		}
		*/

			
			root.prefHeightProperty().bind(library.heightProperty());
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(library);
			primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}