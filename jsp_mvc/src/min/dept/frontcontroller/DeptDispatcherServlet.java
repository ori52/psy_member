package min.dept.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import min.dept.control.Controller;
import min.dept.controller.DeptDeleteController;
import min.dept.controller.DeptInsertController;
import min.dept.controller.DeptSelectController;
import min.dept.controller.DeptSelectDetailController;
import min.dept.controller.DeptUpdateController;
import min.dept.controller.DeptUpdateViewController;
import min.dept.handler.DeptHandlerAdapter;

public class DeptDispatcherServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(DeptDispatcherServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		service(request, response);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		// http://localhost/컨텍스트명/매핑명으로 반환
		log.info("requestURI 확인 : " + requestURI);

		String contextPath = request.getContextPath();
		// URL에서 슬래시 를 첨부한 컨텍스트 이름인 컨텍스트명 매핑명을 반환한다
		log.info("contextPath 확인 : " + contextPath);

		String pathURL = requestURI.substring(contextPath.length());
		log.info("Dispatcher Servlet 매핑명 조회 : " + pathURL);

		DeptHandlerAdapter deptHandlerAdapter = null;
		// 객체를 처리하여 모델과 뷰에 반환
		Controller controller = null;
		// 서블릿 메소드를 규격화

		if (pathURL.equals("/DeptSelect.do")) {
			controller = new DeptSelectController();
			deptHandlerAdapter = controller.execute(response, request);
			log.info("부서 조회 확인 : " + deptHandlerAdapter);
////////////////////////////////////////////////////////////////////
		} else if (pathURL.equals("/DeptSelectDetail.do")) {
			controller = new DeptSelectDetailController();
			deptHandlerAdapter = controller.execute(response, request);
			log.info("상세 부서 조회 확인 : " + deptHandlerAdapter);
////////////////////////////////////////////////////////////////////
		} else if (pathURL.equals("/DeptInsert.do")) {
			deptHandlerAdapter = new DeptHandlerAdapter();
			// 객체를 처리하여 모델과 뷰에 반환
			deptHandlerAdapter.setPath("/WEB-INF/dept/dept_insert.jsp");
			// 포워드로 파라미터를 전송
			log.info("부서 등록 화면 뷰 확인 : " + deptHandlerAdapter);

		} else if (pathURL.equals("/DeptInsertView.do")) {
			controller = new DeptInsertController();
			deptHandlerAdapter = controller.execute(response, request);
			log.info("부서 등록 확인 : " + deptHandlerAdapter);
////////////////////////////////////////////////////////////////////
		} else if (pathURL.equals("/DeptUpdate.do")) {
			controller = new DeptUpdateController();
			// p.628 얘는 왜 파라미터를 전송하지도 않음?
			deptHandlerAdapter = controller.execute(response, request);
			log.info("부서 수정 화면 뷰 확인 : " + deptHandlerAdapter);

		} else if (pathURL.equals("/DeptUpdateView.do")) {
			controller = new DeptUpdateViewController();
			deptHandlerAdapter = controller.execute(response, request);
			log.info("부서 수정 확인 : " + deptHandlerAdapter);
////////////////////////////////////////////////////////////////////
		} else if (pathURL.equals("/DeptDelete.do")) {
			deptHandlerAdapter = new DeptHandlerAdapter();
			deptHandlerAdapter.setPath("/WEB-INF/dept/dept_delete.jsp");
			log.info("부서 삭제 화면 뷰 확인 : " + deptHandlerAdapter);

		} else if (pathURL.equals("/DeptDeleteView.do")) {
			controller = new DeptDeleteController();
			deptHandlerAdapter = controller.execute(response, request);
			log.info("부서 삭제 확인 :" + deptHandlerAdapter);
		}
////////////////////////////////////////////////////////////////////
		if (deptHandlerAdapter != null) {
			if (deptHandlerAdapter.isRedirect()) {
				response.sendRedirect(deptHandlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(deptHandlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
