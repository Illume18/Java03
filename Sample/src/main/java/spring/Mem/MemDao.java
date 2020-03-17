package spring.Mem;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;


public class MemDao extends SqlSessionDaoSupport {
	
	public int insert(MemDto dto) {
		int i = 0;
		try{i= getSqlSession().insert("member.add",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	
	
	/*public int insert(MemDto dto) {
		return getSqlSession().insert("member.add",dto);*/
	}
}
