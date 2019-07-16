
-- REMOVENDO USUARIOS
DROP USER IF EXISTS nestle;
DROP USER IF EXISTS'nestle'@'localhost';

FLUSH PRIVILEGES;

-- CRIANDO USUARIO
CREATE USER 'nestle'@'localhost' identified by 'N0t_p@$$';
GRANT SELECT, INSERT, UPDATE, DELETE ON nespresso.* TO 'nestle'@'localhost';
FLUSH PRIVILEGES;

