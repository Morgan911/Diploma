package letters.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import letters.enums.ControlType;
import letters.model.Control;

public class ControlDao {
	
	private static final String GETITEMSBYCONTROL = "SELECT items.name "
			+ "FROM `items` items "
			+ "JOIN `controlitem` ci "
			+ "ON items.id = ci.itemid "
			+ "JOIN `controls` controls "
			+ "ON controls.id = ci.controlid "
			+ "WHERE controls.id = ?;";
	private static final String GETCONTROLIDSBYLINEID = "SELECT lc.ControlId FROM `linecontrol` lc WHERE lc.LineId = ?;";
	private static final String GETCONTROLTYPEBYID = "SELECT ct.type FROM `controltypes` ct JOIN `controls` controls ON controls.ControlType = ct.id WHERE controls.id = ?;";
	private static ControlDao instance;
	
	private ControlDao(){
		
	}
	
	public static ControlDao getInstance(){
		if(instance == null){
			instance = new ControlDao();
		}
		return instance;
	}
	
	public List<Control> getControlsByLineID(int id) throws SQLException{
		List<Control> result = new ArrayList<Control>();
		List<Integer> ids = getControlsIDsByLineID(id);
		for (int i : ids) {
			result.add(new Control(i, getControlTypeById(i), getItemsByControl(i)));
		}
		return result;
	}
	
	private ControlType getControlTypeById(int id) throws SQLException{
		ControlType result = null;
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETCONTROLTYPEBYID, PreparedStatement.RETURN_GENERATED_KEYS);
		sttm.setInt(1, id);
		ResultSet rSet = sttm.executeQuery();
		if(rSet.next())
			result = ControlType.valueOf(rSet.getString("type"));
		sttm.close();
		conn.close();
		return result;
	}
	
	private List<String> getItemsByControl(int id) throws SQLException{
		List<String> result = new ArrayList<String>();
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETITEMSBYCONTROL, PreparedStatement.RETURN_GENERATED_KEYS);
		sttm.setInt(1, id);
		ResultSet rSet = sttm.executeQuery();
		while(rSet.next()){
			result.add(rSet.getString("name"));
		}
		sttm.close();
		conn.close();
		return result;
	}
	
	private List<Integer> getControlsIDsByLineID(int id) throws SQLException{
		List<Integer> result = new ArrayList<>();
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETCONTROLIDSBYLINEID, PreparedStatement.RETURN_GENERATED_KEYS);
		sttm.setInt(1, id);
		ResultSet rSet = sttm.executeQuery();
		while(rSet.next()){
			result.add(rSet.getInt(1));
		}
		sttm.close();
		conn.close();
		return result;
	}
}
