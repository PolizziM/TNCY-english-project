package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;

public class MediumController {

	@FXML private Main main;
	@FXML private AnchorPane practicePane;
	
	@FXML
	public void goVocab(ActionEvent event) throws IOException {
		FXMLLoader gloader = new FXMLLoader();
		gloader.setLocation(Main.class.getResource("VocabularyView.fxml"));
		AnchorPane Pane = gloader.load();
		practicePane.getChildren().clear();
		practicePane.getChildren().add(Pane);
	}

	@FXML
	public void goTOEIC(ActionEvent event) throws IOException {
		FXMLLoader gloader = new FXMLLoader();
		gloader.setLocation(Main.class.getResource("ToeicView.fxml"));
		AnchorPane Pane = gloader.load();
		practicePane.getChildren().clear();
		practicePane.getChildren().add(Pane);
	}

	@FXML
	public void goHome(ActionEvent event) throws IOException {
		FXMLLoader mainLoader = new FXMLLoader();
		mainLoader.setLocation(Main.class.getResource("MainView.fxml"));
		AnchorPane mainPane = mainLoader.load();
		Scene scene = new Scene(mainPane);
		main.primaryStage.setScene(scene);
		main.primaryStage.show();
	}

	

}
