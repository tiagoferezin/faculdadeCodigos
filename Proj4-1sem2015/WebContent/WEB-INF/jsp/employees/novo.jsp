<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo empregado</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="./plugins/bootstrap-3.3.4-dist/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="./plugins/bootstrap-3.3.4-dist/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="./plugins/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
<style type="text/css">
.acoes {
  width:100%; background-color:#EFEFEF;
  text-align: right;
  padding:10px;
}

.form-group {
  padding: 10px;
}

.form-group.div20 {
  width: 20%;
}


</style>
</head>
<body>
	<h1>Novo empregado</h1>
	<form action="./employees?logica=salvar"
		method="post"
		
		>
		<div class="acoes">
			<button type="submit" 
			        class="btn btn-primary">
			        Salvar</button>
			
		</div>
	 	
	 	<div class="form-group">
	 		<label for="txtFirstName">Primeiro Nome:</label>
	 		<input 
	 		    type="text" 
	 			id="txtFirstName" 
	 			name="firstName"
	 			class="form-control"/>
	 	</div>
		<div class="form-group">
	 		<label for="txtLastName">Ultimo Nome:</label>
	 		<input 
	 		    type="text" 
	 			id="txtLastName" 
	 			name="lastName"
	 			class="form-control"/>
	 	</div>
		<div class="form-group">
	 		<label for="txtEmail">Email:</label>
	 		<input 
	 		    type="text" 
	 			id="txtEmail" 
	 			name="email"
	 			class="form-control"/>
	 	</div>
	 	<div class="form-group div20">
	 		<label for="txtHireDate">Admissão:</label>
	 		<input 
	 		    type="text" 
	 			id="txtHireDate" 
	 			name="hireDate"
	 			class="form-control"/>
	 	</div>
	 	
	 	<div class="form-group div20">
	 		<label for="txtJobId">Job.Id:</label>
	 		<input 
	 		    type="text" 
	 			id="txtJobId" 
	 			name="jobId"
	 			class="form-control"/>
	 	</div>
	 		 	
	 	<div class="form-group div20">
	 		<label for="txtSalary">Salário:</label>
	 		<input 
	 		    type="text" 
	 			id="txtSalary" 
	 			name="salary"
	 			class="form-control"/>
	 	</div>
	 	
	 	<div class="form-group div20">
	 		<label for="txtCommissionPct">Comissão:</label>
	 		<input 
	 		    type="text" 
	 			id="txtCommissionPct" 
	 			name="commissionPct"
	 			class="form-control"/>
	 	</div>	 		 		 		 	

	 	<div class="form-group div20">
	 		<label for="txtDepartment">ID do Departamento:</label>
	 		<input 
	 		    type="text" 
	 			id="txtDepartmentId" 
	 			name="departmentId"
	 			class="form-control"/>
	 	</div>	 		 		 		 	

		<div class="form-group div20">
	 		<label for="txtManagerId">ID do Gerente:</label>
	 		<input 
	 		    type="text" 
	 			id="txtManagerId" 
	 			name="managerId"
	 			class="form-control"/>
	 	</div>	 		 		
	</form>
</body>
</html>