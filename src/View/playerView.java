package View;

import Model.MP3Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import java.io.File;


//AKTUELLES BILD REINLADEN FEHLT

public class playerView extends BorderPane {
    private File cover = new File("pics/placeholder.png");
    private VBox labelBox;
    private VBox imv;
    private ImageView img;
    private Image albumCover;
    private Label currSongTitle = new Label("");
    private Label currSongLength = new Label("");
    private Label currSongArtist = new Label("");


    public playerView (MP3Player player){
        albumCover = new Image(cover.toURI().toString());
        labelBox = new VBox();
        imv = new VBox();

        currSongArtist.setAlignment(Pos.CENTER);
        currSongTitle.setAlignment(Pos.CENTER);
        currSongLength.setAlignment(Pos.CENTER);

        this.labelBox.getChildren().addAll(currSongTitle,currSongArtist,currSongLength);

        this.labelBox.setAlignment(Pos.CENTER);
        this.imv.setAlignment(Pos.CENTER);
        this.labelBox.setPadding(new Insets(20,0,0,0));

        img = new ImageView(albumCover);
        imv.getChildren().add(img);

        this.setTop(labelBox);
        this.setCenter(imv);
    }

    public void setCurrSongTitle(String text) {
        this.currSongTitle.setText(text);
    }
    public void setCurrSongLength(String text){
        this.currSongLength.setText(text);
    }
    public void setCurrSongArtist(String text){
        this.currSongArtist.setText(text);
    }
    public void setCurrSongAlbum(Image img){
        this.albumCover = img;
    }
}
