package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;


public class MainController implements Initializable {

	private Main main;
	
	@FXML
	public void goBeginner(ActionEvent event) throws IOException {
		main.showBeginnerView();
	}
	
	@FXML
	public void goMedium(ActionEvent event) throws IOException {
		main.showMediumView();
	}
	
	@FXML
	public void goAdvanced(ActionEvent event) throws IOException {
		main.showAdvancedView();
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}
