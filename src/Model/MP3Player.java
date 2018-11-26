
package Model;

import java.io.IOException;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import de.hsrm.mi.eibo.simpleplayer.*;

public class MP3Player {

	private SimpleMinim minim;
	private SimpleAudioPlayer audioPlayer;
	private Playlist playlistLibrary;
	private Track currSong;


	public MP3Player() {
		try {
			this.playlistLibrary = new Playlist();
		} catch (UnsupportedTagException e) {
		
			e.printStackTrace();
		} catch (InvalidDataException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void play(String fileName) throws UnsupportedTagException, InvalidDataException, IOException{
		minim = new SimpleMinim(true);
		audioPlayer = minim.loadMP3File(fileName);
		audioPlayer.play();
		currSong = new Track(fileName);
		System.out.println("Aktueller Song : "+currSong.getTitle());
	}

	public void play() {
		audioPlayer.play();
	}

	public void pause() {
		audioPlayer.pause();
	}

	public void stop() {
		audioPlayer.pause();
		audioPlayer.cue(0);
	}

	public void volume(float value) {
		if (value >= 0 && value <= 1){
			audioPlayer.setGain((float)Math.log10(value)*20);
			System.out.println((float)Math.log10(value)*20);
		}else {
			System.out.println("bitte wert zwischen0 und 1");
		}
		


	}
	
	public void balance(float value){
		//YEET
	}

	public Playlist getPlaylistLibrary() {
		return playlistLibrary;
	}

	public Track getCurrSong() {
		return currSong;
	}
}
