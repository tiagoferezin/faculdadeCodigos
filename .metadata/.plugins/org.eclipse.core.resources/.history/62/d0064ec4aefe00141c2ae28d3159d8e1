<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.acoes {
	width: 100%;
	background-color: #EFEFEF;
	text-align: right;
	padding: 10px;
}

.form-group.div20 {
	width: 20%;
}
</style>

<title>Editar Employee</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="./plugins/bootstrap-3.3.4-dist/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="./plugins/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="./plugins/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Editar Employees</h1>

	<form action="./employees?logica=salvar" method="post">

		<!-- inserir esta parte nas outras areas -->

		<input type="hidden" id="txtEmployeeId" name="employeeId"
			value="${employee.employeeId}" />

		<div class="acoes">

			<button type="submit" class="btn btn-primary">Salvar</button>

		</div>


		<div class="form-group div20">

			<label for="txtFirstName">Primeiro Nome: </label> <input type="text"
				id="txtFirstName" name="firstName" class="form-control"
				value="${employee.firstName}" />
		</div>

		<div class="form-group div20">

			<label for="txtLastName">Sobrenome: </label> <input type="text"
				id="txtLastName" name="lastName" class="form-control"
				value="${employee.lastName}" />
		</div>

		<div class="form-group div20">

			<label for="txtEmail">E-mail: </label> <input type="text"
				id="txtEmail" name="email" class="form-control"
				value="${employee.email}" />
		</div>

		<div class="form-group div20">

			<label for="txtPhoneNumber">Número de telefone: </label> <input
				type="text" id="txtPhoneNumber" name="phoneNumber"
				class="form-control" value="${employee.phoneNumber}" />
		</div>

		<div class="form-group div20">

			<label for="txtHireDate">Data de contratação: </label> <input
				type="text" id="txtHireDate" name="hireDate" class="form-control"
				value='<fmt:formatDate value="${employee.hireDate.time }" pattern="dd/MM/yyyy" />' />
		</div>

		<div class="form-group div20">

			<label for="txtJobId">Id do Cargo: </label> <input type="text"
				id="txtJobId" name="jobId" class="form-control"
				value="${employee.jobId}" />
		</div>

		<div class="form-group div20">

			<label for="txtSalary">Salário: </label> <input type="text"
				id="txtSalary" name="salary" class="form-control"
				value="${employee.salary}" />
		</div>

		<div class="form-group div20">

			<label for="txtCommissionPct">Comissão: </label> <input type="text"
				id="txtCommissionPct" name="commissionPct" class="form-control"
				value="${employee.commissionPct}" />
		</div>

		<div class="form-group div20">

			<label for="txtManagerId">Id Gerente: </label> <input type="text"
				id="txtManagerId" name="managerId" class="form-control"
				value="${employee.managerId}" />
		</div>

		<div class="form-group div20">

			<label for="txtDepartmentId">Id do Departamento </label> <input
				type="text" id="txtDepartmentId" name="departmentId"
				class="form-control" value="${employee.departmentId}" />
		</div>


	</form>
</body>
</html>