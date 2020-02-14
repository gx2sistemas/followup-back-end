package br.com.gx2.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gx2.entities.Competencia;
import br.com.gx2.services.CompetenciaService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/competencias")
public class CompetenciaResource {

	@Autowired
	private CompetenciaService service;

	@GetMapping
	public ResponseEntity<List<Competencia>> findAll() {
		List<Competencia> competencia = service.findAll();
		return ResponseEntity.ok(competencia);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Competencia> findById(@PathVariable Integer id) {
		Competencia obj = service.findByID(id);

		return ResponseEntity.ok(obj);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.deleteByID(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Competencia obj) {
		Competencia competencia = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(competencia.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody Competencia obj) {
		Competencia competencia = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(competencia.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}
