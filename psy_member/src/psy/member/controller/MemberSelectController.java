package psy.member.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import psy.member.control.Controller;
import psy.member.dao.MemberDAO;
import psy.member.dto.MemberDTO;
import psy.member.handler.HandlerAdapter;

public class MemberSelectController implements Controller {
	private static final Log log = LogFactory.getLog(MemberSelectController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO memberDAO = new MemberDAO();

		ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
		arrayList = memberDAO.memberSelect();
		log.info(arrayList);

		request.setAttribute("arrayList", arrayList);
		HandlerAdapter handlerAdapter = new HandlerAdapter();
		log.info("회원 전체 조회 controller: " + handlerAdapter);

		handlerAdapter.setPath("/WEB-INF/view/member/member_select_view.jsp");
		return handlerAdapter;
	}

}
