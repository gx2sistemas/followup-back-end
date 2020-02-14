package br.com.gx2.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="curso")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cursoId;
	
	@Column(name = "cursoNome")
	private String cursoNome;
	
	@Column(name = "cursoInstituicao")
	private String cursoInstituicao;
	
	@Column(name = "cursoDataFinalizacao")
	private Date cursoDataFinalizacao;
	
	@Column(name = "cursoDuracao")
	private Integer cursoDuracao;
	
	@ManyToOne
	@JoinColumn(name = "usuarioId")
	private User usuario;
}
