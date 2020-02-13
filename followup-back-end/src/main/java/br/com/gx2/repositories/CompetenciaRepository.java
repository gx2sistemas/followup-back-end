package br.com.gx2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gx2.entities.Competencia;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {

	
	
}
