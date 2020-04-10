package account.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.dbaccess.AccountValidationException;
import account.dbaccess.ContactInfoBO;
import account.dbaccess.ContactInfoVOO;

@WebServlet("/cs3")
public class AddContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContactInfoVOO contactInfo = new ContactInfoVOO();
		HttpSession session = request.getSession();
		String firstName = (String)session.getAttribute("firstName");
		contactInfo.setAddress(request.getParameter("address"));
		contactInfo.setCity(request.getParameter("city"));
		contactInfo.setState(request.getParameter("state"));
		contactInfo.setCountry(request.getParameter("country"));
		contactInfo.setPhone(request.getParameter("phone"));
		contactInfo.setPersonID(firstName);

		ContactInfoBO contactBO = new ContactInfoBO();
		String errors = "";

		try {
			contactBO.addContactInfo(contactInfo);
			session.setAttribute("firstName", firstName);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			request.getSession().setAttribute("addcinfo", contactInfo);
			response.sendRedirect("/myaccount/bankinfo3.jsp");
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/contactinfo3.jsp");
		}

	}

}
