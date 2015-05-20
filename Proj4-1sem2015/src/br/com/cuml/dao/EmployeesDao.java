package br.com.cuml.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.cuml.bean.Employees;

public class EmployeesDao implements ICrud {
	private Connection conexao;

	public EmployeesDao() throws SQLException {
		ConexaoFactory cf = new ConexaoFactory();
		conexao = cf.getConexao();
	}

	@Override
	public Object getPorId(Object id) throws Exception {
		// Instanciando, criando um objeto, chamado "retorno"
		// que é do tipo "Employees"
		Employees retorno = new Employees();
		String sql = "SELECT * FROM HR.EMPLOYEES";
		sql += " WHERE EMPLOYEE_ID = ?";

		Integer employeeId = 0;

		// Verificando se o objeto "id" é do tipo "String" 
		if (id instanceof String) {
			// Se o objeto é String convertê-lo para Integer
			employeeId = Integer.parseInt((String) id);
		} else if (id instanceof Integer) {
			// Verificando se o objeto "id" é do tipo "Integer"
			// 
			employeeId = (Integer)id;
		}

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, employeeId);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			retorno.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
			retorno.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			retorno.setEmail(rs.getString("EMAIL"));
			retorno.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			retorno.setFirstName(rs.getString("FIRST_NAME"));

			Calendar hireDate = Calendar.getInstance();
			hireDate.setTimeInMillis(rs.getTimestamp("HIRE_DATE").getTime());
			retorno.setHireDate(hireDate);

			retorno.setJobId(rs.getString("JOB_ID"));
			retorno.setLastName(rs.getString("LAST_NAME"));
			retorno.setManagerId(rs.getInt("MANAGER_ID"));
			retorno.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			retorno.setSalary(rs.getDouble("SALARY"));

		}
		rs.close();
		stmt.close();
		return retorno;
	}

	@Override
	public List<Object> listar() throws Exception {
		// TODO Auto-generated method stub
		List<Object> retorno = new ArrayList<Object>();
		String sql = "SELECT * FROM HR.EMPLOYEES";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Employees employees = new Employees();
			employees.setCommissionPct(rs.getDouble("COMMISSION_PCT"));
			employees.setDepartmentId(rs.getInt("DEPARTMENT_ID"));
			employees.setEmail(rs.getString("EMAIL"));
			employees.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			employees.setFirstName(rs.getString("FIRST_NAME"));

			Calendar hireDate = Calendar.getInstance();
			hireDate.setTimeInMillis(rs.getTimestamp("HIRE_DATE").getTime());
			employees.setHireDate(hireDate);

			employees.setJobId(rs.getString("JOB_ID"));
			employees.setLastName(rs.getString("LAST_NAME"));
			employees.setManagerId(rs.getInt("MANAGER_ID"));
			employees.setPhoneNumber(rs.getString("PHONE_NUMBER"));
			employees.setSalary(rs.getDouble("SALARY"));

			retorno.add(employees);
		}

		rs.close();
		stmt.close();

		return retorno;
	}

	@Override
	public Integer inserir(Object objetoPersistir) throws Exception {
		Integer retorno = 0;
		Employees employees = (Employees) objetoPersistir;

		String sql = "INSERT INTO HR.EMPLOYEES ("
				+ "COMMISSION_PCT, DEPARTMENT_ID, EMAIL, "
				+ "FIRST_NAME, HIRE_DATE, "
				+ "JOB_ID, LAST_NAME, MANAGER_ID, "
				+ "PHONE_NUMBER, SALARY) VALUES ( "
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, employees.getCommissionPct());
		stmt.setInt(2, employees.getDepartmentId());
		stmt.setString(3, employees.getEmail());
		
		stmt.setString(4, employees.getFirstName());
		stmt.setTimestamp(5, (new Timestamp(employees.getHireDate()
				.getTimeInMillis())));
		stmt.setString(6, employees.getJobId());
		stmt.setString(7, employees.getLastName());

		// verificando se existe gerente (managerId) [FB]
		if (employees.getManagerId()!=null) {
			// não é nulo, seta o valor [FB]
			stmt.setInt(8, employees.getManagerId());
		} else {
			// é nulo, seta o parametro do SQL com nulo [FB]
			stmt.setNull(8, java.sql.Types.INTEGER);
		}
		
		stmt.setString(9, employees.getPhoneNumber());
		stmt.setDouble(10, employees.getSalary());
		retorno = stmt.executeUpdate();
		return retorno;
	}

	@Override
	public Integer alterar(Object objetoPersistir) throws Exception {
		Integer retorno = 0;

		Employees employees = (Employees) objetoPersistir;
		String sql = "UPDATE HR.EMPLOYEES SET"
				+ "COMMISSION_PCT = ?, DEPARTMENT_ID= ?, EMAIL= ?, "
				+ " FIRST_NAME= ?, HIRE_DATE= ?, "
				+ "JOB_ID= ?, LAST_NAME= ?, MANAGER_ID= ?, "
				+ "PHONE_NUMBER= ?, SALARY= ? WHERE EMPLOYEE_ID =? ";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, employees.getCommissionPct());
		stmt.setInt(2, employees.getDepartmentId());
		stmt.setString(3, employees.getEmail());
		stmt.setInt(4, employees.getEmployeeId());
		stmt.setString(5, employees.getFirstName());
		stmt.setTimestamp(6, (new Timestamp(employees.getHireDate()
				.getTimeInMillis())));
		stmt.setString(7, employees.getJobId());
		stmt.setString(8, employees.getLastName());
		stmt.setInt(9, employees.getManagerId());
		stmt.setString(10, employees.getPhoneNumber());
		stmt.setDouble(11, employees.getSalary());

		retorno = stmt.executeUpdate();
		return retorno;

	}

	@Override
	public Integer deletar(Object objetoPersistir) throws Exception {
		Integer retorno = 0;

		Employees employees = (Employees) objetoPersistir;
		String sql = "DELETE FROM HR.EMPLOYEES WHERE EMPLOYEE_ID =? ";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(4, employees.getEmployeeId());
		System.out.println(sql);
		stmt.execute();

		retorno = stmt.getUpdateCount();
		return retorno;

	}

}
