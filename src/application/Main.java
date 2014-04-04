package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import letters.db.DBWorker;
import letters.db.LetterDao;
import screenFramework.ScreensController;

public class Main extends Application {

	public static String main = "Main";
	public static String mainPath = "../letters/ui/MainMenu.fxml";
	public static String pattern = "Pattern";
	public static String patternPath = "../letters/ui/PatternPage.fxml";

	@Override
	public void start(Stage primaryStage) {
		ScreensController mainContainer = new ScreensController();
		mainContainer.loadScreen(Main.main,
				Main.mainPath);
		mainContainer.loadScreen(Main.pattern,
				Main.patternPath);
		mainContainer.setScreen(Main.main);

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
