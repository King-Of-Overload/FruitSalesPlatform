package alan.zjut.fruitsalesplatform.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {
	
	/**
	 * 日期的转换，若转换格式错误会报400
	 * @param binder
	 */
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		 DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		 dateFormat.setLenient(true);
		 binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	 }
}
