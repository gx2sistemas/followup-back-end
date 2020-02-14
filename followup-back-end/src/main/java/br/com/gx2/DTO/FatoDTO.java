package br.com.gx2.DTO;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FatoDTO {
	
	private Long id;
	private String descricaoFato;
	private Date dataFato;
	private Integer usuario;

}
