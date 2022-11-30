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

public class DeptInsertController implements Controller {
	private static Log log = LogFactory.getLog(DeptInsertController.class);

	@Override
	public DeptHandlerAdapter execute(HttpServletResponse response, HttpServletRequest request) {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		log.info(deptno);
		String dname = request.getParameter("dname");
		log.info(dname);
		String loc = request.getParameter("loc");
		log.info(loc);

		DeptDAO deptDAO = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();

		arrayList = deptDAO.deptSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);

		deptDTO.setDeptno(deptno);
		deptDTO.setDname(dname);
		deptDTO.setLoc(loc);

		deptDTO = deptDAO.deptInsert(deptDTO);
		log.info(deptDTO);
		request.setAttribute("deptDTO", deptDTO);
		log.info("부서 정보 등록");
		DeptHandlerAdapter deptHandlerAdapter = new DeptHandlerAdapter();

		deptHandlerAdapter.setPath("/WEB-INF/dept/dept_insert_view.jsp");

		return deptHandlerAdapter;
	}

}
