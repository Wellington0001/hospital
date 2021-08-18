<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Gestão Hospitalar</title>

		<!-- Bootstrap core CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

		<style>
			.bd-placeholder-img {
				font-size: 1.125rem;
				text-anchor: middle;
				-webkit-user-select: none;
				-moz-user-select: none;
				user-select: none;
			}

			@media (min-width : 768px) {
				.bd-placeholder-img-lg {
					font-size: 3.5rem;
				}
			}
		</style>

		<!-- Custom styles for this template -->
		<link href="css/form.css" rel="stylesheet">
		<link href="css/form-validation.css" rel="stylesheet">

		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="s" uri="/struts-tags" %>
		<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
					<h1 class="display-4 fw-normal">Atendente</h1>
				</div>
			</header>

			<main class="form-signin">
				<div class="">
					<form class="card p-2" id="form-pesquisa" action="pesquisar_atendente" method="post">
						<div class="input-group">
							<input type="text" class="form-control" name="parametroPesquisa" placeholder="Nome">
							<button type="submit" class="btn btn-secondary">Pesquisar</button>
						</div>
					</form>
					
					<br/>

					<div class="card">
						<div class="card-header">
				        	<b>Atendentes Cadastrados</b> <a href="cadastrar_atendente" class="btn btn-sm btn-primary"><i class="fa fa-file-text-o"></i>Cadastrar Atendente</a>
				        </div>
				        
						<!-- /.card-header -->
						<div class="card-body">
							<table id="lista-atendente" class="table table-bordered table-striped">
								<thead>
									<tr>
										<th width="40%">Nome</th>
										<th width="20%">Telefone</th>
										<th width="20%">Ações</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="atendente" items="${atendentes}">
										<tr>
											<td>${atendente.nome}</td>
											<td>${atendente.telefone}</td>
											<td align="center">
												<form action="#" method="post" id="form-lista">
													<input type="hidden" id="idAtendente" name="idAtendente" value="${atendente.id}">

													<button type="button" class="btn btn-sm btn-primary" onclick="editar('${atendente.id}')">Editar</button>
													<button type="button" class="btn btn-sm btn-danger" onclick="excluir('${atendente.id}')">Excluir</button>
												</form>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!-- /.card-body -->
					</div>

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

		<script type="text/javascript">

			function editar(value) {
				document.getElementById('idAtendente').value = value;

				var form = document.forms['form-lista'];
				form.action = "editar_atendente";
				form.submit();
			}

			function excluir(value) {
				document.getElementById('idAtendente').value = value;

				var form = document.forms['form-lista'];
				form.action = "excluir_atendente";
				form.submit();
			}

		</script>
	</body>

	</html>