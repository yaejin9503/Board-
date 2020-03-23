package global.sesoc.test6.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import global.sesoc.test6.vo.Board;

@Repository
public class BoardRepository {
	
	@Autowired
	SqlSession session;
	
	public int insert(Board board){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.insert(board);
		return result; 
	}
	
	public ArrayList<Board> selectAll_backup(String searchItem, String searchWord,int srow, int erow) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		map.put("srow", srow);
		map.put("erow", erow);
		ArrayList<Board> list = mapper.selectAll_backup(map);
		return list;
	}

	public Board selectOne(int boardseq) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Board result = mapper.selectOne(boardseq);
		return result;
	}

	//백업본 
	public int getBoardCount(String searchItem, String searchWord,int srow, int erow) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		map.put("srow", srow);
		map.put("erow", erow);
		int total = mapper.getBoardCount(map); 
		return total;
	}

	public int deleteBoard(int boardseq) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.delete(boardseq);
		return result;
	}

	public int updateBoard(Board board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.update(board);
		return result; 
	}
	
	//real
	public int getBoardCount(String searchItem, String searchWord) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		Map<String, Object> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		
		int total = mapper.getBoardCount(map); 
		
		return total;
	}

	//real
	public List<Board> selectAll(String searchItem, String searchWord, int startRecord, int countPerPage) {
		List<Board> list;
		RowBounds rb = new RowBounds(startRecord,countPerPage);
		BoardMapper mapper = session.getMapper(BoardMapper.class); // reflection 투영한다는 뜼
		Map<String,String> map = new HashMap<>();
		map.put("searchItem", searchItem);
		map.put("searchWord", searchWord);
		
		list = mapper.selectAll(map,rb); 
		
		return list;
	}
	
	public int updateViewcount(int boardseq){
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		int result = mapper.updateViewcount(boardseq);
		return result;
	}
}
