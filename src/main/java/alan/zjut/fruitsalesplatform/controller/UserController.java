package alan.zjut.fruitsalesplatform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import alan.zjut.fruitsalesplatform.entity.User;
import alan.zjut.fruitsalesplatform.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/user/toLogin.action")
	public String toLogin() {
		return "/login.jsp";//转向登录
	}
	
	@RequestMapping("/user/login.action")
	public String login(User user,Model model,HttpServletRequest request) {
		Map<String,String> map=new HashMap<>();
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		List<User> userList=userService.find(map);
		if(userList!=null&&userList.size()>0) {
			request.getSession().setAttribute("user", userList.get(0));
			model.addAttribute("user", userList.get(0));
			return "/home.jsp";//跳主页
		}
		model.addAttribute("errorMsg","登录失败！账号或密码错误！");
		return "/login.jsp";//转向登录页面
	}
	
	//跳转至注册页面
	@RequestMapping("/user/registerPage.action")
	public String toRegister() {
		return "/register.jsp";
	}
	
	//注册
	@RequestMapping("/user/register.action")
	public String register(User user,Model model,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		//查找是否被注册
		Map<String, String> map=new HashMap<>();
		map.put("username", user.getUsername());
		List<User> userList=userService.find(map);
		if(userList!=null&&userList.size()>0) {
			model.addAttribute("errorMsg", "注册失败，用户名已被占用！");
			return "/register.jsp";
		}
		user.setUserid(UUID.randomUUID().toString());
		userService.insert(user);
		model.addAttribute("noticeMsg", "注册成功，请输入账户密码登录");
		return "/login.jsp";
	}
}
