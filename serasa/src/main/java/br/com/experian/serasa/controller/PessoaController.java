package br.com.experian.serasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import br.com.experian.serasa.model.Pessoa;
import br.com.experian.serasa.service.PessoaService;
import br.com.experian.serasa.view.View;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	
	//Buscar todas pessoas
	@GetMapping
	@JsonView(View.Internal.class)
	public ResponseEntity<List<Pessoa>> getAll(){
		return ResponseEntity.ok(pessoaService.BuscarPessoas());
	}
	
	//Buscar por ID
	@GetMapping("/{id}")
	@JsonView(View.ExtendedPublic.class)
	public ResponseEntity<Pessoa> getById(@PathVariable long id) {
		return pessoaService.BuscarPessoaId(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// Cadastrar nova Pessoa
	@PostMapping
	public ResponseEntity<Pessoa> postPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.cadastrarPessoa(pessoa).map(resp -> ResponseEntity
				.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}

	

}
