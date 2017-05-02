package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import Tools.Vocabulary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class VocabularyController implements Initializable {


	/**---------------------------------------------------------------------------------------------------------------------*
	 * Declarations
	 **_____________________________________________________________________________________________________________________*/

	/*Travelling declarations*/
	private ArrayList<Vocabulary> travellingVocab = null;
	@FXML private TableView<Vocabulary> travellingTable;
	@FXML private TableColumn<Vocabulary, String> travelCol1; @FXML private TableColumn<Vocabulary, String> travelCol2;
	@FXML private Text wt1; @FXML private Text wt2; @FXML private Text wt3; // Word travelling
	@FXML private TextField tft1; @FXML private TextField tft2; @FXML private TextField tft3; // TextField travel
	private int i1,i2,i3;

	/*Environnement declarations*/
	private ArrayList<Vocabulary> enviVocab = null;
	@FXML private TableView<Vocabulary> enviTable;
	@FXML private TableColumn<Vocabulary, String> enviCol1; @FXML private TableColumn<Vocabulary, String> enviCol2;
	@FXML private Text we1; @FXML private Text we2; @FXML private Text we3; // Word environnement
	@FXML private TextField tfe1; @FXML private TextField tfe2; @FXML private TextField tfe3; // TextField environnement
	private int j1,j2,j3;


	/*Company declarations*/
	private ArrayList<Vocabulary> compVocab = null;
	@FXML private TableView<Vocabulary> compTable;
	@FXML private TableColumn<Vocabulary, String> compCol1; @FXML private TableColumn<Vocabulary, String> compCol2;
	@FXML private Text wc1; @FXML private Text wc2; @FXML private Text wc3; // Word company
	@FXML private TextField tfc1; @FXML private TextField tfc2; @FXML private TextField tfc3; // TextField company
	private int k1,k2,k3;

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Travel initializing : init + checkresult
	 **_____________________________________________________________________________________________________________________*/

	public void initTravelling() {

		/*Travelling loading */
		try {
			travellingVocab = loadCSV("ressources/documents/travelling.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final ObservableList<Vocabulary> travelData = FXCollections.observableArrayList(travellingVocab);
		travelCol1.setCellValueFactory(new PropertyValueFactory<Vocabulary, String>("word"));
		travelCol2.setCellValueFactory(new PropertyValueFactory<Vocabulary, String>("translation"));
		travellingTable.setItems(travelData);
	}

	public void checkResultTravel() {
		/*Check first word*/
		if (tft1.getText().equals(travellingVocab.get(i1).getWord())) {
			tft1.setStyle("-fx-background-color: lime;");
		} else {
			tft1.setStyle("-fx-background-color: red;");
		}

		/*Check second word*/
		if (tft2.getText().equals(travellingVocab.get(i2).getWord())) {
			tft2.setStyle("-fx-background-color: lime;");
		} else {
			tft2.setStyle("-fx-background-color: red;");
		}
		
		/*Check third word*/
		if (tft3.getText().equals(travellingVocab.get(i3).getWord())) {
			tft3.setStyle("-fx-background-color: lime;");
		} else {
			tft3.setStyle("-fx-background-color: red;");
		}
	}

	/**---------------------------------------------------------------------------------------------------------------------*
	 * Environement initializing : init + checkresult
	 **_____________________________________________________________________________________________________________________*/

	public void initEnvironnement() {

		/*Travelling loading */
		try {
			enviVocab = loadCSV("ressources/documents/environnement.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final ObservableList<Vocabulary> enviData = FXCollections.observableArrayList(enviVocab);
		enviCol1.setCellValueFactory(new PropertyValueFactory<Vocabulary, String>("word"));
		enviCol2.setCellValueFactory(new PropertyValueFactory<Vocabulary, String>("translation"));
		enviTable.setItems(enviData);
	}

	public void checkResultEnvi() {
		/*Check first word*/
		if (tfe1.getText().equals(enviVocab.get(j1).getWord())) {
			tfe1.setStyle("-fx-background-color: lime;");
		} else {
			tfe1.setStyle("-fx-background-color: red;");
		}

		/*Check second word*/
		if (tfe2.getText().equals(enviVocab.get(j2).getWord())) {
			tfe2.setStyle("-fx-background-color: lime;");
		} else {
			tfe2.setStyle("-fx-background-color: red;");
		}
		
		/*Check third word*/
		if (tfe3.getText().equals(enviVocab.get(j3).getWord())) {
			tfe3.setStyle("-fx-background-color: lime;");
		} else {
			tfe3.setStyle("-fx-background-color: red;");
		}
	}
	
	/**---------------------------------------------------------------------------------------------------------------------*
	 * Company initializing : init + checkresult
	 **_____________________________________________________________________________________________________________________*/

	public void initCompany() {

		/*Company loading */
		try {
			compVocab = loadCSV("ressources/documents/company.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final ObservableList<Vocabulary> compData = FXCollections.observableArrayList(compVocab);
		compCol1.setCellValueFactory(new PropertyValueFactory<Vocabulary, String>("word"));
		compCol2.setCellValueFactory(new PropertyValueFactory<Vocabulary, String>("translation"));
		compTable.setItems(compData);
	}

	public void checkResultComp() {
		/*Check first word*/
		if (tfc1.getText().equals(compVocab.get(k1).getWord())) {
			tfc1.setStyle("-fx-background-color: lime;");
		} else {
			tfc1.setStyle("-fx-background-color: red;");
		}

		/*Check second word*/
		if (tfc2.getText().equals(compVocab.get(k2).getWord())) {
			tfc2.setStyle("-fx-background-color: lime;");
		} else {
			tfc2.setStyle("-fx-background-color: red;");
		}
		
		/*Check third word*/
		if (tfc3.getText().equals(compVocab.get(k3).getWord())) {
			tfc3.setStyle("-fx-background-color: lime;");
		} else {
			tfc3.setStyle("-fx-background-color: red;");
		}
	}
	

	public void initWords() {
		do {
			i1 = (new Random()).nextInt(travellingVocab.size());
			i2 = (new Random()).nextInt(travellingVocab.size());
			i3 = (new Random()).nextInt(travellingVocab.size());
		} while (i1==i2 || i2==i3);

		wt1.setText(""+travellingVocab.get(i1).getTranslation());
		wt2.setText(""+travellingVocab.get(i2).getTranslation());
		wt3.setText(""+travellingVocab.get(i3).getTranslation());
		
		do {
			j1 = (new Random()).nextInt(enviVocab.size());
			j2 = (new Random()).nextInt(enviVocab.size());
			j3 = (new Random()).nextInt(enviVocab.size());
		} while (j1==j2 || j2==j3);

		we1.setText(""+enviVocab.get(j1).getTranslation());
		we2.setText(""+enviVocab.get(j2).getTranslation());
		we3.setText(""+enviVocab.get(j3).getTranslation());
		
		/*do {
			k1 = (new Random()).nextInt(compVocab.size());
			k2 = (new Random()).nextInt(compVocab.size());
			k3 = (new Random()).nextInt(compVocab.size());
		} while (k1==k2 || k2==k3);

		wc1.setText(""+compVocab.get(k1).getTranslation());
		wc2.setText(""+compVocab.get(k2).getTranslation());
		wc3.setText(""+compVocab.get(k3).getTranslation());*/
	}
	
	public void newWords(){
		initWords();
		
		resetTextField(tft1);
		resetTextField(tft2);
		resetTextField(tft3);
		
		resetTextField(tfe1);
		resetTextField(tfe2);
		resetTextField(tfe3);
		
		resetTextField(tfc1);
		resetTextField(tfc2);
		resetTextField(tfc3);
		
	}
	
	public void resetTextField(TextField tf) {
		tf.setText("");
		tf.setStyle("-fx-background-color: white;");
	}

	/**---------------------------------------------------------------------------------------------------------------------*
	 * CSV Loader function
	 **_____________________________________________________________________________________________________________________*/

	public static ArrayList<Vocabulary> loadCSV(String str) throws IOException {
		ArrayList<Vocabulary> vocab = new ArrayList<Vocabulary>();

		FileReader fr = new FileReader(str);
		BufferedReader br = new BufferedReader(fr);
		String currentLine;

		while ((currentLine = br.readLine()) != null) {
			String[] line = currentLine.split(";", 2);
			String word  = line[0]; // Word
			String trans =line[1]; // translation
			vocab.add(new Vocabulary(word,trans));
		}
		br.close();
		fr.close();
		return vocab;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initTravelling();
		initEnvironnement();
		initWords();
		//initCompany();
	}

}
