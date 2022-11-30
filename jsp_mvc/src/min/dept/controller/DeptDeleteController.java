package min.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import min.dept.control.Controller;
import min.dept.dao.DeptDAO;
import min.dept.dto.DeptDTO;
import min.dept.handler.DeptHandlerAdapter;

public class DeptDeleteController implements Controller {
	private static Log log = LogFactory.getLog(DeptDeleteController.class);

	@Override
	public DeptHandlerAdapter execute(HttpServletResponse response, HttpServletRequest request) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		log.info(deptno);

		DeptDAO deptDao = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();

		deptDTO.setDeptno(deptno);
		request.setAttribute("deptDTO", deptDTO);
		deptDTO = deptDao.deptDelete(deptno);
		log.info(deptDTO);

		DeptHandlerAdapter deptHandlerAdapter = new DeptHandlerAdapter();
		deptHandlerAdapter.setPath("/WEB-INF/dept/dept_delete_view.jsp");

		return deptHandlerAdapter;
	}

}
