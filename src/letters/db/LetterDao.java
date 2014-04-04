package letters.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import letters.model.Block;
import letters.model.Letter;

public class LetterDao {

	private static LetterDao instance;
	private static final String GETLETTERSNAMES = "SELECT `Name` FROM `letters`;"; 
	private static final String GETIDBYNAME = "SELECT l.id FROM `Letters` l WHERE l.name = ?;"; 
	
	private LetterDao(){
		
	}
	
	public static LetterDao getInstance(){
		if(instance == null){
			instance = new LetterDao();
		}
		return instance;
	}
	
	public List<String> getNames() throws SQLException{
		List<String> result = new ArrayList<String>();
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETLETTERSNAMES);
		ResultSet rSet = sttm.executeQuery();
		while(rSet.next()){
			result.add(rSet.getString("Name"));
		}
		sttm.close();
		conn.close();
		return result;
	}
	
	
	
	public Letter getLetterByName(String letterName) throws SQLException{
		List<Block> blocks = BlockDao.getInstance().getBlocksByLetterName(letterName);
		return new Letter(getIdByName(letterName),letterName, blocks);
		
	}
	
	private int getIdByName(String letterName) throws SQLException{
		int result = 0;
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETIDBYNAME, PreparedStatement.RETURN_GENERATED_KEYS);
		sttm.setString(1, letterName);
		ResultSet rSet = sttm.executeQuery();
		if(rSet.next())
			result = rSet.getInt(1);
		return result;
	}
}
