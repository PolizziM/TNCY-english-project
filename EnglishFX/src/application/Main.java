package application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	@FXML ImageView welcomeImg;
	public static Stage primaryStage;
	private AnchorPane mainPane;
	private AnchorPane pane;
	private Button beginnerButton, mediumButton, advancedButton;

	@Override
	public void start(Stage primaryStage) throws IOException, InterruptedException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Easy English");
		
		/*Main view*/
		showMainView();

	}

	public void showMainView() throws IOException {
		FXMLLoader mainLoader = new FXMLLoader();
		mainLoader.setLocation(Main.class.getResource("MainView.fxml"));
		AnchorPane mainPane = mainLoader.load();
		Scene scene = new Scene(mainPane);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showBeginnerView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("BeginnerView.fxml"));
		AnchorPane beginnerPane = loader.load();
		Scene scene = new Scene(beginnerPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showMediumView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("MediumView.fxml"));
		AnchorPane mediumPane = loader.load();
		Scene scene = new Scene(mediumPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showAdvancedView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("AdvancedView.fxml"));
		AnchorPane advancedPane = loader.load();
		Scene scene = new Scene(advancedPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
