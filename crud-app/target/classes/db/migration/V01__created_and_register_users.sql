CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL ,
	`email` VARCHAR(50) NOT NULL ,
	`password` VARCHAR(150) NOT NULL ,
	`status` TINYINT NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `email` (`email`) USING BTREE,
	INDEX `ativado` (`status`) USING BTREE
)
ENGINE=InnoDB;

INSERT INTO `users` (`id`, `name`, `email`, `password`, `status`) VALUES (1, 'Administrador', 'tecnologia.sistemas@sespa.pa.gov.br', '$2a$10$iwcbc3IUaZN8h0CqZhaKuOxOr5yt.0.jhJ4fVblY/1SMfzXixJhE6', 1);
INSERT INTO `users` (`id`, `name`, `email`, `password`, `status`) VALUES (2, 'Operador', 'operador.sistemas@sespa.pa.gov.br', '$2a$10$iwcbc3IUaZN8h0CqZhaKuOxOr5yt.0.jhJ4fVblY/1SMfzXixJhE6', 1);

