package account.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import account.dbaccess.AccountBO;
import account.dbaccess.AccountVOO;
import account.dbaccess.AccountValidationException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AccountVOO accVOO = new AccountVOO();

		accVOO.setUserName(request.getParameter("uname"));
		accVOO.setPasswd(request.getParameter("passwd"));
		
		System.out.println("Inside Login Servlet : "+accVOO.getUserName()+"  "+accVOO.getPasswd());
		
		AccountBO accBO = new AccountBO();
		String errors = "";
		
		try {
			accBO.getLoginDetails(accVOO);
			accBO.addLoginDetails(accVOO);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			response.sendRedirect("/myaccount/home.jsp");
		}
		else {
			request.getSession().setAttribute("Errors", errors);
			response.sendRedirect("/myaccount/login.jsp");
		}

	}

}
