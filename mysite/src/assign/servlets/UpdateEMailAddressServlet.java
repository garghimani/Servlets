package assign.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Update Phone Numbers for Email Address Servlet 
 * Updated by Himani
 */
@WebServlet("/updateemailaddress")

public class UpdateEMailAddressServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
	HttpSession session = request.getSession();
	String inEmailID = (String)session.getAttribute("emailaddress");
	String inWPhone = request.getParameter("wphone");
	String inMPhone = request.getParameter("mphone");
	System.out.println("Inside Update : "+inEmailID+"  "+inWPhone+"  "+inMPhone);
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	EMailAddressVOO eMailAddressVOO = null;

	try{
		System.out.println("test : "+eMailAddressVOO+"  "+inWPhone+"  "+inMPhone);
		eMailBO.updateEMailAddressPhone(inEmailID, inWPhone, inMPhone);
		eMailAddressVOO = eMailBO.getEMailAddress(inEmailID);
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
		System.out.println("first Name: " + eMailAddressVOO.getfName());
		request.setAttribute("emailVO", eMailAddressVOO);
		RequestDispatcher rd = request.getRequestDispatcher("/viewsuccess.jsp");
		rd.forward(request, response);
	}
	else {
		System.out.println(request.getRequestURI());
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/deletecontact.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

