<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/MaesEmAcao/assets/css/stylecss.css" />
<title>M�es em A��o</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg">
			<div class="container-fluid">
				<a class="navbar-brand" href="#"> <img
					src="/MaesEmAcao/assets/img/logo/logo-sem-fundo.png"
					class="bordas-thumb-logo" alt="" width="60" height="60" />
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navVagas"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navVagas">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0 mx-auto">
						<li class="nav-item"><a class="nav-link active"
							href="/MaesEmAcao/index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="perfil.html">Perfil</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="vagas.html">Vagas</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="contato.html">Contato</a></li>
						<li class="nav-item"><a class="nav-link active"
							href="/MaesEmAcao/candidato">Candidato</a></li>
					</ul>
					<div class="d-flex">
						<a href="#" class="text-dark me-3"><i class="bi bi-facebook"></i></a>
						<a href="#" class="text-dark me-3"><i class="bi bi-instagram"></i></a>
						<a href="#" class="text-dark me-3"><i class="bi bi-linkedin"></i></a>
						<a href="#" class="text-dark"><i class="bi bi-twitter"></i></a>
					</div>
				</div>
			</div>
		</nav>
	</header>
	<section class="conteiner-principal">
		<section class="conteiner-segundario">
			<main>
				<section class="container titulos">
					<div class="p-4">
						<a href="/MaesEmAcao/candidato" class="btn btn-dark mb-2 botoes">Voltar</a>
						<table class="table table-responsive table-hover">
							<thead class="table-dark">
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Nome Empresa</th>
									<th scope="col">Cargo</th>
									<th scope="col">Data In�cio</th>
									<th scope="col">Data Final</th>
									<th scope="col">Id Candidato</th>
									<th scope="col">Atualizar</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${experiencia.idExperiencia}</td>
									<td>${experiencia.nomeEmpresa}</td>
									<td>${experiencia.cargo}</td>
									<td>${experiencia.dataInicio}</td>
									<td>${experiencia.dataFinal}</td>
									<td>${experiencia.candidato.idCandidato}</td>
									<td>
										<div class="d-flex">
											<a href="experiencia-editar?id=${experiencia.candidato.idCandidato}"
												class="mx-1" title="Editar"> <i
												class="bi bi-pencil-square"></i>
											</a>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</section>
			</main>
		</section>
		<!--FOOTER-->
		<footer class="container-fluid rodape mt-4">
			<div>
				<section class="row">
					<section class="col about-company text-center mt-3">
						<p>
							<span class="bi bi-facebook"><a href="#" class="link-dark"
								style="text-decoration: none"></a></span> <span class="bi bi-instagram"><a
								href="#" class="link-dark" style="text-decoration: none"></a></span> <span
								class="bi bi-linkedin"><a href="#" class="link-dark"
								style="text-decoration: none"></a></span> <span class="bi bi-twitter"><a
								href="#" class="link-dark" style="text-decoration: none"></a></span>
						</p>
					</section>
				</section>
				<section class="row">
					<section class="col copyright text-center">
						<p class="">
							<small class="text-dark-50">M�es em A��o | � 2023. Todos
								os Direitos Reservados.</small>
						</p>
					</section>
				</section>
			</div>
		</footer>
	</section>
</body>
</html>