package letters.model;

import java.util.List;

public class Block {
	
	private int id;
	private List<Line> lines;
	
	public Block(int id, List<Line> lines){
		setId(id);
		setLines(lines);
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
