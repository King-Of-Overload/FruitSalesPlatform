package alan.zjut.fruitsalesplatform.service;

import java.util.List;

import alan.zjut.fruitsalesplatform.entity.User;

public interface TestService {
	List<User> findUserByName(User user);
}
