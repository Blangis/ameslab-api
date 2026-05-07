CREATE TABLE experimentos(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(150) NOT NULL,
    fecha DATE,
    cepa VARCHAR(50) NOT NULL,
    descripcion TEXT
);