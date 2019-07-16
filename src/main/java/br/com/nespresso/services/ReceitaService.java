package br.com.nespresso.services;

import br.com.nespresso.entities.Receita;
import br.com.nespresso.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Transactional
    public void nova(Receita pReceita) {
        this.receitaRepository.save(pReceita);
    }
    
    public List<Receita> buscaTodas() {
        return this.receitaRepository.findAll();
    }

	public Receita buscaReceita(int pCodigo) {
		Receita receita = receitaRepository.findOne(pCodigo);
		return receita;
	}

	
	
}
