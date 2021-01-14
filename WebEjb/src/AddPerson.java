

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PersonBean;



@WebServlet(urlPatterns="/AddPerson")
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB PersonBean bean;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("txtbox");
		bean.addPerson(name);
		out.println("Name: "+name);
	}

}
