package com.sms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.model.ClassInfo;
import com.sms.dao.ClassInfoDao;

@WebServlet("/Add.do")
public class AddSevlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(!PermissionHelper.validPermission(request, response, "ClassAdd")) return;
		request.setCharacterEncoding("utf-8");
		response.getWriter().write("添加成功");
		String submit = request.getParameter("submit");
		if(submit==null) return;
		String name = request.getParameter("name");
		ClassInfoDao dao = new ClassInfoDao(request);
		ClassInfo c = new ClassInfo();
		c.setName(name);
		try {
			dao.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/classinfo/list.jsp");
	}
	
	

}
