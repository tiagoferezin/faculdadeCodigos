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

<title>editar regions</title>

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
	<h1>Editar Regions</h1>

	<form action="./regions?logica=salvar" method="post">

		<!-- inserir esta parte nas outras areas -->

		<input type="hidden" id="txtRegionId" name="regionId"
			value="${region.regionId}" />

		<div class="acoes">

			<button type="submit" class="btn btn-primary">Salvar</button>

		</div>

		<div class="form-group div20">

			<label for="txtRegionId"> Region id: </label> <input type="text"
				id="txtRegionId" name="regionId" class="form-control"
				value="${region.regionId}" />

		</div>

		<div class="form-group div20">

			<label for="txtRegionName">Region Name </label> <input type="text"
				id="txtRegionName" name="regionName" class="form-control"
				value="${region.regionName}" />
		</div>




	</form>
</body>
</html>