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

public class AdvancedController {

	@FXML private Main main;
	@FXML private AnchorPane practicePane;
	
	@FXML
	public void goGeneralKnowledge(ActionEvent event) throws IOException {
		FXMLLoader gloader = new FXMLLoader();
		gloader.setLocation(Main.class.getResource("GerenalKnowledgeView.fxml"));
		AnchorPane GKPane = gloader.load();
		practicePane.getChildren().clear();
		practicePane.getChildren().add(GKPane);
	}

	@FXML
	public void goArticles(ActionEvent event) throws IOException {
		FXMLLoader gloader = new FXMLLoader();
		gloader.setLocation(Main.class.getResource("ArticlesView.fxml"));
		AnchorPane ArticlePane = gloader.load();
		practicePane.getChildren().clear();
		practicePane.getChildren().add(ArticlePane);
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
