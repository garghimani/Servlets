package account.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.dbaccess.AccountValidationException;
import account.dbaccess.BankInfoBO;
import account.dbaccess.BankInfoVOO;

@WebServlet("/bi3")
public class AddBankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BankInfoVOO bankInfo = new BankInfoVOO();
		HttpSession session = request.getSession();
		
		String firstName = (String)session.getAttribute("firstName");
		bankInfo.setBankName(request.getParameter("bankname"));
		bankInfo.setAccountNumber(request.getParameter("accountnumber"));
		bankInfo.setSsn(request.getParameter("ssn"));
		bankInfo.setPersonId(firstName);

		BankInfoBO bankBO = new BankInfoBO();
		String errors = "";

		try {
			bankBO.addBankInfo(bankInfo);
			session.setAttribute("firstName", firstName);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			request.getSession().setAttribute("addbinfo", bankInfo);
			response.sendRedirect("/myaccount/addaccountsuccess.jsp");
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/bankinfo3.jsp");
		}

	}

}
