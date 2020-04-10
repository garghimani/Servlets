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
import account.dbaccess.PersonalInfoBO;

@WebServlet("/updatecontactdetail")
public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContactInfoVOO contactInfo = new ContactInfoVOO();
		
		
		HttpSession session = request.getSession();
		String firstName = (String)session.getAttribute("firstName");
		String address = request.getParameter("address");
		System.out.println("Inside servlet : "+firstName);
		
		contactInfo.setPersonID(firstName);
		contactInfo.setAddress(address);
		session.setAttribute("firstName", firstName);
		
		ContactInfoBO contactBO = new ContactInfoBO();
		String errors = "";
		
		try {
			System.out.println("Assign Values in Servlet");
			contactBO.modifyContactInfo(firstName, address);
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
			response.sendRedirect("/myaccount/updatecontact.jsp");
		}

	}

}
