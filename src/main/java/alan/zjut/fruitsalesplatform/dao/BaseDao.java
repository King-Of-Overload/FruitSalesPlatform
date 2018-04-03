package alan.zjut.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//基础dao接口
public interface BaseDao<T> {
	public T get(Serializable id);//查询一个数据，常用于修改
	
	public List<T> find(Map map);//根据条件查询
	
	public void insert(T entity);//插入
	
	public void update(T entity);
	
	public void deleteById(Serializable id);
	
	public void delete(Serializable[] ids);//批量删除
}
