package alan.zjut.fruitsalesplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alan.zjut.fruitsalesplatform.dao.TestDao;
import alan.zjut.fruitsalesplatform.entity.User;
import alan.zjut.fruitsalesplatform.service.TestService;
@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testDao;
	@Override
	public List<User> findUserByName(User user) {
		return testDao.findUserByName(user);
	}

}
