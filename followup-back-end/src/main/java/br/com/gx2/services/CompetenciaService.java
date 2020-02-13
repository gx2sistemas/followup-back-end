package br.com.gx2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.entities.Competencia;
import br.com.gx2.repositories.CompetenciaRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;
@Service
public class CompetenciaService {

	@Autowired
	private CompetenciaRepository repository;

	public List<Competencia> findAll() {

		return repository.findAll();
	}

	public Competencia findByID(Integer id) {

		Competencia obj = repository.findById(id).orElse(null);
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

	public Competencia save(Competencia competencia) {

		return repository.saveAndFlush(competencia);
	}

}
