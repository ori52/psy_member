package min.dept.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import min.dept.control.Controller;
import min.dept.dao.DeptDAO;
import min.dept.dto.DeptDTO;
import min.dept.handler.DeptHandlerAdapter;

public class DeptSelectController implements Controller {
	private static Log log = LogFactory.getLog(DeptSelectController.class);

	@Override
	public DeptHandlerAdapter execute(HttpServletResponse response, HttpServletRequest request) {
		DeptDAO deptDAO = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		log.info(deptDTO);

		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();
		arrayList = deptDAO.deptSelectAll();
		log.info(arrayList);

		request.setAttribute("arrayList", arrayList);
		DeptHandlerAdapter deptHandlerAdapter = new DeptHandlerAdapter();
		log.info("부서 정보 조회");

		deptHandlerAdapter.setPath("/WEB-INF/dept/dept_select_view.jsp");
		return deptHandlerAdapter;
	}

}
