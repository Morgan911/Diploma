package letters.ui;

import java.util.List;

import javafx.scene.layout.VBox;
import letters.model.Block;
import letters.model.Letter;

public class LetterUI extends VBox{
	
	private Letter letter;
	
	public LetterUI(Letter letter){
		setLetter(letter);
		addBlocks();
	}

	public Letter getLetter() {
		return letter;
	}

	private void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	private void addBlocks() {
		List<Block> blocks = getLetter().getBlocks();
		for (Block block : blocks) {
			this.getChildren().add(new BlockUI(block));
		}
	}
}