package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Telefone;
import model.Usuario;

public class MenuUsuarioTelefoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;

	public void init() {
		usuarioDAO = new UsuarioDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action + " - Servlet usuario");
		try {
			switch (action) {
			case "/insert":
				insertUsuario(request, response);
				break;
			case "/delete":
				deleteUsuario(request, response);
				break;
			case "/update":
				updateUsuario(request, response);
				break;
			case "/insertTelefone":
				insertTelefone(request, response);
				break;
			case "/deleteTelefone":
				deleteTelefone(request, response);
				break;
			case "/updateTelefone":
				updateTelefone(request, response);
				break;
			case "/telefones":
				telefones(request, response);
			default:
				usuarios(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void usuarios(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Usuario> usuarios = usuarioDAO.selectAll();
		request.setAttribute("usuarios", usuarios);
		System.out.println(usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("menuUsuario.jsp");
		dispatcher.forward(request, response);
	}

	private void insertUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario(nome, email, senha);
		usuarioDAO.insert(usuario);
		response.sendRedirect("MenuUsuarioTelefoneServlet");
	}

	private void updateUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		Usuario usuario = new Usuario(id, nome, email, senha);
		usuarioDAO.update(usuario, id);
		response.sendRedirect("MenuUsuarioTelefoneServlet");
	}

	private void deleteUsuario(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		usuarioDAO.deleteTelefoneByIdUsuario(id);
		usuarioDAO.delete(id);
		response.sendRedirect("MenuUsuarioTelefoneServlet");
	}

	private void telefones(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Long id = Long.parseLong(request.getParameter("id"));
		List<Telefone> telefones = usuarioDAO.selectByIdUsuario(id);
		request.setAttribute("telefones", telefones);
		request.setAttribute("id", id);
		System.out.println(telefones);
		RequestDispatcher dispatcher = request.getRequestDispatcher("menuTelefone.jsp");
		dispatcher.forward(request, response);
	}

	private void insertTelefone(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Long id = Long.parseLong(request.getParameter("id"));
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		Telefone telefone = new Telefone(ddd, numero, tipo, id);
		usuarioDAO.insertTelefone(telefone);
		response.sendRedirect("MenuUsuarioTelefoneServlet");
	}

	private void updateTelefone(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Long id = Long.parseLong(request.getParameter("id"));
		int ddd = Integer.parseInt(request.getParameter("ddd"));
		String numero = request.getParameter("numero");
		String tipo = request.getParameter("tipo");
		Telefone telefone = new Telefone(id, ddd, numero, tipo);
		usuarioDAO.updateTelefone(telefone, id);
		response.sendRedirect("MenuUsuarioTelefoneServlet");
	}

	private void deleteTelefone(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		Long id = Long.parseLong(request.getParameter("id"));
		usuarioDAO.deleteTelefone(id);
		response.sendRedirect("MenuUsuarioTelefoneServlet");
	}
}