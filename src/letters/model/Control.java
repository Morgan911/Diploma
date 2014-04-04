package letters.model;

import java.util.List;

import letters.enums.ControlType;

public class Control {
	
	private int id;
	private ControlType type;
	private List<String> items;
	
	public Control(int id, ControlType type){
		setId(id);
		setType(type);
	}
	
	public Control(int id, ControlType type, List<String> items){
		this(id, type);
		setItems(items);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ControlType getType() {
		return type;
	}

	public void setType(ControlType type) {
		this.type = type;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}
}
