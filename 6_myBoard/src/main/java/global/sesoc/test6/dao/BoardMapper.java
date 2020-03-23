package global.sesoc.test6.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import global.sesoc.test6.vo.Board;

public interface BoardMapper {
	
	public int insert(Board board); //등록 
	public int delete (int boardseq);//삭제
	public int update(Board board);//수정
	public ArrayList<Board> selectAll_backup(Map<String,Object> map);//전체 목록
	public ArrayList<Board> selectAll(Map<String,String> map,RowBounds rb);//백업 전체목
	public Board selectOne(int boardseq);//한개 보기
	public int getBoardCount(Map<String, Object> map);//글 개수 
	public int updateViewcount(int boardseq);
}
