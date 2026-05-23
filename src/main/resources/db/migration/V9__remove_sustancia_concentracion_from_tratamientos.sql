ALTER TABLE tratamientos
DROP FOREIGN KEY fk_tratamiento_sustancia;

ALTER TABLE tratamientos
DROP COLUMN sustancia_id,
DROP COLUMN concentracion,
DROP COLUMN unidad;