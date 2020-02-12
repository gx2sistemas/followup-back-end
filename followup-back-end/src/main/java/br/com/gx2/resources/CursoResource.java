package br.com.gx2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gx2.DTO.CursoDTO;
import br.com.gx2.entities.Curso;
import br.com.gx2.entities.User;
import br.com.gx2.services.CursoService;
import br.com.gx2.services.UserService;
import br.com.gx2.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoResource {
	
	@Autowired
	private final CursoService service;
	private final UserService serviceUsuario;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {

		List<Curso> cursos = service.findAll();
		return ResponseEntity.ok(cursos);
	}
	
	
	@PostMapping
	public ResponseEntity salvarCurso(@RequestBody CursoDTO dto) {
		try {
			Curso entidade = converter(dto);
			entidade = service.salvarCurso(entidade);
			
			return new ResponseEntity(entidade, HttpStatus.CREATED);
			
		}catch(ObjectNotFoundException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	private Curso converter(CursoDTO dto) {
		Curso curso = new Curso();
		
		curso.setCursoId(dto.getId());
		curso.setCursoNome(dto.getCursoNome());
		curso.setCursoInstituicao(dto.getCursoInstituicao());
		curso.setCursoDuracao(dto.getCursoDuracao());
		curso.setCursoDataFinalizacao(dto.getCursoDataFinalizacao());
		
		User usuario = serviceUsuario.findByID(dto.getUsuario());
		curso.setUsuario(usuario);
				
		return curso;
		
	}
	
	
	

}
