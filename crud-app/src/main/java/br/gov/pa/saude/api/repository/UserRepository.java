package br.gov.pa.saude.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.pa.saude.api.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
