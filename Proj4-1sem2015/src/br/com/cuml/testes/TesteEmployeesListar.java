package br.com.cuml.testes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuml.bean.Employees;
import br.com.cuml.dao.EmployeesDao;

/**
 * Servlet implementation class TesteEmployeesListar
 */
@WebServlet("/TesteEmployeesListar")
public class TesteEmployeesListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TesteEmployeesListar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Lista de objetos</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");

		try {
			EmployeesDao dao = new EmployeesDao();

			List<Object> lista = dao.listar();

			for (Object obj : lista) {
				out.println("<li>");
				out.println(obj.toString());
				out.println("</li>");
			}

		} catch (Exception e) {
			// TODO: handle exception
			out.println("<p>ERRO: " + e.getMessage() + "</p>");

		}

		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
