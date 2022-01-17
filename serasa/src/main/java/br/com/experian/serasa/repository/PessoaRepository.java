package br.com.experian.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.experian.serasa.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	

}
