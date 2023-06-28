package controlador;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Capacitacion;
import services.CapacitacionDBService;

/**
 * Servlet implementation class S3
 */
public class CrearCapacitacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CapacitacionDBService cap = new CapacitacionDBService();
	
    public CrearCapacitacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(Boolean.parseBoolean(session.getAttribute("logged")+""))
			getServletContext().getRequestDispatcher("/view/CrearCapacitacion.jsp").forward(request, response);
		else
			response.sendRedirect(getServletContext().getContextPath()+"/LoginServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Capacitacion capac = new Capacitacion();
		capac.setNombre(request.getParameter("nombre"));
		capac.setDetalle(request.getParameter("detalle"));
		cap.addCapacitacion(capac);
		response.sendRedirect(getServletContext().getContextPath()+"/CrearCapacitacionServlet");
	}

}
