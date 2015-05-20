package br.com.cuml.testes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cuml.dao.ConexaoFactory;

/**
 * Servlet implementation class TesteConexaoComBanco
 */
@WebServlet("/TesteConexaoBD")
public class TesteConexaoComBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TesteConexaoComBanco() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String msgRetorno = "";
		try {
			ConexaoFactory cf = new ConexaoFactory();
			Connection conexao = cf.getConexao();
			
			if (conexao!=null) {
				msgRetorno += "<br>Objeto de conexão retornado.";
			}
			
			if (!conexao.isClosed()) {
				msgRetorno += "<br>Conexão aberta.";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			msgRetorno = "ERRO: " + e.getMessage();
		}
		
		out.println("<html><head><title>Verificando conexão</title></head>");
		out.println("<body>");
		out.println("<h1>Resultado do teste:</h1>");
		out.println("<h2>"+msgRetorno+"</h2>");
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
