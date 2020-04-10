package account.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.dbaccess.AccountValidationException;
import account.dbaccess.PersonalInfoBO;
import account.dbaccess.PersonalInfoVOO;

@WebServlet("/pi3")
public class AddPersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PersonalInfoVOO personInfo = new PersonalInfoVOO();
		String firstName = request.getParameter("firstname");
		
		personInfo.setFirstName(firstName);
		personInfo.setMiddleName(request.getParameter("middlename"));
		personInfo.setLastName(request.getParameter("lastname"));
		personInfo.setGender(request.getParameter("gender"));
		
		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);
		
		PersonalInfoBO personalBO = new PersonalInfoBO();
		String errors = "";
		
		try {
			personalBO.addPersonalInfo(personInfo);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			request.getSession().setAttribute("addpinfo", personInfo);
			response.sendRedirect("/myaccount/contactinfo3.jsp");
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/personalinfo3.jsp");
		}

	}

}
