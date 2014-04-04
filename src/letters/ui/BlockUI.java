package letters.ui;

import java.util.List;

import javafx.scene.layout.VBox;
import letters.model.Block;
import letters.model.Line;

public class BlockUI extends VBox{

	private Block block;
	
	public BlockUI(Block block){
		setBlock(block);
		addLines();
	}

	public Block getBlock() {
		return block;
	}

	private void setBlock(Block block) {
		this.block = block;
	}

	private void addLines() {
		List<Line> lines = getBlock().getLines();
		for (Line line : lines) {
			getChildren().add(new LineUI(line));
		}
	}
}
