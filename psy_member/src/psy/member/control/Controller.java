package psy.member.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import psy.member.handler.HandlerAdapter;

public interface Controller {
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response);
}
