package alan.zjut.fruitsalesplatform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import alan.zjut.fruitsalesplatform.entity.Retailer;
import alan.zjut.fruitsalesplatform.service.RetailerService;

/**
 * 零售商管理
 * @author Alan-Mac
 *
 */
@Controller
public class RetailerController extends BaseController {
	@Autowired
	private RetailerService retailerService;
	//跳转到列表页面
	@RequestMapping("/retailer/list.action")
	public String list(Model model,Retailer retailer,String startTime,String endTime) {
		Map<String,Object> map=retailerToMap(retailer);
		if(startTime!=null&&!startTime.equals("")) {
			map.put("startTime", startTime);
		}
		if(endTime!=null&&!endTime.equals("")) {
			map.put("endTime", endTime);
		}
		List<Retailer> retailerList=retailerService.find(map);
		model.addAttribute("list", retailerList);
		return "/retailer/retailerHome.jsp";//转向首页
	}
	
	
	
	private Map<String,Object> retailerToMap(Retailer retailer){
		Map<String,Object> map=new HashMap<>();
		map.put("name", checkStringIsEmpty(retailer.getName()));
		map.put("telephone", checkStringIsEmpty(retailer.getTelephone()));
		map.put("address", checkStringIsEmpty(retailer.getAddress()));
		map.put("status", retailer.getStatus()==-1?null:retailer.getStatus());
		map.put("createTime", retailer.getCreateTime());
		map.put("startPage", retailer.getStartPage());
		map.put("pageSize", retailer.getPageSize());
		return map;
	}
	
	private String checkStringIsEmpty(String param) {
		return param==null?null:(param.equals("")?null:"%"+param+"%");
	}
	
}
