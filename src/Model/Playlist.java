package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

public class Playlist {

	private String title;
	private Date creationDate;
	public ArrayList<Track> Songs;
	File playlistFile;
	private String coverFile;// bild platzhalter url angeben

	public Playlist() throws UnsupportedTagException, InvalidDataException, IOException {
		this.title = "libary";
		this.creationDate = new Date();
		Songs = new ArrayList<Track>();
		File f = new File("Songs");
		String[] SongArray = f.list();
		int anzahl = SongArray.length;
		String line;
		for (int i = 0; i < anzahl; i++) {

			line = SongArray[i];
			if (line.endsWith(".mp3")) {

				Track song = new Track("Songs/" + line);
				Songs.add(song);
				line = SongArray[i];

			}
		}
	}

	private int numberOfTracks() {
		return Songs.size();
	}

	private Track getTrack(int no) {
		if (no < Songs.size() || no >= 0) {
			return Songs.get(no);
		}
		return null;
	}
	

}
