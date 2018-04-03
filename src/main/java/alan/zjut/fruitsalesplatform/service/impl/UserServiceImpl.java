package alan.zjut.fruitsalesplatform.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.interceptor.AroundTimeout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alan.zjut.fruitsalesplatform.dao.UserDao;
import alan.zjut.fruitsalesplatform.entity.User;
import alan.zjut.fruitsalesplatform.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public User get(Serializable id) {
		return userDao.get(id);
	}

	@Override
	public List<User> find(Map map) {
		return userDao.find(map);
	}

	@Override
	public void insert(User entity) {
		userDao.insert(entity);

	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void deleteById(Serializable id) {
		userDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		userDao.delete(ids);
	}

}
