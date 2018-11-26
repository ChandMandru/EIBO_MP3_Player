package Model;

import java.io.IOException;
import com.mpatric.mp3agic.*;



public class Track {
	 
	private Mp3File mp3;
	private String title;
	private long length;
	private long lenInMins;
	private String minuteFormat;
	private String albumTitle;
	private String interpret;
	private String soundFile;
	private ID3v2 metadata;

	//BILD VON AKTUELLEM SONG RAUSZIEHEN (JAVAFX.SCENE.IMAGE.IMAGE Datentype und kein Normales oder BufferdImage)
	
	public Track(String soundFile) throws UnsupportedTagException, InvalidDataException, IOException{

		this.soundFile = soundFile;
		this.mp3 = new Mp3File(soundFile);
		this.metadata = mp3.getId3v2Tag();
		this.title = metadata.getTitle();
		this.length = mp3.getLengthInSeconds();
		this.lenInMins = length/60;
		this.albumTitle = metadata.getAlbum();
		this.interpret = metadata.getArtist();
		this.minuteFormat = (lenInMins+":"+(length%60));
	}

	public String getMinuteFormat(){
		return minuteFormat;
	}

	public String getTitle() {
		return title;
	}

	public long getLength() {
		return length;
	}

	public String getInterpret() {
		return interpret;
	}

	public String getSoundFile() {
		return soundFile;
	}

}
