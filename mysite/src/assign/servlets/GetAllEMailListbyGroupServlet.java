package assign.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get All Email Addresses by Group Servlet 
 */
@WebServlet("/bygroup")
public class GetAllEMailListbyGroupServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String errors = "";
		String emailAddress = request.getParameter("emailaddress");
		System.out.println("IN Servlet : " + emailAddress);
		response.setContentType("text/html");

		EMailBO eMailBO = new EMailBO();
		EMailAddressVOO[] eMailList = null;

		try {
			System.out.println("Inside ");
			ArrayList list = eMailBO.getAllEMailAddressListbyGroup(emailAddress);
			Object[] aList = list.toArray(new EMailAddressVOO[list.size()]);
			eMailList = new EMailAddressVOO[list.size()];
			System.out.println("Inside try block");
			for (int i = 0;i < aList.length;i++) {
				System.out.println("Inside for loop");
				eMailList[i] = (EMailAddressVOO) aList[i];
				System.out.println(eMailList[i].geteMailID());
			}

		} catch (EMailValidationException emve) {
			errors = emve.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (errors.equals("")) {
				request.getSession().setAttribute("emaillist1", eMailList);	
				//response.sendRedirect("/mysite/viewbygroupsuccess.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/viewbygroupsuccess.jsp");
			rd.forward(request, response);
		} else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/mysite/error.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}

}
