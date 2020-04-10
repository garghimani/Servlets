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
import account.dbaccess.BankInfoBO;
import account.dbaccess.BankInfoVOO;

@WebServlet("/updatebankdetail")
public class UpdateBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BankInfoVOO bankInfo = new BankInfoVOO();
		
		
		HttpSession session = request.getSession();
		String firstName = (String)session.getAttribute("firstName");
		String bankName = request.getParameter("bankName");
		System.out.println("Inside servlet : "+bankName);
		
		bankInfo.setPersonId(firstName);
		bankInfo.setBankName(bankName);
		session.setAttribute("firstName", firstName);
		
		BankInfoBO bankBO = new BankInfoBO();
		String errors = "";
		
		try {
			System.out.println("Assign Values in Servlet");
			bankBO.modifyBankInfo(firstName, bankName);
			bankInfo = bankBO.viewBankInfo(firstName);
		}
		catch(AccountValidationException accExcMsg) {
			errors = accExcMsg.getErrorMessage();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(errors.equals("")) {
			System.out.println("Errors are null."+bankInfo.getPersonId());
			//request.getSession().setAttribute("pinfoVO", personInfo);
		//	response.sendRedirect("/myaccount/viewpersonaldetailssuccess.jsp");
			request.setAttribute("binfoVO", bankInfo);
			RequestDispatcher rd = request.getRequestDispatcher("/viewbankdetailssuccess.jsp");
			rd.forward(request, response);
		}
		else {
			request.getSession().setAttribute("errMsg", errors);
			response.sendRedirect("/myaccount/updatebank.jsp");
		}

	}

}
