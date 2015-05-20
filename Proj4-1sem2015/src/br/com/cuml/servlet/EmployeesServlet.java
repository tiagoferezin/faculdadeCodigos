package br.com.cuml.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.TryCatchFinally;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

import br.com.cuml.bean.Employees;
import br.com.cuml.dao.EmployeesDao;

/**
 * Servlet implementation class EmployeesServlet
 */
@WebServlet("/employees")
public class EmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String logica = request.getParameter("logica");
		request.setAttribute("logica", logica);
		if (logica != null) {
			if (logica.equals("novo")) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/jsp/employees/novo.jsp");
				rd.forward(request, response);
			} else if (logica.equals("editar")) {

				try {
					EmployeesDao dao = new EmployeesDao();
					String id = request.getParameter("id");

					Employees employee = (Employees) dao.getPorId(id);
					request.setAttribute("employee", employee);

				} catch (Exception e) {

					// TODO Auto-generated catch block

					e.printStackTrace();
				}

				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/jsp/employees/editar.jsp");
				rd.forward(request, response);
			} else {
				String msgErro = "";
				try {
					EmployeesDao dao = new EmployeesDao();
					List<Object> lista = dao.listar();
					request.setAttribute("lista", lista);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					msgErro = e.getMessage();
					request.setAttribute("msgErro", msgErro);

				}
				RequestDispatcher rd = request
						.getRequestDispatcher("/WEB-INF/jsp/employees/listar.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String msg = "Empregado gravado.";
		try {
			Employees empregado = new Employees();
			empregado.setFirstName(request.getParameter("firstName"));
			empregado.setLastName(request.getParameter("lastName"));
			empregado.setEmail(request.getParameter("email"));
			empregado.setJobId(request.getParameter("jobId"));

			// A data informada pelo usuário que é texto
			String textoHireDate = request.getParameter("hireDate");

			// Definindo o formato da data para conversão
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			// Criando um objeto, convertendo,
			// o texto para data
			Date hireDate = sdf.parse(textoHireDate);

			// Criando, instanciando, um objeto Calendar
			Calendar calHireDate = Calendar.getInstance();

			// Atribuindo (setando) a data para o objeto
			// Calendar
			calHireDate.setTime(hireDate);

			// Atribuindo (setando) o objeto Calendar
			// no objeto empregado que será
			// persistido (gravado)
			empregado.setHireDate(calHireDate);

			try {
				// tentando converter o parametro de salario da requisição [FB]
				String txtSalario = request.getParameter("salary");
				empregado.setSalary(Double.parseDouble(txtSalario));

			} catch (Exception e) {
				// caso não consiga converter seta com 0 do tipo Double (0d)
				// [FB]
				empregado.setSalary(0d);
			}

			try {
				// tentando converter o parametro de comissão da requisição [FB]
				String txtCommission = request.getParameter("commissionPct");
				empregado.setCommissionPct(Double.parseDouble(txtCommission));

			} catch (Exception e) {
				// caso não consiga converter seta com 0 do tipo Double (0d)
				// [FB]
				empregado.setCommissionPct(0d);
			}

			try {
				// tentando converter o parametro de comissão da requisição [FB]
				String txtManagerId = request.getParameter("managerId");
				empregado.setManagerId(Integer.parseInt(txtManagerId));

			} catch (Exception e) {
				// caso não consiga converter seta com 0 do tipo Double (0d)
				// [FB]
				empregado.setManagerId(null);
			}

			try {
				// tentando converter o parametro de comissão da requisição [FB]
				String txtDepartmentId = request.getParameter("departmentId");
				empregado.setDepartmentId(Integer.parseInt(txtDepartmentId));

			} catch (Exception e) {
				// caso não consiga converter seta com 0 do tipo Double (0d)
				// [FB]
				// empregado.setDepartmentId(null);
				throw new Exception("Informe o departamento.");
			}
			EmployeesDao dao = new EmployeesDao();
			dao.inserir(empregado);

		} catch (Exception e) {
			// TODO: handle exception
			msg = e.getMessage();
			System.out.println(e.getMessage());
			e.printStackTrace();

			if (msg == null) {
				msg = "Objeto nulo";
			}
		}
		request.setAttribute("msg", msg);

		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/jsp/employees/gravar.jsp");
		rd.forward(request, response);
	}
}
