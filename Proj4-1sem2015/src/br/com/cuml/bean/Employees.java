package br.com.cuml.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Employees {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Calendar hireDate;
	private String jobId;
	private Double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;

	public Employees() {
		
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Double getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Double commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getHireDateFormatado() {
		return getHireDateFormatado("dd/MM/yyyy");
	}

	public String getHireDateFormatado(String formatoSimpleDateFormat) {
		String retorno = "";
		if (hireDate != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatoSimpleDateFormat);
			retorno = sdf.format(hireDate.getTime());
		}
		return retorno;
	}

	@Override	
	public String toString() {
		String retorno = "";
		if (this.getFirstName() != null) {
			if (retorno != "") {
				retorno += ", ";
			}
			retorno += "Nome: " + this.getFirstName();
		}

		if (this.getLastName() != null) {
			if (retorno != "") {
				retorno += ", ";
			}
			retorno += "Sobrenome: " + this.getLastName();
		}

		if (this.getEmail() != null) {
			if (retorno != "") {
				retorno += ", ";
			}
			retorno += "Email: " + this.getEmail();
		}
		
		if (this.getSalary()!=null) {
			if (retorno != "") {
				retorno += ", ";
			}
			retorno += "Salário: " + this.getSalary();
		}
		
		return retorno;
	}
}
