package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Tools.Couple;
import Tools.Vocabulary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class GrammarController implements Initializable {

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Declarations at match FXML file
	 **_____________________________________________________________________________________________________________________*/
	
	@FXML private Text score;
	@FXML private GridPane questionsPane;
	private ArrayList<ChoiceBox> cbList;
	private ArrayList<String> answersList;
	private ArrayList<Text> txtList;
	private int cpt;
	
	@FXML TableView PCTab;
	@FXML private TableColumn<Couple, String> passiveCol; @FXML private TableColumn<Couple, String> causativeCol;

	@FXML TableView LWTab;
	@FXML private TableColumn<Couple, String> LWCol1; @FXML private TableColumn<Couple, String> LWCol2;

	@FXML TableView possTab;
	@FXML private TableColumn<Couple, String> possCol1; @FXML private TableColumn<Couple, String> possCol2;

	@FXML TableView pronTab;
	@FXML private TableColumn<Couple, String> pronCol1; @FXML private TableColumn<Couple, String> pronCol2;

	/*Present*/

	@FXML TableView presSimpleTab;
	@FXML private TableColumn<Couple, String> presSimpleCol1; @FXML private TableColumn<Couple, String> presSimpleCol2;

	@FXML TableView presContiTab;
	@FXML private TableColumn<Couple, String> presContiCol1; @FXML private TableColumn<Couple, String> presContiCol2;

	@FXML TableView presPerfectTab;
	@FXML private TableColumn<Couple, String> presPerfectCol1; @FXML private TableColumn<Couple, String> presPerfectCol2;

	@FXML TableView presPerfectContiTab;
	@FXML private TableColumn<Couple, String> presPerfectContiCol1; @FXML private TableColumn<Couple, String> presPerfectContiCol2;

	/*Past*/

	@FXML TableView pastSimpleTab;
	@FXML private TableColumn<Couple, String> pastSimpleCol1; @FXML private TableColumn<Couple, String> pastSimpleCol2;

	@FXML TableView pastContiTab;
	@FXML private TableColumn<Couple, String> pastContiCol1; @FXML private TableColumn<Couple, String> pastContiCol2;

	@FXML TableView pastPerfectTab;
	@FXML private TableColumn<Couple, String> pastPerfectCol1; @FXML private TableColumn<Couple, String> pastPerfectCol2;

	@FXML TableView pastPerfectContiTab;
	@FXML private TableColumn<Couple, String> pastPerfectContiCol1; @FXML private TableColumn<Couple, String> pastPerfectContiCol2;

	/*Futur*/

	@FXML TableView futurSimpleTab;
	@FXML private TableColumn<Couple, String> futurSimpleCol1; @FXML private TableColumn<Couple, String> futurSimpleCol2;

	@FXML TableView futurContiTab;
	@FXML private TableColumn<Couple, String> futurContiCol1; @FXML private TableColumn<Couple, String> futurContiCol2;

	@FXML TableView futurPerfectTab;
	@FXML private TableColumn<Couple, String> futurPerfectCol1; @FXML private TableColumn<Couple, String> futurPerfectCol2;

	@FXML TableView futurPerfectContiTab;
	@FXML private TableColumn<Couple, String> futurPerfectContiCol1; @FXML private TableColumn<Couple, String> futurPerfectContiCol2;

	/**---------------------------------------------------------------------------------------------------------------------*
	 * CSV Loader function
	 **_____________________________________________________________________________________________________________________*/

	public static ArrayList<Couple> loadCSV(String str) throws IOException {
		ArrayList<Couple> vocab = new ArrayList<Couple>();

		FileReader fr = new FileReader(str);
		BufferedReader br = new BufferedReader(fr);
		String currentLine;

		while ((currentLine = br.readLine()) != null) {
			String[] line = currentLine.split(";", 2);
			String word  = line[0]; // Word
			String trans =line[1]; // translation
			vocab.add(new Couple(word,trans));
		}
		br.close();
		fr.close();
		return vocab;
	}

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Init table function
	 **_____________________________________________________________________________________________________________________*/

	public void initTable(String str, TableView tv, TableColumn<Couple, String> col1, TableColumn<Couple, String> col2) {
		ArrayList<Couple> lesson = null;
		try {
			lesson = loadCSV(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final ObservableList<Couple> data = FXCollections.observableArrayList(lesson);
		col1.setCellValueFactory(new PropertyValueFactory<Couple, String>("att1"));
		col2.setCellValueFactory(new PropertyValueFactory<Couple, String>("att2"));
		tv.setItems(data);
	}

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Initializing function
	 **_____________________________________________________________________________________________________________________*/

	public void initAnswerSheet() {
		cbList = new ArrayList<ChoiceBox>();
		txtList = new ArrayList<Text>();
		answersList = new ArrayList<String>();
		cpt = 0;
		
		createChoiceBox("falling","going to fall","falling",0);
		createChoiceBox("begin","going to be","going to be",1);
		createChoiceBox("having","going to have","going to have",2);
		createChoiceBox("getting","going to get","getting",3);
		createChoiceBox("realising","going to realise","going to realise",4);
		createChoiceBox("does she","is she going to","is she going to",5);
		createChoiceBox("Are you going","Will you","Are you going",6);
		createChoiceBox("falling","going to fall","going to fall",7);
		createChoiceBox("will answer","is answering","will answer",8);
		createChoiceBox("shall","will","shall",9);
		createChoiceBox("we will visit","we are visiting","we are visiting",10);
		createChoiceBox("does your plane arrive ?","is your plane arriving ?","does your plane arrive ?",11);
		createChoiceBox("Shall","Will","Shall",12);
		createChoiceBox("leaves","is leaving","leaves",13);
		createChoiceBox("I am not having","I will not have","I will not have",14);
		
		for (int i=0;i<15;i++) {
			Text txt = new Text("");
			questionsPane.add(txt, 2, i);
			txtList.add(txt);
		}
	}
	
	public void createChoiceBox(String answer1, String answer2, String correctAnswer, int row) {
		ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("Choose here",answer1,answer2));
		cb.getSelectionModel().selectFirst();
		questionsPane.add(cb, 1, row);
		cbList.add(cb);
		answersList.add(correctAnswer);
	}

	public void checkResult() {
		for (int i=0;i<15;i++) {
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
		
		score.setText("Score : "+cpt+"/15");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTable("ressources/documents/possessive.csv",possTab,possCol1,possCol2); // Possessive
		initTable("ressources/documents/pronouns.csv",pronTab,pronCol1,pronCol2); // Pronouns
		initTable("ressources/documents/passiveCausative.csv",PCTab,passiveCol,causativeCol); // Passive and causatives
		initTable("ressources/documents/linkwords.csv",LWTab,LWCol1,LWCol2); // Link words

		initTable("ressources/documents/presentSimple.csv",presSimpleTab,presSimpleCol1,presSimpleCol2); // Present simple
		initTable("ressources/documents/presentContinious.csv",presContiTab,presContiCol1,presContiCol2); // Present continious
		initTable("ressources/documents/presentPerfect.csv",presPerfectTab,presPerfectCol1,presPerfectCol2); // Present perfect
		initTable("ressources/documents/presentPerfectContinious.csv",presPerfectContiTab,presPerfectContiCol1,presPerfectContiCol2); // Present perfect continious

		initTable("ressources/documents/pastSimple.csv",pastSimpleTab,pastSimpleCol1,pastSimpleCol2); // Past simple
		initTable("ressources/documents/pastContinious.csv",pastContiTab,presContiCol1,pastContiCol2); // Past continious
		initTable("ressources/documents/pastPerfect.csv",pastPerfectTab,pastPerfectCol1,pastPerfectCol2); // Past perfect
		initTable("ressources/documents/pastPerfectContinious.csv",pastPerfectContiTab,pastPerfectContiCol1,pastPerfectContiCol2); // Past perfect continious

		initTable("ressources/documents/futurSimple.csv",futurSimpleTab,futurSimpleCol1,futurSimpleCol2); // Futur simple
		initTable("ressources/documents/futurContinious.csv",futurContiTab,futurContiCol1,futurContiCol2); // Futur continious
		initTable("ressources/documents/futurPerfect.csv",futurPerfectTab,futurPerfectCol1,futurPerfectCol2); // Futur perfect
		initTable("ressources/documents/futurPerfectContinious.csv",futurPerfectContiTab,futurPerfectContiCol1,futurPerfectContiCol2); // Futur perfect continious
	
		initAnswerSheet();
	}
}
