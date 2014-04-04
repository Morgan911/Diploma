package letters.uicontrollers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import letters.db.LetterDao;
import letters.db.LineDao;
import letters.model.Letter;
import letters.ui.LetterUI;
import letters.ui.LineUI;
import screenFramework.ControlledScreen;
import screenFramework.ScreensController;

public class PatternPageController implements ControlledScreen, Initializable{
	
	private ScreensController sc;
	@FXML
	private StackPane container;
	@FXML
	private Button nextButton;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			Letter let = LetterDao.getInstance().getLetterByName("Enquiry");
			LetterUI l = new LetterUI(let);
			container.getChildren().add(l);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		sc = screenPage;
	}
	
}
