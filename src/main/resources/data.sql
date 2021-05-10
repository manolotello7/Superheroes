DROP TABLE IF EXISTS superheroes;

CREATE TABLE superheroes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  nombre_superheroe VARCHAR(250) NOT NULL
);

INSERT INTO superheroes (nombre_superheroe) VALUES
  ('Spiderman'),
  ('Batman'),
  ('Capitan America'),
  ('Hulk'),
  ('Ironman'),
  ('Thor'),
  ('Superman');