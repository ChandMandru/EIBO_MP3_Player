package View;

import Model.Playlist;
import Model.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SongView extends TableView<Track>{

	private TableColumn<Track,String> nameCol = new TableColumn<>("Song");
	private TableColumn<Track,String> interpretCol = new TableColumn<>("Interpret");
	private TableColumn<Track,String> timeCol = new TableColumn<>("Time");
	
	private Playlist aktPlaylist;
	private Playlist anzeigePlaylist;

	public SongView(){
		timeCol.setStyle("-fx-alignment: CENTER");
		interpretCol.setStyle("-fx-alignment: CENTER");
		this.getSelectionModel().setCellSelectionEnabled(false);
		nameCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		interpretCol.setCellValueFactory(new PropertyValueFactory<>("interpret"));
		timeCol.setCellValueFactory(new PropertyValueFactory<>("minuteFormat"));

		timeCol.setMaxWidth(50);
		timeCol.setMinWidth(50);

		nameCol.setMinWidth(200);
		nameCol.setMaxWidth(650);

		interpretCol.setMinWidth(85);
		interpretCol.setMaxWidth(100);

		this.setEditable(true);
		this.getColumns().addAll(nameCol,interpretCol,timeCol);
	}
	public ObservableList<Track> getTrack(Playlist library){
			ObservableList<Track> libraryTracks = FXCollections.observableArrayList();

			for(int i = 0;i<library.Songs.size();i++){
				libraryTracks.add(library.Songs.get(i));
			}

		return libraryTracks;
	}
}
