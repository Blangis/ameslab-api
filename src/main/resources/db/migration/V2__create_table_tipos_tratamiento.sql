CREATE TABLE tipos_tratamiento (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(80) NOT NULL UNIQUE,
    descripcion TEXT
);