package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screenFramework.ScreensController;

public class Main extends Application {

	public static String screen1ID = "main";
	public static String screen1File = "../letters/ui/LetterMenu.fxml";

	@Override
	public void start(Stage primaryStage) {

		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Main.screen1ID,
				Main.screen1File);

		mainContainer.setScreen(Main.screen1ID);

		Group root = new Group();
		root.getChildren().addAll(mainContainer);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/**
	 * The main() method is ignored in correctly deployed JavaFX application.
	 * main() serves only as fallback in case the application can not be
	 * launched through deployment artifacts, e.g., in IDEs with limited FX
	 * support. NetBeans ignores main().
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
