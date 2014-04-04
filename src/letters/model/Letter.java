package letters.model;

import java.util.List;

public class Letter {
	
	private int id;
	private String name;
	private List<Block> blocks;
	
	public Letter(int id, String name, List<Block> blocks){
		setId(id);
		setName(name);
		setBlocks(blocks);
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void setBlocks(List<Block> blocks) {
		this.blocks = blocks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
