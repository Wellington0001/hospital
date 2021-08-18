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

<!-- Custom styles for this template -->
<link href="css/form.css" rel="stylesheet">
<link href="css/form-validation.css" rel="stylesheet">

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
						<a class="me-3 py-2 text-dark text-decoration-none" href="listar_medicos">Médico</a>
						<a class="me-3 py-2 text-dark text-decoration-none" href="listar_atendentes">Atendente</a>
						<a class="me-3 py-2 text-dark text-decoration-none" href="listar_pacientes">Paciente</a>
						<a class="me-3 py-2 text-dark text-decoration-none" href="listar_consultas">Consultas</a>
						<a class="me-3 py-2 text-dark text-decoration-none" href="sair">Sair</a>
						<a class="me-3 py-2 text-dark text-decoration-none"> | </a>
						<a class="me-3 py-2 text-dark text-decoration-none">Seja bem-vindo, ${usuarioLogado.nome}</a>
					</nav>

				</div>

				<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
					<h1 class="display-4 fw-normal">Médico</h1>
				</div>
			</header>

		<main class="form-signin">
			<div class="">
		        <h4 class="mb-3">Cadastrar Médico</h4>
		        
		        <form class="needs-validation" id="form" action="salvar_medico" method="post" novalidate>
		        	
		        	<input type="hidden" id="idMedico" name="medico.id" value="${medico.id}">
		        	
					<div class="row g-3">
		            	<div class="col-sm-12">
		              		<label for="nome" class="form-label">Nome</label>
		              		<input type="text" class="form-control" id="nome" name="medico.nome" value="${medico.nome}" required>
		              		<div class="invalid-feedback">Nome é obrigatório.</div>
		            	</div>
						
						<div class="col-sm-6">
		              		<label for="especialidade" class="form-label">Especialidade</label>
		              		<input type="text" class="form-control" id="especialidade" name="medico.especialidade" value="${medico.especialidade}" required>
		              		<div class="invalid-feedback">Especialidade é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-6">
		              		<label for="crm" class="form-label">CRM</label>
		              		<input type="text" class="form-control" id="crm" name="medico.crm" value="${medico.crm}" required>
		              		<div class="invalid-feedback">CRM é obrigatório.</div>
		            	</div>
		            	
						<div class="col-sm-6">
		              		<label for="login" class="form-label">Login</label>
		              		<input type="text" class="form-control" id="login" name="medico.login" value="${medico.login}" required>
		              		<div class="invalid-feedback">Login é obrigatório.</div>
		            	</div>
						
		            	<div class="col-sm-6">
		              		<label for="senha" class="form-label">Senha</label>
		              		<input type="password" class="form-control" id="senha" name="medico.senha" required>
		              		<div class="invalid-feedback">Senha é obrigatório</div>
		            	</div>
		            	
		          	</div>
		
		          <hr class="my-4">
		
		          <button class="btn btn-primary" type="submit">Salvar</button>
		          <a class="btn btn-secondary" href="listar_medicos">Voltar</a>
		          
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

	<script src="js/form-validation.js"></script>

</body>
</html>
