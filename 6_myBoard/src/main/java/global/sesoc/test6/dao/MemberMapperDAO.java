package global.sesoc.test6.dao;

import global.sesoc.test6.vo.Member;

public interface MemberMapperDAO {
	public int insert(Member member); 
	public int delete(Member member);
	public Member login(Member member); 
	public int update(Member member); 
}
