package psy.member.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import psy.member.control.Controller;
import psy.member.controller.MemberDeleteController;
import psy.member.controller.MemberInsertController;
import psy.member.controller.MemberSelectController;
import psy.member.controller.MemberSelectdetailController;
import psy.member.controller.MemberUpdateController;
import psy.member.handler.HandlerAdapter;

public class MemberDispatcherServlet extends HttpServlet {
	private static Log log = LogFactory.getLog(MemberDispatcherServlet.class);
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
		String servletURI = request.getServletPath();
		log.info(servletURI);
		HandlerAdapter handlerAdapter = null;
		Controller controller = null;

//////////////////////////////////////////////////
		if (servletURI.equals("/MemberSelect.me")) {
			controller = new MemberSelectController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 전체 조회 확인 : " + handlerAdapter);

//////////////////////////////////////////////////
		} else if (servletURI.equals("/MemberSelectDetail.me")) {
			controller = new MemberSelectdetailController();
			handlerAdapter = controller.execute(request, response);
			log.info("상세 회원 조회 확인 : " + handlerAdapter);

//////////////////////////////////////////////////
		} else if (servletURI.equals("/MemberInsert.me")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/member/member_insert.jsp");
			log.info("회원 등록 화면 뷰 확인 : " + handlerAdapter);

		} else if (servletURI.equals("/MemberInsertView.me")) {
			controller = new MemberInsertController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 등록 확인 : " + handlerAdapter);

//////////////////////////////////////////////////
		} else if (servletURI.equals("/MemberUpdate.me")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/member/member_update.jsp");
			log.info("회원 업데이트 화면 뷰 확인 : " + handlerAdapter);

		} else if (servletURI.equals("/MemberUpdateView.me")) {
			controller = new MemberUpdateController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 업데이트 확인 : " + handlerAdapter);

//////////////////////////////////////////////////		
		} else if (servletURI.equals("/MemberDelete.me")) {
			handlerAdapter = new HandlerAdapter();
			handlerAdapter.setPath("/WEB-INF/view/member/member_delete.jsp");
			log.info("회원 삭제 화면 뷰 확인 : " + handlerAdapter);

		} else if (servletURI.equals("MemberDeleteView.me")) {
			controller = new MemberDeleteController();
			handlerAdapter = controller.execute(request, response);
			log.info("회원 업데이트 화면 뷰 확인 : " + handlerAdapter);
		}
//////////////////////////////////////////////////
		if (handlerAdapter != null) {
			if (handlerAdapter.isRedirect()) {
				response.sendRedirect(handlerAdapter.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(handlerAdapter.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
