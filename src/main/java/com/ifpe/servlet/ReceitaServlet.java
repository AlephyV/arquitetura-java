package com.ifpe.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ifpe.entities.Receita;

/**
 * Servlet implementation class ReceitaServlet
 */
@WebServlet("/ReceitaServlet")
public class ReceitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Receita> receitas = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceitaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
			case "listar":
				request.setAttribute("receitas", this.receitas);
				request.getRequestDispatcher("/WEB-INF/views/receitas.jsp").forward(request, response);
			break;
			case "editar":
				Receita receita = getReceitaPorId(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("receita", receita);
				request.setAttribute("receitas", this.receitas);
				request.getRequestDispatcher("/WEB-INF/views/receitas.jsp").forward(request, response);
			break;
			case "excluir":
				receita = getReceitaPorId(Integer.parseInt(request.getParameter("id")));
				excluirReceita(receita);
				response.sendRedirect("http://localhost:8080/farmacia/ReceitaServlet?acao=listar");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomePaciente = request.getParameter("nome_paciente");
		String orientacao = request.getParameter("orientacao");
		String nomeMedico = request.getParameter("nome_medico");
		
		if(request.getParameter("id").equals("")) {
			Receita receita = new Receita(getId(), nomePaciente, nomeMedico, orientacao);
			receitas.add(receita);
			response.sendRedirect("http://localhost:8080/farmacia/ReceitaServlet?acao=listar");
		} else {
			int idReceita = Integer.parseInt(request.getParameter("id"));
			Receita receita = new Receita(idReceita, nomePaciente, nomeMedico, orientacao);
			atualizarReceita(receita);
			response.sendRedirect("http://localhost:8080/farmacia/ReceitaServlet?acao=listar");
		}
	}
	
	private Receita getReceitaPorId(int id) {
		for(Receita receita : receitas) {
			if(receita.getId() == id) {
				return receita;
			}
		}
		return null;
	}

	private void excluirReceita(Receita tarefa) {
		receitas.remove(tarefa);
	}
	
	private int getId() {
		return this.receitas.size()+1;
	}
	
	private void atualizarReceita(Receita receita) {
		for(Receita r : receitas) {
			if(r.getId() == receita.getId()) {
				int indice = receitas.indexOf(r);
				receitas.set(indice, receita);
			}
		}
	}
}
