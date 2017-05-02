package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class BeginnerController {

	@FXML private Main main;
	@FXML private AnchorPane practicePane;
	@FXML private TabPane tabPane;
	@FXML private IVerbsController ivc;
	public String loadedFxml;
	
	@FXML
	public void goGrammar(ActionEvent event) throws IOException {
		FXMLLoader gloader = new FXMLLoader();
		gloader.setLocation(Main.class.getResource("GrammarView.fxml"));
		AnchorPane IVPane = gloader.load();
		practicePane.getChildren().clear();
		practicePane.getChildren().add(IVPane);
	}

	@FXML
	public void goIVerbs(ActionEvent event) throws IOException {
		FXMLLoader gloader = new FXMLLoader();
		gloader.setLocation(Main.class.getResource("IVerbsView.fxml"));
		TabPane IVPane = gloader.load();
		practicePane.getChildren().clear();
		practicePane.getChildren().add(IVPane);
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
