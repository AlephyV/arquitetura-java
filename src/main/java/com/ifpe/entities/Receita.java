package com.ifpe.entities;

import java.io.Serializable;

public class Receita implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomePaciente;
	private String nomeMedico;
	private String orientacao;
	
	public Receita() {
		
	}
	
	public Receita(Integer id, String nomePaciente, String nomeMedico, String orientacao) {
		super();
		this.id = id;
		this.nomePaciente = nomePaciente;
		this.nomeMedico = nomeMedico;
		this.orientacao = orientacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receita other = (Receita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePasciente) {
		this.nomePaciente = nomePasciente;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeDoMedico) {
		this.nomeMedico = nomeDoMedico;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}
	
	
}
