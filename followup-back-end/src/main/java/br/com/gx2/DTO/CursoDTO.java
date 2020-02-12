package br.com.gx2.DTO;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CursoDTO {

	private Long id;
	private String cursoNome;
	private String cursoInstituicao;
	private Date cursoDataFinalizacao;
	private Integer cursoDuracao;
	private Integer usuario;
	
}
