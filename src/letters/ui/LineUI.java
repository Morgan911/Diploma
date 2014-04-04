package letters.ui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import letters.model.Control;
import letters.model.Line;

public class LineUI extends HBox{

private Line line;
	
	public LineUI(Line line){
		setLine(line);
		addControls();
	}

	public Line getLine() {
		return line;
	}

	private void setLine(Line line) {
		this.line = line;
	}
	
	private void addControls() {
		List<Control> controls = getLine().getControls();
		for (Control control : controls) {
			switch(control.getType()){
			case Label:
				getChildren().add(new Label(control.getItems().get(0)));
				break;
			case ComboBox:
				getChildren().add(new ComboBox((ObservableList) control.getItems()));
				break;
			case TextField:
				getChildren().add(new TextField());
				break;
			default:
				break;
			}
		}
		
	}
	
}
