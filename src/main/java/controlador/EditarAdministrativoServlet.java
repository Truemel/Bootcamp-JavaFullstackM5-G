package controlador;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import services.UsuarioDBService;

/**
 * Servlet implementation class EditarAdministrativoServlet
 */
public class EditarAdministrativoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public UsuarioDBService usu = new UsuarioDBService();
	private Usuario user;
	
    public EditarAdministrativoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("admin", user = usu.getUsuarioById(Integer.parseInt(request.getParameter("id"))));
		getServletContext().getRequestDispatcher("/view/EditarAdministrativo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user.setNombre(request.getParameter("nombre"));
		usu.updateUsuario(user);
		response.sendRedirect(getServletContext().getContextPath()+"/ListarUsuarioServlet");
	}

}
