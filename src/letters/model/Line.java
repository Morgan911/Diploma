package letters.model;

import java.util.List;

public class Line {
	
	private int id;
	private List<Control> controls;
	
	public Line(int id, List<Control> controls){
		setId(id);
		setControls(controls);
	}

	public List<Control> getControls() {
		return controls;
	}

	public void setControls(List<Control> controls) {
		this.controls = controls;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
