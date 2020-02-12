package br.com.gx2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.entities.Cliente;
import br.com.gx2.entities.Indicador;
import br.com.gx2.repositories.ClienteRepository;
import br.com.gx2.repositories.IndicadorRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class IndicadorService {
	@Autowired
	private IndicadorRepository repository;
	
	public List<Indicador> findAll(){
		
		return repository.findAll();
	}
	
	public Indicador findByID(Integer id) {
		
		Indicador obj = repository.findById(id).orElse(null);
		if (obj == null) {

			throw new ObjectNotFoundException("Objeto não localizado!");
		}
		
		return obj;
	}
	
	
	public void deleteByID(Integer id) {
		if (id == null) {

			throw new ObjectNotFoundException("Objeto não localizado!");
		}
		repository.deleteById(id);
		
	}
	
	public Indicador save(Indicador indicador) {
		
		return repository.saveAndFlush(indicador);
	}
}
