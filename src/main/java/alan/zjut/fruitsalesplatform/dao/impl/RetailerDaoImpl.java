package alan.zjut.fruitsalesplatform.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import alan.zjut.fruitsalesplatform.dao.RetailerDao;
import alan.zjut.fruitsalesplatform.entity.Retailer;
@Repository
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {
	
	public RetailerDaoImpl() {
		super.setNamespace("alan.zjut.fruitsalesplatform.mapper.RetailerMapper");
	}
	@Override
	public int count(Map map) {
		return this.getSqlSession().selectOne(this.getNamespace()+".count", map);
	}

}
