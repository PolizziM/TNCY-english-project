package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GeneralKnowledgeController implements Initializable {

	@FXML private GridPane questionsPane;
	@FXML private Text score;
	private int cpt;
	
	private ArrayList<String> answersList = new ArrayList<String>();
	private ArrayList<ChoiceBox> cbList = new ArrayList<ChoiceBox>();
	private ArrayList<Text> txtList = new ArrayList<Text>();
	
	public void checkResult() {
		for (int i=0;i<10;i++) {
			if(cbList.get(i).getValue().equals(answersList.get(i))) {
				txtList.get(i).setText("Correct");
				txtList.get(i).setFill(Color.LIME);
				cpt++;
			} else if (cbList.get(i).getValue().equals("Choose here")) {
				txtList.get(i).setText("No answer");
				txtList.get(i).setFill(Color.GREY);
			} else {
				txtList.get(i).setText("Wrong");
				txtList.get(i).setFill(Color.RED);
			}
		}
		
		score.setText("Score : "+cpt+"/10");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for (int i=0;i<10;i++) {
			Text txt = new Text("");
			questionsPane.add(txt, 2, i);
			txtList.add(txt);
		}
		
		answersList.add("His plays");
		ChoiceBox cb0 = new ChoiceBox(FXCollections.observableArrayList("Choose here","His painting","His plays","His opera"));
		cb0.getSelectionModel().selectFirst();
		cbList.add(cb0);
		questionsPane.add(cb0, 1, 0);
		
		answersList.add("Pudding");
		ChoiceBox cb1 = new ChoiceBox(FXCollections.observableArrayList("Choose here","Porridge","Pudding","Crumble"));
		cb1.getSelectionModel().selectFirst();
		cbList.add(cb1);
		questionsPane.add(cb1, 1, 1);
		
		answersList.add("England, Northern Ireland, Wales and Scotland");
		ChoiceBox cb2 = new ChoiceBox(FXCollections.observableArrayList("Choose here","England, Ireland, Iceland and Scotland","England Scotland, Wales and Ireland","England, Northern Ireland, Wales and Scotland"));
		cb2.getSelectionModel().selectFirst();
		cbList.add(cb2);
		questionsPane.add(cb2, 1, 2);
		
		answersList.add("50");
		ChoiceBox cb3 = new ChoiceBox(FXCollections.observableArrayList("Choose here","48","50","52"));
		cb3.getSelectionModel().selectFirst();
		cbList.add(cb3);
		questionsPane.add(cb3, 1, 3);
		
		answersList.add("Big Apple");
		ChoiceBox cb4 = new ChoiceBox(FXCollections.observableArrayList("Choose here","City of the Angels","Big Cherry","Big Apple"));
		cb4.getSelectionModel().selectFirst();
		cbList.add(cb4);
		questionsPane.add(cb4, 1, 4);
		
		answersList.add("God save the queen");
		ChoiceBox cb5 = new ChoiceBox(FXCollections.observableArrayList("Choose here","The Star-Spangled Banner","God save the queen","Advanced Australia Fair"));
		cb5.getSelectionModel().selectFirst();
		cbList.add(cb5);
		questionsPane.add(cb5, 1, 5);
		
		answersList.add("Thames");
		ChoiceBox cb6 = new ChoiceBox(FXCollections.observableArrayList("Choose here","Thames","Ribble","Avon"));
		cb6.getSelectionModel().selectFirst();
		cbList.add(cb6);
		questionsPane.add(cb6, 1, 6);

		answersList.add("750 millions");
		ChoiceBox cb7 = new ChoiceBox(FXCollections.observableArrayList("Choose here","850 millions","750 millions","50 millions"));
		cb7.getSelectionModel().selectFirst();
		cbList.add(cb7);
		questionsPane.add(cb7, 1, 7);
		
		answersList.add("4th of July");
		ChoiceBox cb8 = new ChoiceBox(FXCollections.observableArrayList("Choose here","4th of June","4th of July","14th of July"));
		cb8.getSelectionModel().selectFirst();
		cbList.add(cb8);
		questionsPane.add(cb8, 1, 8);
		
		answersList.add("Canberra");
		ChoiceBox cb9 = new ChoiceBox(FXCollections.observableArrayList("Choose here","Canberra","Sydney","Melbourne"));
		cb9.getSelectionModel().selectFirst();
		cbList.add(cb9);
		questionsPane.add(cb9, 1, 9);
	}
}
