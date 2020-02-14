package br.com.gx2.DTO;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CursoDTO {

	private Long id;
	private String cursoNome;
	private String cursoInstituicao;
	private Date cursoDataFinalizacao;
	private Integer cursoDuracao;
	private Integer usuario;
	
}
