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

import br.com.gx2.entities.Cliente;
import br.com.gx2.entities.Indicador;
import br.com.gx2.services.ClienteService;
import br.com.gx2.services.IndicadorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/indicadores")
public class IndificadorResource {


	@Autowired
	private IndicadorService service;

	@GetMapping
	public ResponseEntity<List<Indicador>> findAll() {
		List<Indicador> indicador= service.findAll();
		return ResponseEntity.ok(indicador);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Indicador> findById(@PathVariable Integer id){
		Indicador obj = service.findByID(id);

		return ResponseEntity.ok(obj);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.deleteByID(id);

		return ResponseEntity.noContent().build();
	}

//	{
//	"razaoSocial":"TomCAT",
//	"logo":"C:/Desktop/minhaFoto.png",
//	"gestao":"Marcos Das Minas"
//	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Indicador obj) {
		Indicador indicador = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(indicador.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	public ResponseEntity<Void> update(@RequestBody Indicador obj) {
		Indicador indicador = service.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(indicador.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	
}
