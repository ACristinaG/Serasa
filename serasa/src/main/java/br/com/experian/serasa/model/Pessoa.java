package br.com.experian.serasa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.experian.serasa.view.View;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull
	@JsonView(View.Public.class)
	private String nome;
	
	@NotNull
	@JsonView(View.ExtendedPublic.class)
	private String telefone;
	
	@NotNull	
	@JsonView(View.ExtendedPublic.class)
	private int idade;
	
	@NotNull
    @JsonView(View.Internal.class)
	private String cidade;
	
	@NotNull
    @JsonView(View.Internal.class)
	private String estado;
	
	@JsonView(View.Public.class)
	private String scoreDescricao;
	
	@NotNull
	private int score;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getScoreDescricao() {
		return scoreDescricao;
	}

	public void setScoreDescricao(String scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}
	
	
		
	
	
}
