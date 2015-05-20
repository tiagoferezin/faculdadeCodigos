package br.com.cuml.testes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuml.bean.Employees;
import br.com.cuml.dao.EmployeesDao;

/**
 * Servlet implementation class TesteEmployeesGetPorId
 */
@WebServlet("/TesteEmployeesGetPorId")
public class TesteEmployeesGetPorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteEmployeesGetPorId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idRecuperar = request.getParameter("id");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Recuperando objeto por ID</title>");
		out.println("</head>");
		out.println("<body>");
		
		// Se não for nulo o parametro da requisição e não estiver vazio [FB]
		if ((idRecuperar != null) && (!idRecuperar.trim().isEmpty())) {
			out.println("<h1>Recuperando o objeto:</h1>");
			out.println("<h2>ID: "+idRecuperar+"</h2>");
			out.println("<br><br>");
			
			try {
				EmployeesDao dao = new EmployeesDao();
				
				Object obj = dao.getPorId(idRecuperar);
				
				if ((obj!=null)&&(obj instanceof Employees)&&(obj.toString()!="")) {
					out.println("<p>Objeto recuperado com sucesso:</p>");
					out.println( ((Employees)obj).toString() );
				} else {
					out.println("<p>Objeto não encontrado com o ID informado.</p>");
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				out.println("<p>ERRO: " + e.getMessage() + "</p>");
				
			}
			
		} else {
			out.println("<h1>Nenhum identificador foi informado.</h1>");
		}
		
		
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
