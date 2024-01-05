package registration_controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import registration_model.DAOServiceImpl;


@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String email = request.getParameter("emailId");
           System.out.println(email);
           DAOServiceImpl service = new DAOServiceImpl();
           service.connectDB();
           service.deleteByEmail(email);
           //After deleting this code redirect to same page
           ResultSet res = service.readAllReg();
   		
   		   request.setAttribute("res", res);
   		   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
   		   rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
