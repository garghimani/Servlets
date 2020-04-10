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

@WebServlet("/updatepersonaldetail")
public class UpdatePersonalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PersonalInfoVOO personInfo = new PersonalInfoVOO();
		
		
		HttpSession session = request.getSession();
		String firstName = (String)session.getAttribute("firstName");
		String lastName = request.getParameter("lastname");
		System.out.println("Inside servlet : "+firstName);
		
		personInfo.setFirstName(firstName);
		personInfo.setLastName(lastName);
		session.setAttribute("firstName", firstName);
		
		PersonalInfoBO personalBO = new PersonalInfoBO();
		String errors = "";
		
		try {
			System.out.println("Assign Values in Servlet");
			personalBO.modifyPersonalInfo(firstName, lastName);
			personInfo = personalBO.viewPersonalInfo(firstName);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			System.out.println("Errors are null."+personInfo.getFirstName());
			//request.getSession().setAttribute("pinfoVO", personInfo);
		//	response.sendRedirect("/myaccount/viewpersonaldetailssuccess.jsp");
			request.setAttribute("pinfoVO", personInfo);
			RequestDispatcher rd = request.getRequestDispatcher("/viewpersonaldetailssuccess.jsp");
			rd.forward(request, response);
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/modifypersonaldetails.jsp");
		}

	}

}
