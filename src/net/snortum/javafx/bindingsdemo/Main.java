package net.snortum.javafx.bindingsdemo;

import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	private static final String RESOURCE = "BindingsDemo.fxml";

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		// You can set the URL manually like this (in Windows):
		// URL location = new URL("file:///C/User/Joe/Java/file.fxml");
		URL location = getClass().getClassLoader().getResource(RESOURCE);
		
		if (location == null) {
			System.out.println("Could not find " + RESOURCE);
			Platform.exit();
			return;
		}

		FXMLLoader loader = new FXMLLoader(location);
		// Must use an instance method of load()
		BorderPane root = loader.<BorderPane>load();
		BookController bookController = loader.getController();
		// Controller need the stage in order to close properly
		bookController.setStage(stage);
		
		stage.setScene(new Scene(root));
		stage.setTitle("Binding Demo");
		stage.show();
	}

}
