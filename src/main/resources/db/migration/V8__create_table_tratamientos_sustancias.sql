CREATE TABLE tratamientos_sustancias (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    tratamiento_id BIGINT NOT NULL,
    sustancia_id BIGINT NOT NULL,
    concentracion DECIMAL(10,3) NOT NULL,
    unidad VARCHAR(50) NOT NULL,

    CONSTRAINT fk_tratamiento_sustancia_tratamiento
      FOREIGN KEY (tratamiento_id)
      REFERENCES tratamientos(id),

    CONSTRAINT fk_tratamiento_sustancia_sustancia
      FOREIGN KEY (sustancia_id)
      REFERENCES sustancias(id)
);