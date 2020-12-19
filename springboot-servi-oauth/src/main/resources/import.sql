INSERT INTO usuarios (username, password , enabled, nombre, apellido, email) VALUES ('cpalacio', '$2a$10$GsjsPOrW0miSvyhKJWXRPulodUOS2BqmLVcFb2qxYubxEsmyHEB7q' , 1, 'Cristian', 'Palacio', 'crpalacio52@gmail.com');

INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN')

INSERT INTO usuario_to_roles (usuario_id, role_id ) VALUES (1,1)

INSERT INTO tarjetas_de_credito (numero_de_tarjeta, cvv, fecha_de_vencimiento) VALUES ('4304358228766553', '752', '04/2027')
INSERT INTO personas (identificacion, apellidos, email, nombres , tarjeta_numero_de_tarjeta) VALUES (1, 'palacio', 'crpalacio52@gmail.com', 'cristian', '4304358228766553')