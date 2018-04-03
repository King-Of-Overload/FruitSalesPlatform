package alan.zjut.fruitsalesplatform.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import alan.zjut.fruitsalesplatform.dao.TestDao;
import alan.zjut.fruitsalesplatform.entity.User;
//添加注解为了扫描到
@Repository
public class TestDaoImpl implements TestDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession=null;
	
	private SqlSession getSqlSession() {
		if(sqlSession==null) {
			sqlSession=sqlSessionFactory.openSession();
		}
		return sqlSession;
	}
	@Override
	public List<User> findUserByName(User user) {
		List<User> uList=getSqlSession().selectList("test.findUserByName", "%"+user.getName()+"%");
		sqlSession.close();
		sqlSession=null;
		return uList;
	}

}
