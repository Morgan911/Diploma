package letters.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import letters.model.Control;
import letters.model.Line;

public class LineDao {
	private static LineDao instance;
	private LineDao(){
		
	}
	
	public static LineDao getInstance(){
		if(instance == null){
			instance = new LineDao();
		}
		return instance;
	}
	
	private static final String GETLINESBYBLOCKID = "SELECT bl.LineId FROM `blockline` bl WHERE bl.BlockId = ?;";
	
	public List<Line> getLinesByBlockID(int id) throws SQLException{
		List<Line> result = new ArrayList<Line>();
		List<Integer> ids = getLineIDsByBlockID(id);
		for (int i : ids) {
			result.add(new Line(i, ControlDao.getInstance().getControlsByLineID(i)));
		}
		return result;
	}

	private List<Integer> getLineIDsByBlockID(int id) throws SQLException {
		List<Integer> result = new ArrayList<>();
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETLINESBYBLOCKID, PreparedStatement.RETURN_GENERATED_KEYS);
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
