package br.gov.pa.saude.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.pa.saude.api.model.User;
import br.gov.pa.saude.api.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserControlle {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> findAll() {
		List<User>lista = userService.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable Long id){
		User user = userService.findById(id);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/")
	public ResponseEntity<User>create( @RequestBody User user ){
		User userSaved = userService.create(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userSaved);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user){
		User userSaved = userService.update(id, user);
		return ResponseEntity.ok(userSaved);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}






