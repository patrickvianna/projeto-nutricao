use  mydb;

INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Arroz','O arroz é uma planta da família das gramíneas que alimenta mais da metade da população humana do mundo.','cereal');
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Feijão','45g de feijao cru','leguminosa');
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Frango','100g de frango','carne');
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Carne','crua sem gordura','carne');

INSERT INTO lov_nutriente (TEXTO) VALUES ('Calorias');
INSERT INTO lov_nutriente (TEXTO) VALUES ('Carboidrato');
INSERT INTO lov_nutriente (TEXTO) VALUES ('Proteína');
INSERT INTO lov_nutriente (TEXTO) VALUES ('Sódio');
INSERT INTO lov_nutriente (TEXTO) VALUES ('Potássio');
INSERT INTO lov_nutriente (TEXTO) VALUES ('Carboidrato');
INSERT INTO lov_nutriente (TEXTO) VALUES ('Carboidrato');





INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Carboidrato',7.03,1);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Proteína',0.63,1);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Sódio',0.25,1);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Fibra alimentar',0.4,1);

INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Carboidrato',27,2);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Proteína',11,2);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Sódio',5.4,2);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Fibra alimentar',9.6,2);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Cálcio',37,2);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Ferro',3,2);

INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Proteína',20,3);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Sódio',61,3);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Ferro',0.80,3);

INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Proteína',20.8,4);
INSERT INTO tab_nutriente (NOME,QTD,TAB_ALIMENTO_ID) VALUES ('Sódio',50,4);





