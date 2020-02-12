package br.com.gx2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gx2.entities.Indicador;



@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Integer> {

}