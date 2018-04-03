package alan.zjut.fruitsalesplatform.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alan.zjut.fruitsalesplatform.dao.RetailerDao;
import alan.zjut.fruitsalesplatform.entity.Retailer;
import alan.zjut.fruitsalesplatform.service.RetailerService;

@Service
public class RetailerServiceImpl implements RetailerService {
	@Autowired
	private RetailerDao retailerDao;
	@Override
	public int count(Map map) {
		return retailerDao.count(map);
	}

	@Override
	public Retailer get(Serializable id) {
		return retailerDao.get(id);
	}

	@Override
	public List<Retailer> find(Map map) {
		return retailerDao.find(map);
	}

	@Override
	public void insert(Retailer entity) {
		retailerDao.insert(entity);
	}

	@Override
	public void update(Retailer entity) {
		retailerDao.update(entity);
	}
	

	@Override
	public void deleteById(Serializable id) {
		retailerDao.deleteById(id);
	}

	@Override
	public void delete(Serializable[] ids) {
		retailerDao.delete(ids);
	}

}
