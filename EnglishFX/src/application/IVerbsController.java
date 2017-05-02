package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import Tools.Verbs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class IVerbsController implements Initializable {

	private ArrayList<Verbs> verbs = null;
	@FXML private TableView<Verbs> tableView;
	@FXML private TableColumn<Verbs, String> verbalBaseCol; @FXML private TableColumn<Verbs, String> preteritCol; @FXML private TableColumn<Verbs, String> pastParticipleCol; @FXML private TableColumn<Verbs, String> translationCol;
	@FXML private Text verb1; @FXML private Text verb2; @FXML private Text verb3;
	@FXML private TextField vb1; @FXML private TextField vb2; @FXML private TextField vb3;
	@FXML private TextField ptr1; @FXML private TextField ptr2; @FXML private TextField ptr3;
	@FXML private TextField pp1; @FXML private TextField pp2; @FXML private TextField pp3;
	@FXML private CheckBox cb1; @FXML private CheckBox cb2; @FXML private CheckBox cb3;
	int i1, i2, i3;
	int[] iList = {i1,i2,i3};


	/**
	 * Functions to manage the verbs and text fields
	 * */
	@FXML
	public void newVerbs() {
		initVerbsList();
		resetTextField(vb1,ptr1,pp1);
		resetTextField(vb2,ptr2,pp2);
		resetTextField(vb3,ptr3,pp3);
	}

	public void resetTextField(TextField vb, TextField ptr, TextField pp) {
		vb.setText("");
		vb.setStyle("-fx-background-color: white;");
		ptr.setText("");
		ptr.setStyle("-fx-background-color: white;");
		pp.setText("");
		pp.setStyle("-fx-background-color: white;");
	}

	@FXML
	public void checkResults() {
		/*Check verbal base*/
		if (vb1.getText().equals(verbs.get(i1).getVerbalBase())) {
			vb1.setStyle("-fx-background-color: lime;");
		} else {
			vb1.setStyle("-fx-background-color: red;");
		}

		if (vb2.getText().equals(verbs.get(i2).getVerbalBase())) {
			vb2.setStyle("-fx-background-color: lime;");
		} else {
			vb2.setStyle("-fx-background-color: red;");
		}

		if (vb3.getText().equals(verbs.get(i3).getVerbalBase())) {
			vb3.setStyle("-fx-background-color: lime;");
		} else {
			vb3.setStyle("-fx-background-color: red;");
		}

		/*Check preterit*/
		if (ptr1.getText().equals(verbs.get(i1).getPreterit())) {
			ptr1.setStyle("-fx-background-color: lime;");
		} else {
			ptr1.setStyle("-fx-background-color: red;");
		}

		if (ptr2.getText().equals(verbs.get(i2).getPreterit())) {
			ptr2.setStyle("-fx-background-color: lime;");
		} else {
			ptr2.setStyle("-fx-background-color: red;");
		}

		if (ptr3.getText().equals(verbs.get(i3).getPreterit())) {
			ptr3.setStyle("-fx-background-color: lime;");
		} else {
			ptr3.setStyle("-fx-background-color: red;");
		}

		/*Check past participle*/

		if (pp1.getText().equals(verbs.get(i1).getPastParticiple())) {
			pp1.setStyle("-fx-background-color: lime;");
		} else {
			pp1.setStyle("-fx-background-color: red;");
		}

		if (pp2.getText().equals(verbs.get(i2).getPastParticiple())) {
			pp2.setStyle("-fx-background-color: lime;");
		} else {
			pp2.setStyle("-fx-background-color: red;");
		}

		if (pp3.getText().equals(verbs.get(i3).getPastParticiple())) {
			pp3.setStyle("-fx-background-color: lime;");
		} else {
			pp3.setStyle("-fx-background-color: red;");
		}
	}

	/**
	 * Hint functions
	 * */
	public void gimmeaHint1() {
		if (cb1.isSelected()) {
			vb1.setText(verbs.get(i1).getVerbalBase());
		} else {
			vb1.setText("");
		}
	}

	public void gimmeaHint2() {
		if (cb2.isSelected()) {
			vb2.setText(verbs.get(i2).getVerbalBase());
		} else {
			vb2.setText("");
		}
	}

	public void gimmeaHint3() {
		if (cb3.isSelected()) {
			vb3.setText(verbs.get(i3).getVerbalBase());
		} else {
			vb3.setText("");
		}
	}

	/**
	 * Initializer
	 * */

	public ArrayList<Verbs> loadCSV(String str) throws FileNotFoundException {
		File file = new File(str);
		Scanner sc = new Scanner(file);
		String line = sc.next();

		ArrayList<Verbs> verbs = new ArrayList<Verbs>();


		for (int i = 0;i<161;i++) {

			Scanner scLine = new Scanner(line);
			scLine.useDelimiter(";");

			String verbalBase = scLine.next(); // Verbal Base
			String preterit = scLine.next(); // Preterit
			String pastParticiple = scLine.next(); // Past Participle
			String t1 = scLine.next(); // Translation 1
			String t2 = scLine.next(); // Translation 2

			verbs.add(new Verbs(verbalBase,preterit,pastParticiple,t1,t2));
			scLine.close();
			line = sc.next();
		}
		sc.close();
		return verbs;
	}

	@FXML
	public void initTable() {
		try {
			verbs = loadCSV("ressources/documents/irregularVerbs.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final ObservableList<Verbs> data = FXCollections.observableArrayList(verbs);

		verbalBaseCol.setCellValueFactory(new PropertyValueFactory<Verbs, String>("verbalBase"));
		preteritCol.setCellValueFactory(new PropertyValueFactory<Verbs, String>("preterit"));
		pastParticipleCol.setCellValueFactory(new PropertyValueFactory<Verbs, String>("pastParticiple"));
		translationCol.setCellValueFactory(new PropertyValueFactory<Verbs, String>("t1"));

		tableView.setItems(data);
	}

	@FXML
	public void initVerbsList() {
		do {
			i1 = (new Random()).nextInt(161);
			i2 = (new Random()).nextInt(161);
			i3 = (new Random()).nextInt(161);
		} while (i1 == i2 || i1 == i3);

		verb1.setText(""+ verbs.get(i1).getT1());
		verb2.setText(""+ verbs.get(i2).getT1());
		verb3.setText(""+ verbs.get(i3).getT1());
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//initLoading();
		initTable();
		initVerbsList();
		
		/*Show the list "verbs"
		 * for (int i=0;i<160;i++) {
			System.out.println("\nVB: "+verbs.get(i).getVerbalBase()+"\nPTR: "+verbs.get(i).getPreterit()+"\nPP: "+ verbs.get(i).getPastParticiple());

		}*/

	}

}
