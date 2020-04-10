package account.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.dbaccess.AccountValidationException;
import account.dbaccess.PersonalInfoBO;
import account.dbaccess.PersonalInfoVOO;

@WebServlet("/deletepersonaldetail")
public class DeletePersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PersonalInfoVOO personInfo = new PersonalInfoVOO();
		String firstName = request.getParameter("firstname");
		System.out.println("Inside servlet : "+firstName);
		
		personInfo.setFirstName(firstName);
		
		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);
		
		PersonalInfoBO personalBO = new PersonalInfoBO();
		String errors = "";
		
		try {
			System.out.println("Assign Values in Servlet");
			personalBO.deletePersonalInfo(firstName);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			System.out.println("Errors are null."+personInfo.getFirstName());
			request.getSession().setAttribute("deletepinfo", personInfo);
			response.sendRedirect("/myaccount/deletesuccess.jsp");
			//request.setAttribute("pinfoVO", personInfo);
			//RequestDispatcher rd = request.getRequestDispatcher("/updatepersonal.jsp");
			//rd.forward(request, response);
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/deletepersonaldetails.jsp");
		}

	}

}
