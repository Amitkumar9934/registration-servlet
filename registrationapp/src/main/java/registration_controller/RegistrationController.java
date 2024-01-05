package registration_controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import registration_model.DAOServiceImpl;


@WebServlet("/allReg")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!= null) {
				
				DAOServiceImpl service = new DAOServiceImpl();
				service.connectDB();
				ResultSet res = service.readAllReg();
				
				request.setAttribute("res", res);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/list_registration.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("msg", "Session Expired!!Login Again");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("msg", "Session Expired!!Login Again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
