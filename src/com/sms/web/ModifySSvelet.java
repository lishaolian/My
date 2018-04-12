package com.sms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentInfoDao;
import com.sms.model.StudentInfo;

@WebServlet("/ModifyS.do")
public class ModifySSvelet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String ClassName = request.getParameter("ClassName");
			StudentInfoDao dao = new StudentInfoDao(request);
			StudentInfo c = new StudentInfo();
			c.setId(Long.parseLong(id));
			c.setName(name);
			c.setClassName(ClassName);
			dao.update(c);
			response.sendRedirect("/studentinfo/list.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}