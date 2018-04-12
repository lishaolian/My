package com.sms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentInfoDao;

@WebServlet("/DeleteS.do")
public class DeleteSSvelet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if(!PermissionHelper.validPermission(request, response,"StudentDelete"))return;
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			StudentInfoDao dao = new StudentInfoDao(request);
			dao.delete(Long.parseLong(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/studentinfo/list.jsp");
	}

}
