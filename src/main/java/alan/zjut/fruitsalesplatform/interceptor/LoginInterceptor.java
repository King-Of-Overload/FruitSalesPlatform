package alan.zjut.fruitsalesplatform.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String uri=request.getRequestURI();
		//判断是否为登录注册地址
		if(!(uri.contains("Login")||uri.contains("login")||uri.contains("register"))) {
			//非登录
			if(request.getSession().getAttribute("user")!=null) {
				return true;//已经登陆过
			}else {
				if(uri.contains("css")||uri.contains("js")||uri.contains("images")) {
					return true;//静态资源放行
				}else {
					//没有登录
					response.sendRedirect(request.getContextPath()+"/user/toLogin.action");
				}
			}
		}else {return true;}
		return false;
	}

}
