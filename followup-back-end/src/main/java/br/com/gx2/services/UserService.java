package br.com.gx2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gx2.entities.User;
import br.com.gx2.repositories.UserRepository;
import br.com.gx2.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findByID(Integer id) {
		
		User obj = repository.findById(id).orElse(null);
		if (obj == null) {

			throw new ObjectNotFoundException("Objeto não localizado!");
		}
		
		return obj;
	}
	
	
	public void deleteByID(Integer id) {
		if (id == null) {

			throw new ObjectNotFoundException("Objeto não localizado!");
		}
		repository.deleteById(id);
		
	}
	
	public User save(User user) {
		
		return repository.saveAndFlush(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
