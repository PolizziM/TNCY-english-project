package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import Tools.Couple;
import Tools.Listening;
import Tools.Verbs;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ToeicController implements Initializable {

	@FXML private GridPane questionsPane;
	@FXML private BorderPane videoPane;
	@FXML private Button playButton;
	@FXML private Text score;
	private int cpt;
	private Media media;
	private MediaPlayer player;
	private MediaView view;
	private Pane mpane;
	private ArrayList<Couple> toeicQA;
	private ArrayList<ChoiceBox> cbList;
	private ArrayList<Text> txtList;

	private ArrayList<Listening> questions = null;

	/*****************************************
	 * Functions to initialize the TOEIC view
	 *****************************************/
	
	public void initVideo() {
		
		/*Plays the video*/
		media = new Media(new File("ressources/videos/TOEIC.mp4").toURI().toString());
		player = new MediaPlayer(media);
		view = new MediaView(player);
		mpane = new Pane();
		mpane.getChildren().add(view);
		videoPane.setCenter(mpane);
	
	}
	
	public void playPauseVideo() {
		if (player.getStatus()==Status.PLAYING) {
			player.pause();
			playButton.setText("►");
		} else {
			player.play();
			playButton.setText("❚❚");
		}
	}
	
	public void goPart1() {
		
	}
	
	public void initAnswerSheet() {
		Text questionHeader = new Text("Questions");
		questionHeader.setFont(Font.font("Roboto Lt"));
		Text answerHeader = new Text("Answers");
		answerHeader.setFont(Font.font("Roboto Lt"));
		Text resultHeader = new Text("Results");
		resultHeader.setFont(Font.font("Roboto Lt"));
		
		questionsPane.add(questionHeader, 0, 0);
		questionsPane.add(answerHeader, 1, 0);
		questionsPane.add(resultHeader,2,0);
		cbList = new ArrayList<ChoiceBox>();
		txtList = new ArrayList<Text>();
		
		for (int i=1;i<101;i++) {
			ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("Choose here","A","B","C","D"));
			cb.getSelectionModel().selectFirst();
			questionsPane.add(new Text(""+i),0,i);
			questionsPane.add(cb, 1, i);
			cbList.add(cb);
			
			Text txt = new Text("");
			txt.setFont(Font.font("Roboto Lt"));
			questionsPane.add(txt, 2, i);
			txtList.add(txt);
		}
		
		cpt=0;
	}
	
	public void checkResult() {
		
		for (int i=0;i<100;i++) {
			if(cbList.get(i).getValue().equals(toeicQA.get(i).getAtt2())) {
				txtList.get(i).setText("Correct");
				txtList.get(i).setFill(Color.LIME);
				cpt=cpt+5;
			} else if (cbList.get(i).getValue().equals("Choose here")) {
				txtList.get(i).setText("No answer");
				txtList.get(i).setFill(Color.GREY);
			} else {
				txtList.get(i).setText("Wrong");
				txtList.get(i).setFill(Color.RED);
			}
		}
		
		score.setText("Score : "+cpt+"/500");
	}
	
	public ArrayList<Couple> loadCSV(String str) throws FileNotFoundException {
		File file = new File(str);
		Scanner sc = new Scanner(file);
		String line = sc.next();

		ArrayList<Couple> answers = new ArrayList<Couple>();

		for (int i = 0;i<100;i++) {

			Scanner scLine = new Scanner(line);
			scLine.useDelimiter(";");

			String numq = scLine.next(); // question number
			String answer = scLine.next(); // 

			answers.add(new Couple(numq,answer));
			scLine.close();
			line = sc.next();
		}
		sc.close();
		return answers;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			toeicQA = loadCSV("ressources/documents/toeic.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initVideo();
		initAnswerSheet();
	}

}
