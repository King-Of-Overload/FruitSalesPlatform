package alan.zjut.fruitsalesplatform.dao;

import java.util.List;

import alan.zjut.fruitsalesplatform.entity.User;

public interface TestDao {
	public List<User> findUserByName(User user);
}
