package com.sms.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sms.dao.ClassInfoDao;
import com.sms.model.ClassInfo;

@WebServlet("/Modify.do")
public class ModifySevlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
//			String p = name;
//			//对中文参数编码
//			p = URLEncoder.encode(p, "UTF-8");
			ClassInfoDao dao = new ClassInfoDao(request);
			ClassInfo c = new ClassInfo();
			c.setId(Long.parseLong(id));
			c.setName(name);
			dao.update(c);
			response.sendRedirect("/classinfo/list.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
