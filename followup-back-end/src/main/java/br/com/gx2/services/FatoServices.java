package br.com.gx2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.entities.Fato;
import br.com.gx2.repositories.FatoRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class FatoServices {
	
	@Autowired
	private FatoRepository repository;
	
	public List<Fato> findAll(){
		return repository.findAll();
		
	}
	
	public Fato findByID(Long id) {
		Fato obj = repository.findById(id).orElse(null);
		if(obj == null) {
			throw new ObjectNotFoundException("Fato não localizado!");
		}
		return obj;
	}
	
	public Fato save(Fato fato) {
		return repository.save(fato);
	}
	
	public void deleteById(Long id) {
		if (id == null) {
			throw new ObjectNotFoundException("Fato não localizado!");
		}
		repository.deleteById(id);
	}

}
