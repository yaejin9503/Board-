package global.sesoc.test6.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test6.vo.Member;

@Repository
public class MemberRepository {
	@Autowired
	SqlSession session; 
	
	public int insert(Member m) {
		MemberMapperDAO mapper = session.getMapper(MemberMapperDAO.class); 
		int result = mapper.insert(m); 
		return result; 
	}
	
	public Member selectone(Member m){
		MemberMapperDAO mapper = session.getMapper(MemberMapperDAO.class); 
		Member result = mapper.login(m); 
		return result;
	}

	public int delete(Member m) {
		MemberMapperDAO mapper = session.getMapper(MemberMapperDAO.class); 
		int result = mapper.delete(m);
		return result;
	}
	
	public int update(Member m){
		MemberMapperDAO mapper = session.getMapper(MemberMapperDAO.class);
		int result = mapper.update(m); 
		return result;
	}
}
