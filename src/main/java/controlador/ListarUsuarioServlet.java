package controlador;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.UsuarioDBService;

/**
 * Servlet implementation class ListarUsuarioServlet
 */
public class ListarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsuarioDBService usu = new UsuarioDBService();
	
    public ListarUsuarioServlet() {
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
			request.setAttribute("user", usu.getUsuarioList());
			getServletContext().getRequestDispatcher("/view/ListarUsuario.jsp").forward(request, response);
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
