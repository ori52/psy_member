package min.dept.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import min.dept.handler.DeptHandlerAdapter;

public interface Controller {
	public DeptHandlerAdapter execute(HttpServletResponse response, HttpServletRequest request);
}
