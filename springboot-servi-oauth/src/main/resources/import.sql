INSERT INTO usuarios (username, password , enabled, nombre, apellido, email) VALUES ('cpalacio', '$2a$10$GsjsPOrW0miSvyhKJWXRPulodUOS2BqmLVcFb2qxYubxEsmyHEB7q' , 1, 'Cristian', 'Palacio', 'crpalacio52@gmail.com');
INSERT INTO usuarios (username, password , enabled, nombre, apellido, email) VALUES ('apalacio', '$2a$10$3LvHdhVLStQ/nwqniQJcC.ivm6xWE2jP83vDGhHFSSCETUrxBeDym' , 1, 'Andres', 'Palacio', 'themagician.net@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_USER')
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN')

INSERT INTO usuario_to_roles (usuario_id, role_id ) VALUES (1,1)
INSERT INTO usuario_to_roles (usuario_id, role_id ) VALUES (2,1)
INSERT INTO usuario_to_roles (usuario_id, role_id ) VALUES (2,2)
