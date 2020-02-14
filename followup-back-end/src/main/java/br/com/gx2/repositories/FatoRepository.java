package br.com.gx2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gx2.entities.Fato;

@Repository
public interface FatoRepository extends JpaRepository<Fato, Long> {

}
