package letters.uicontrollers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.Main;
import screenFramework.ControlledScreen;
import screenFramework.ScreensController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import letters.db.BlockDao;
import letters.db.ControlDao;
import letters.db.DBWorker;
import letters.db.LetterDao;

public class MainMenuController implements ControlledScreen, Initializable{

	private ScreensController sc;
	
	@FXML
	private ListView<Object> letterNameList;
	@FXML
	private Button createButton;
	
	@Override
	public void setScreenParent(ScreensController screenPage) {
		sc = screenPage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			letterNameList.getItems().addAll(LetterDao.getInstance().getNames());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void createLetterListener() throws SQLException{
		String selectedName = letterNameList.selectionModelProperty().getName();
		sc.setScreen(Main.pattern);
		//PatternPageController.setLetter(LetterDao.getInstance().getLetterByName(selectedName));
	}
}
