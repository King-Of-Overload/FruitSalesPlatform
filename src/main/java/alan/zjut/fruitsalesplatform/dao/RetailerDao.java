package alan.zjut.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import alan.zjut.fruitsalesplatform.entity.Retailer;

public interface RetailerDao extends BaseDao<Retailer>{
	public int count(Map map);
	
    public Retailer get(Serializable id);//查询一个数据，常用于修改
	
	public List<Retailer> find(Map map);//根据条件查询
	
	public void insert(Retailer entity);//插入
	
	public void update(Retailer entity);
	
	public void deleteById(Serializable id);
	
	public void delete(Serializable[] ids);//批量删除
}
