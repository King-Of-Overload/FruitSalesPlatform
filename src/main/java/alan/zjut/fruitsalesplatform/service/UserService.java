package alan.zjut.fruitsalesplatform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import alan.zjut.fruitsalesplatform.entity.User;

public interface UserService {
public User get(Serializable id);//查询一个数据，常用于修改
	
	public List<User> find(Map map);//根据条件查询
	
	public void insert(User entity);//插入
	
	public void update(User entity);
	
	public void deleteById(Serializable id);
	
	public void delete(Serializable[] ids);//批量删除
}
