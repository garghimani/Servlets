package assign.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assign.dbaccess.EMailAddressVOO;
import assign.dbaccess.EMailBO;
import assign.dbaccess.EMailValidationException;

/*
 * Get Email Address Servlet 
 */
@WebServlet("/byallcontacts")
public class GetAllEMailListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
	String errors = "";
        response.setContentType("text/html");

	EMailBO eMailBO = new EMailBO();
	EMailAddressVOO[] eMailList = null;

	try{
		ArrayList list = eMailBO.getAllEMailAddressList();
		Object[] aList = list.toArray(new EMailAddressVOO[list.size()]);
		eMailList = new EMailAddressVOO[list.size()];		
		for (int i = 0;i < aList.length;i++) {			
			eMailList[i] = (EMailAddressVOO) aList[i];
			System.out.println(eMailList[i].geteMailID());
		}
	}catch (EMailValidationException emve){
		errors = emve.getErrorMessage();
	} 
	catch (Exception e){
		e.printStackTrace();
	}
	if (errors.equals("")){
request.getSession().setAttribute("emaillist", eMailList);
	//	request.setAttribute("emaillist", eMailList);
		response.sendRedirect("/mysite/viewallcontact.jsp");	

	}
	else {
		request.getSession().setAttribute("Errors", errors);
		response.sendRedirect("/mysite/error.jsp");
	}
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }

}

