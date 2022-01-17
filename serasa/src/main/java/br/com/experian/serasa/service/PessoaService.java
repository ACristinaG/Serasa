package br.com.experian.serasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.experian.serasa.model.Pessoa;
import br.com.experian.serasa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	//Buscar por ID
	public Optional <Pessoa> BuscarPessoaId(long id){
		
		return pessoaRepository.findById(id);
		
	}
	
	
	//Buscar todas pessoas
	public List<Pessoa> BuscarPessoas(){
		return pessoaRepository.findAll();
	}
	
	
	//Cadastrar nova pessoa
	public Optional<Pessoa> cadastrarPessoa(Pessoa pessoa){
		
		int score = pessoa.getScore();
		
		if(score<0 || score>1000) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Score min = 0 e Score Máximo = 1000", null);
		
		if(score >= 0 && score <=200) {
			pessoa.setScoreDescricao("Insuficiente");
		}
		else if (score >= 201 && score <=500) {
			pessoa.setScoreDescricao("Inaceitável");
		}
		else if (score >= 501 && score <=700) {
			pessoa.setScoreDescricao("Aceitável");
		}
		else if(score >= 701 && score <=1000) {
			pessoa.setScoreDescricao("Recomendável");
		}
		
		return Optional.of(pessoaRepository.save(pessoa));
		
	}
	

	
}
