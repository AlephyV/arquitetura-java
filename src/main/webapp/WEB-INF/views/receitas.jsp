<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Inicio</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <header>
            <nav>
                <div class="topnav">
                    <li>
                        <ul><a href="http://localhost:8080/farmacia">Home</a></ul>
                        <ul><a class="active">Receitas</a></ul>
                    </li>
                </div>
            </nav>
        </header>

        <section id="section1">
            <div id="titulo">
                Lista de <span id="receitas">receitas</span>
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Nome do paciente</th>
                        <th>Orientação</th>
                        <th>Nome do médico</th>
                        <th>Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var = "receita" items="${receitas}">
			        	<tr>
	                        <td>${receita.nomePaciente}</td>
	                        <td>${receita.orientacao}</td>
	                        <td>${receita.nomeMedico}</td>
	                        <td><a href="http://localhost:8080/farmacia/ReceitaServlet?acao=editar&id=${receita.id}">Editar</a>|<a href="http://localhost:8080/farmacia/ReceitaServlet?acao=excluir&id=${receita.id}">Excluir</a></td>
                    	</tr>
			      	</c:forEach>
                </tbody>
            </table>
        </section>

        <section id="section2">
            <div id="titulo">
                Cadastrar <span id="receitas">receita</span>
            </div>
            <form method="post" action="http://localhost:8080/farmacia/ReceitaServlet">
                <div class="listItem">
                    <label for="nome_paciente">Nome do paciente</label>
                    <input required placeholder="Digite o nome do paciente" type="text" name="nome_paciente" id="nome_paciente" value="${receita.nomePaciente}">
                </div>

                <div class="listItem">
                    <label for="orientacao">Orientação</label><br/>
                    <textarea required placeholder="Digite a orientação" name="orientacao" id="orientacao">${receita.orientacao}</textarea>
                </div>

                <div class="listItem">
                    <label for="nome_medico">Nome do médico</label>
                    <input required placeholder="Digite o nome do médico" type="text" name="nome_medico" id="nome_medico" value="${receita.nomeMedico}">
                </div>
                
                <input type="hidden" name="id" value="${receita.id}">

                <div class="listItem">
                    <button type="submit">Cadastrar</button>
                </div>

            </form>
        </section>
    </body>
</html>