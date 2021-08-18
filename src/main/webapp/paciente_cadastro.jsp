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
					<h1 class="display-4 fw-normal">Paciente</h1>
				</div>
			</header>

		<main class="form-signin">
			<div class="">
		        <h4 class="mb-3">Cadastrar Paciente</h4>
		        
		        <form class="needs-validation" id="form" action="salvar_paciente" method="post" novalidate>
		        	
		        	<input type="hidden" id="idPaciente" name="paciente.id" value="${paciente.id}">
		        	
					<div class="row g-3">
		            	<div class="col-sm-12">
		              		<label for="nome" class="form-label">Nome</label>
		              		<input type="text" class="form-control" id="nome" name="paciente.nome" value="${paciente.nome}" required>
		              		<div class="invalid-feedback">Nome é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-3">
		              		<label for="cpf" class="form-label">CPF</label>
		              		<input type="text" class="form-control" id="cpf" name="paciente.cpf" value="${paciente.cpf}" required>
		              		<div class="invalid-feedback">CPF é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-6">
		              		<label for="email" class="form-label">E-mail</label>
		              		<input type="email" class="form-control" id="email" name="paciente.email" value="${paciente.email}" required>
		              		<div class="invalid-feedback">E-mail é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-3">
		              		<label for="telefone" class="form-label">Telefone</label>
		              		<input type="text" class="form-control" id="telefone" name="paciente.telefone" value="${paciente.telefone}" required>
		              		<div class="invalid-feedback">Telefone é obrigatório.</div>
		            	</div>
						
						<div class="col-sm-12">
		              		<label for="endereco" class="form-label">Endereço</label>
		              		<input type="text" class="form-control" id="endereco" name="paciente.endereco" value="${paciente.endereco}" required>
		              		<div class="invalid-feedback">Endereço é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-5">
		              		<label for="cidade" class="form-label">Cidade</label>
		              		<input type="text" class="form-control" id="cidade" name="paciente.cidade" value="${paciente.cidade}" required>
		              		<div class="invalid-feedback">Cidade é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-4">
		              		<label for="estado" class="form-label">Estado</label>
		              		<input type="text" class="form-control" id="estado" name="paciente.estado" value="${paciente.estado}" required>
		              		<div class="invalid-feedback">Estado é obrigatório.</div>
		            	</div>
		            	
		            	<div class="col-sm-3">
		              		<label for="cep" class="form-label">CEP</label>
		              		<input type="text" class="form-control" id="cep" name="paciente.cep" value="${paciente.cep}" required>
		              		<div class="invalid-feedback">CEP é obrigatório.</div>
		            	</div>
		            	
		          	</div>
		
		          <hr class="my-4">
		
		          <button class="btn btn-primary" type="submit">Salvar</button>
		          <a class="btn btn-secondary" href="listar_pacientes">Voltar</a>
		          
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
