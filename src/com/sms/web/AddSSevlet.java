package com.sms.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.StudentInfoDao;
import com.sms.model.StudentInfo;

	@WebServlet("/AddS.do")
	public class AddSSevlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			try {
				if(!PermissionHelper.validPermission(request, response,"StudentAdd"))return;
				request.setCharacterEncoding("utf-8");
				String submit = request.getParameter("submit");
				if(submit==null) return;
				String name = request.getParameter("stuname");
				String ClassName = request.getParameter("ClassName");
				StudentInfoDao dao = new StudentInfoDao(request);
				StudentInfo c = new StudentInfo();
				c.setName(name);
				c.setClassName(ClassName);
				dao.add(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("/studentinfo/list.jsp");
		}
		
		

	}