package alan.zjut.fruitsalesplatform.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import alan.zjut.fruitsalesplatform.dao.BaseDao;

public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
	
	@Autowired
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	private String namespace;//命名空间
	
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public T get(Serializable id) {
		return this.getSqlSession().selectOne(namespace+".get", id);
	}

	@Override
	public List<T> find(Map map) {
		List<T> oList=this.getSqlSession().selectList(namespace+".find", map);
		return oList;
	}

	@Override
	public void insert(T entity) {
		this.getSqlSession().insert(namespace+".insert", entity);
	}

	@Override
	public void update(T entity) {
		this.getSqlSession().update(namespace+".update", entity);
	}

	@Override
	public void deleteById(Serializable id) {
		this.getSqlSession().delete(namespace+".deleteById", id);
	}

	@Override
	public void delete(Serializable[] ids) {
		this.getSqlSession().delete(namespace+".delete", ids);
	}

}
