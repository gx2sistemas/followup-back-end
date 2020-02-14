package br.com.gx2.resources;

import java.net.URI;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.gx2.DTO.FatoDTO;
import br.com.gx2.entities.Fato;
import br.com.gx2.entities.User;
import br.com.gx2.services.FatoServices;
import br.com.gx2.services.UserService;
import br.com.gx2.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/fatos")
@RequiredArgsConstructor
public class FatoResource {
	
	@Autowired
	private final FatoServices service;
	private final UserService serviceUsuario;
	
	@GetMapping
	public ResponseEntity<List<Fato>> findAll(){
		
		List<Fato> fatos = service.findAll();
		return ResponseEntity.ok(fatos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fato> findById(@PathVariable Long id){
		Fato obj = service.findByID(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	public ResponseEntity salvarFato(@RequestBody FatoDTO dto) {
	
		try {
			Fato entidade = converter(dto);
			entidade  = service.save(entidade);
			
			return new ResponseEntity(entidade, HttpStatus.CREATED);
		} catch(ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody Fato obj) {
		Fato fato = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fato.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.deleteById(id);

		return ResponseEntity.noContent().build();
	}
	
	private Fato converter(FatoDTO dto) {
		Fato fato = new Fato();
		
		fato.setId(dto.getId());
		fato.setDescricaoFato(dto.getDescricaoFato());
		fato.setDataFato(dto.getDataFato());
		
		User usuario = serviceUsuario.findByID(dto.getUsuario());
		fato.setUsuario(usuario);
		
		return fato;
		
	}
	
	
	
	

}
