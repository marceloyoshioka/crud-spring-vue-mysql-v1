package br.gov.pa.saude.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.pa.saude.api.exceptionhandler.NegocioException;
import br.gov.pa.saude.api.model.User;
import br.gov.pa.saude.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new NegocioException("Usuário Não Encontrado") );
	}

	public User create(User user) {
		return repository.save(user);
	}
	
	public User update( Long id, User user) {
		User userSaved = findById(id);
		
		BeanUtils.copyProperties(user, userSaved,"id");
		return repository.save(userSaved);
	}
	
	public void delete(Long id) {
		User user = findById(id);
		repository.deleteById(user.getId());	
	}
	
}









