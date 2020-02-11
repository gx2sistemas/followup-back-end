package br.com.gx2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gx2.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
