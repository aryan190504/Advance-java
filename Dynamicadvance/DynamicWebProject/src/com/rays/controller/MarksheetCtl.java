package com.rays.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.bean.UserBean;
import com.rays.model.MarksheetModel;
import com.rays.model.UserModel;

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		String id = request.getParameter("id");

		if (id != null) {

			try {
				bean = model.findById(Integer.parseInt(id));
				request.setAttribute("bean", bean);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher("marksheetView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();

		String name = request.getParameter("name");
		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
		int physics = Integer.parseInt(request.getParameter("physics"));
		int chemistry = Integer.parseInt(request.getParameter("chemistry"));
		int maths = Integer.parseInt(request.getParameter("maths"));
try {
	
 
		bean.setName(name);
		bean.setRollNo(rollNo);
		bean.setPhysics(physics);
		bean.setChemistry(chemistry);
		bean.setMaths(maths);
		
		
		String op = request.getParameter("operation");

		if (op.equals("add")) {
			model.add(bean);
			request.setAttribute("smsg", "user inserted successfullyy.....");

		} else if (op.equals("update")) {
			bean.setId(Integer.parseInt(request.getParameter("id")));
			model.update(bean);
			request.setAttribute("smsg", "user updated successfully....");

		}
}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		RequestDispatcher rd = request.getRequestDispatcher ("MarksheetView.jsp");
	}






	}
