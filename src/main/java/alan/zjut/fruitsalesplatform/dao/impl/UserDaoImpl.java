package alan.zjut.fruitsalesplatform.dao.impl;

import org.springframework.stereotype.Repository;

import alan.zjut.fruitsalesplatform.dao.UserDao;
import alan.zjut.fruitsalesplatform.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	public UserDaoImpl() {
		super.setNamespace("alan.zjut.fruitsalesplatform.mapper.UserMapper");
	}
}
