package br.gov.pa.saude.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size
	private String name;
	
	@NotBlank
	@Size(min = 10, max = 50)
	private String email;
	
	//@JsonProperty(access = Access.WRITE_ONLY)
	@Size(min = 6, max = 255)
	private String password;
	
	@NotNull
	private Boolean status;
}
