<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gestão Hospitalar</title>

<!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<link href="css/login.css" rel="stylesheet">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

</head>
<body>

	<div class="container py-3">
		<header>
			<div class="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom">
				<a href="#" class="d-flex align-items-center text-dark text-decoration-none">
					<span class="fs-4"><b>Gestão Hospitalar</b></span>
				</a>
				
				<nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
					<a class="me-3 py-2 text-dark text-decoration-none" href="index.jsp">Recepção</a>
				</nav>
			</div>

			<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
				<h1 class="display-4 fw-normal">Login</h1>
				<h5>Médico</h5>
			</div>
		</header>

		<main class="form-signin">
			<div align="center">
				<form id="form-login" action="login" method="post">
					<input type="hidden" id="perfil" name="perfil" value="Medico" />
										
					<div class="form-floating">
						<input type="text" class="form-control" id="login" name="login" required="required" autofocus="autofocus"> 
						<label>Login</label>
					</div>
					
					<div class="form-floating">
						<input type="password" class="form-control" id="senha" name="senha" required="required">
						<label>Senha</label>
					</div>
			
					<button class="w-100 btn btn-lg btn-warning" type="submit">Entrar</button>
					
					<s:if test="hasActionErrors()">
						<div class="alert alert-danger">Nome ou senha inválidos</div>
					</s:if>
							
				</form>
			</div>
		</main>

		<footer class="pt-4 my-md-5 pt-md-5 border-top">
			<div class="row">
				<div class="col-12 col-md" align="center">
					<small class="d-block mb-3 text-muted"><b>GESTÃO HOSPITALAR</b></small>
				</div>
			</div>
		</footer>
	</div>



</body>
</html>
