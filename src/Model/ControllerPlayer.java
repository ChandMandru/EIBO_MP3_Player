package Model;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.util.Scanner;

public class ControllerPlayer {
	
	static MP3Player player = new MP3Player();
	static Scanner Scan = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException, InvalidDataException, UnsupportedTagException {
		start();
	}
	
	public static void start() throws IOException, InvalidDataException, UnsupportedTagException {
		boolean quit = false;


		while (!quit) {
			System.out.println("Geben Sie ihren Befehl ein");
			String eingabe = Scan.nextLine();
			String[] command = eingabe.split(" ");
		
			

			switch (command[0]) {
			
			case "play":
				
				if (command.length < 2) {
					player.play();

				} else {
					player.play(command[1]);
					
				}
				break;
			case "pause":
				
				player.pause();
				break;

			case "volume":
				Float FValue = Float.parseFloat(command[1]);
				player.volume(FValue);
				break;

			case "balance":
				int IValue = Integer.parseInt(command[1]);
				player.balance(IValue);
				break;

			case "stop":
				player.stop();
				break;
			}

		}
		
	}

}
