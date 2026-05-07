CREATE TABLE resultados(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    experimento_id BIGINT NOT NULL,
    tratamiento_id BIGINT NOT NULL,
    replica INT NOT NULL,
    revertantes INT NOT NULL,
    observaciones TEXT,

    CONSTRAINT fk_resultado_experimento
                       FOREIGN KEY (experimento_id)
                       REFERENCES experimentos(id),

    CONSTRAINT fk_resultado_tratamiento
                       FOREIGN KEY (tratamiento_id)
                       REFERENCES tratamientos(id)
);