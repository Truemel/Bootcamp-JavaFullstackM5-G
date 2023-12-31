package controlador;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.CapacitacionDBService;

/**
 * Servlet implementation class ListarCapacitacionServlet
 */
public class ListarCapacitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CapacitacionDBService cap = new CapacitacionDBService();
	
    public ListarCapacitacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(Boolean.parseBoolean(session.getAttribute("logged")+"")) {
			request.setAttribute("capac", cap.getCapacitacionList());
			getServletContext().getRequestDispatcher("/view/ListarCapacitacion.jsp").forward(request, response);
		}else
			response.sendRedirect(getServletContext().getContextPath()+"/LoginServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
