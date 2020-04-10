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
import account.dbaccess.ContactInfoBO;
import account.dbaccess.ContactInfoVOO;

@WebServlet("/viewcontactdetail")
public class ViewContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContactInfoVOO contactInfo = new ContactInfoVOO();
		String firstName = request.getParameter("firstname");
		System.out.println("Inside servlet : "+firstName);
		
		contactInfo.setPersonID(firstName);
		
		HttpSession session = request.getSession();
		session.setAttribute("firstName", firstName);
		
		ContactInfoBO contactBO = new ContactInfoBO();
		String errors = "";
		
		try {
			System.out.println("Assign Values in Servlet");
			contactInfo = contactBO.viewContactInfo(firstName);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			System.out.println("Errors are null."+contactInfo.getPersonID());
			//request.getSession().setAttribute("pinfoVO", personInfo);
		//	response.sendRedirect("/myaccount/viewpersonaldetailssuccess.jsp");
			request.setAttribute("cinfoVO", contactInfo);
			RequestDispatcher rd = request.getRequestDispatcher("/viewcontactdetailssuccess.jsp");
			rd.forward(request, response);
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/viewcontactdetails.jsp");
		}

	}

}
