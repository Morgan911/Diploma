package letters.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import letters.model.Block;
import letters.model.Line;

public class BlockDao {

	private static BlockDao instance;
	private static final String GETBLOCKIDS = "SELECT blocks.id FROM `blocks` blocks "
			+ "JOIN `letterblock` lb "
			+ "ON blocks.id = lb.idBlock "
			+ "JOIN `letters` letters "
			+ "ON letters.id = lb.idLetter "
			+ "WHERE letters.Name = ?;"; 
	
	private BlockDao(){
		
	}
	
	public static BlockDao getInstance(){
		if(instance == null){
			instance = new BlockDao();
		}
		return instance;
	}
	
	public List<Block> getBlocksByLetterName(String letterName) throws SQLException{
		List<Block> result =  new ArrayList<Block>();
		List<Integer> ids = getBlockIDsByLetterName(letterName);
		for (int i : ids) {
			result.add(new Block(i, LineDao.getInstance().getLinesByBlockID(i)));
		}
		return result;
	}
	
	public List<Integer> getBlockIDsByLetterName(String letterName) throws SQLException{
		List<Integer> result =  new ArrayList<Integer>();
		Connection conn = DBWorker.getInstance().openConnection();
		PreparedStatement sttm = conn.prepareStatement(GETBLOCKIDS, PreparedStatement.RETURN_GENERATED_KEYS);
		sttm.setString(1, letterName);
		ResultSet rSet = sttm.executeQuery();
		while(rSet.next()){
			result.add(rSet.getInt(1));
		}
		sttm.close();
		conn.close();
		return result;
	}
}
