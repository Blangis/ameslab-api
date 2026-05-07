CREATE TABLE tratamientos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sustancia_id BIGINT NOT NULL,
    tipo_tratamiento_id BIGINT NOT NULL,
    nombre VARCHAR(150),
    concentracion DECIMAL(10,2) NOT NULL,
    unidad VARCHAR(50) NOT NULL,
    descripcion TEXT,

    CONSTRAINT fk_tratamiento_sustancia
                          FOREIGN KEY (sustancia_id)
                          REFERENCES sustancias(id),

    CONSTRAINT fk_tratamiento_tipo_tratamiento
                          FOREIGN KEY (tipo_tratamiento_id)
                          REFERENCES tipos_tratamiento(id)
)