package letters.uicontrollers;

import java.net.URL;
import java.util.ResourceBundle;

import screenFramework.ControlledScreen;
import screenFramework.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class LetterMenuController implements Initializable, ControlledScreen{

	@FXML
	private ListView list;
	ScreensController myController;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	@Override
	public void setScreenParent(ScreensController screenPage) {
		
		myController = screenPage;
	}
	
}
