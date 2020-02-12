package br.com.gx2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.entities.Curso;
import br.com.gx2.entities.User;
import br.com.gx2.repositories.CursoRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class CursoService {

	@Autowired
	CursoRepository repository;
	
	public List<Curso> findAll(){
		
		return repository.findAll();
	}
	
	
	public Curso findbyId(Long id) {
		
		Curso obj = repository.findById(id).orElse(null);
		if (obj == null) {
			throw new ObjectNotFoundException("Curso não localizado!");
		}
		
		return obj;

	}
	
	
	public Curso salvarCurso(Curso curso) {
		return repository.save(curso);
	}
	
	
}
