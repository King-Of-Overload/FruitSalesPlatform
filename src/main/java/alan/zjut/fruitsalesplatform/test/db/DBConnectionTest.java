package alan.zjut.fruitsalesplatform.test.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alan.zjut.fruitsalesplatform.entity.User;

public class DBConnectionTest {
	private String resource="beans.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession=null;
	
	
	public SqlSession getSqlSession() throws Exception{
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(resource);
		sqlSessionFactory=(SqlSessionFactory) context.getBean("sessionFactory");
		sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	@Test
	public void TestSelect() throws Exception{
		sqlSession=getSqlSession();
		User user=sqlSession.selectOne("test.findUserByName", "%"+"狐"+"%");
		System.out.println("取出的用户信息：");
		System.out.println("账号："+user.getUsername());
		System.out.println("密码："+user.getPassword());
		System.out.println("姓名："+user.getUsername());
		System.out.println("电话："+user.getTelephone());
	}
}
