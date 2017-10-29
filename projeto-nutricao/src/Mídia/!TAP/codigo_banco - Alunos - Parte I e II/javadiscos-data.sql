-- Gravadoras:
INSERT INTO Gravadora (nome) VALUES ('Sony Music');
INSERT INTO Gravadora (nome) VALUES ('Universal Music');
INSERT INTO Gravadora (nome) VALUES ('EMI');
INSERT INTO Gravadora (nome) VALUES ('Som Livre');
INSERT INTO Gravadora (nome) VALUES ('BMG');


-- Artistas:
INSERT INTO Artista (nome, banda, pais) VALUES ('Dave Matthews Band', TRUE, 'EUA');
INSERT INTO Artista (nome, banda, pais) VALUES ('Chico Buarque', FALSE, 'Brasil');
INSERT INTO Artista (nome, banda, pais) VALUES ('Legiao Urbana', TRUE, 'Brasil');
INSERT INTO Artista (nome, banda, pais) VALUES ('Skank', TRUE, 'Brasil');
INSERT INTO Artista (nome, banda, pais) VALUES ('Djavan', FALSE, 'Brasil');
INSERT INTO Artista (nome, banda, pais) VALUES ('Marisa Monte', FALSE, 'Brasil');
INSERT INTO Artista (nome, banda, pais) VALUES ('Zeca Pagodinho', FALSE, 'Brasil');
INSERT INTO Artista (nome, banda, pais) VALUES ('Angela Brandao', FALSE, 'Brasil');

-- CDs:
INSERT INTO CD (idGravadora, idArtista, nome, preco, duplo) VALUES (0, 0, 'Crash', 21.90, FALSE);
INSERT INTO CD (idGravadora, idArtista, nome, preco, duplo) VALUES (1, 1, 'Construcao', 42.90, FALSE);
INSERT INTO CD (idGravadora, idArtista, nome, preco, duplo) VALUES (0, 0, 'Under the Table and Dreaming', 26.90, FALSE);
INSERT INTO CD (idGravadora, idArtista, nome, preco, duplo) VALUES (2, 2, 'Musica para Acampamentos', 45.00, TRUE);
INSERT INTO CD (idArtista, nome, preco, duplo) VALUES (7, 'CD Demo', 15.00, FALSE);
