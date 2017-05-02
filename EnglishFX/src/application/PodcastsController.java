package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;

public class PodcastsController implements Initializable {

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Declarations 
	 **_____________________________________________________________________________________________________________________*/
	
	/* Cities of the future */
	@FXML private BorderPane audioPane1;
	@FXML private Button playButton1;
	private MediaPlayer player1;
	
	/* Brain training with English */
	@FXML private BorderPane audioPane2;
	@FXML private Button playButton2;
	private MediaPlayer player2;
	
	/* Young in Business */
	@FXML private BorderPane audioPane3;
	@FXML private Button playButton3;
	private MediaPlayer player3;
	
	/* Univercity of life */
	@FXML private BorderPane audioPane4;
	@FXML private Button playButton4;
	private MediaPlayer player4;
	
	/* Hangry */
	@FXML private BorderPane audioPane5;
	@FXML private Button playButton5;
	private MediaPlayer player5;
	
	/* Drama queen */
	@FXML private BorderPane audioPane6;
	@FXML private Button playButton6;
	private MediaPlayer player6;

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Audios and PlayerButtons
	 **_____________________________________________________________________________________________________________________*/
	
	public void initAudio6Minutes() {

		/*Plays the audio Cities of the Future*/
		Media media1 = new Media(new File("ressources/videos/citiesOfTheFuture.mp3").toURI().toString());
		player1 = new MediaPlayer(media1);
		MediaView view1 = new MediaView(player1);
		Pane mpane1 = new Pane();
		mpane1.getChildren().add(view1);
		audioPane1.setCenter(mpane1);
		
		/*Plays the audio Brain training with English*/
		Media media2 = new Media(new File("ressources/videos/brainTrainingWithEnglish.mp3").toURI().toString());
		player2 = new MediaPlayer(media2);
		MediaView view2 = new MediaView(player2);
		Pane mpane2 = new Pane();
		mpane2.getChildren().add(view2);
		audioPane2.setCenter(mpane2);
		
		/*Plays the audio Young and Business*/
		Media media3 = new Media(new File("ressources/videos/youngAndBusiness.mp3").toURI().toString());
		player3 = new MediaPlayer(media3);
		MediaView view3 = new MediaView(player3);
		Pane mpane3 = new Pane();
		mpane3.getChildren().add(view3);
		audioPane3.setCenter(mpane3);
	}
	
	public void initEnglishWeSpeak() {
		
		/*Plays the audio university of life */
		Media media4 = new Media(new File("ressources/videos/universityOfLife.mp3").toURI().toString());
		player4 = new MediaPlayer(media4);
		MediaView view4 = new MediaView(player4);
		Pane mpane4 = new Pane();
		mpane4.getChildren().add(view4);
		audioPane3.setCenter(mpane4);
		
		/*Plays the audio hangry*/
		Media media5 = new Media(new File("ressources/videos/hangry.mp3").toURI().toString());
		player5 = new MediaPlayer(media5);
		MediaView view5 = new MediaView(player5);
		Pane mpane5 = new Pane();
		mpane5.getChildren().add(view5);
		audioPane3.setCenter(mpane5);
		
		/*Plays the audio drama queen*/
		Media media6 = new Media(new File("ressources/videos/dramaQueen.mp3").toURI().toString());
		player6 = new MediaPlayer(media6);
		MediaView view6 = new MediaView(player6);
		Pane mpane6 = new Pane();
		mpane6.getChildren().add(view6);
		audioPane3.setCenter(mpane6);
	}
	
	
	public void playPauseAudio1() {
		if (player1.getStatus()==Status.PLAYING) {
			player1.pause();
			playButton1.setText("►");
		} else {
			player1.play();
			playButton1.setText("❚❚");
		}
	}
	
	public void playPauseAudio2() {
		if (player2.getStatus()==Status.PLAYING) {
			player2.pause();
			playButton2.setText("►");
		} else {
			player2.play();
			playButton2.setText("❚❚");
		}
	}
	
	public void playPauseAudio3() {
		if (player3.getStatus()==Status.PLAYING) {
			player3.pause();
			playButton3.setText("►");
		} else {
			player3.play();
			playButton3.setText("❚❚");
		}
	}

	public void playPauseAudio4() {
		if (player4.getStatus()==Status.PLAYING) {
			player4.pause();
			playButton4.setText("►");
		} else {
			player4.play();
			playButton4.setText("❚❚");
		}
	}
	
	public void playPauseAudio5() {
		if (player5.getStatus()==Status.PLAYING) {
			player5.pause();
			playButton5.setText("►");
		} else {
			player5.play();
			playButton5.setText("❚❚");
		}
	}
	
	public void playPauseAudio6() {
		if (player6.getStatus()==Status.PLAYING) {
			player6.pause();
			playButton6.setText("►");
		} else {
			player6.play();
			playButton6.setText("❚❚");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initAudio6Minutes();
		initEnglishWeSpeak();
	}

}
