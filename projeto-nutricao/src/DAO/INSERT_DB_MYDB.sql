use  mydb;

/*INSERT LOV_NUTRIENTES*/
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Calorias','g');
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Carboidrato','g');
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Proteína','g');
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Sódio','mg');
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Potássio','mg');
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Cálcio','mg');
INSERT INTO lov_nutriente (TEXTO,UNIDADE_MEDIDA) VALUES ('Ferro','mg');


/*INSERT ALIMENTOS*/
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Arroz','O arroz é uma planta da família das gramíneas que alimenta mais da metade da população humana do mundo.','cereal');
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Feijão','Feijão é um nome comum para uma grande variedade de sementes de plantas de alguns gêneros da família Fabaceae. ','leguminosa');
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Frango','O termo frango remete a qualquer prato preparado com a carne de aves como as galinhas.','carne');
INSERT INTO tab_alimento (NOME,DESCRICAO,TIPO) VALUES ('Carne Vermelha','Denomina-se carne vermelha as carnes provenientes dos mamíferos.','carne');



/*INSERT NUTRIENTES DOS ALIMENTOS*/
/*ARROZ*/
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (1,130.0,1);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (2,28.0,1);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (3,2.7,1);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (4,1.0,1);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (5,35.0,1);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (6,10.0,1);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (7,0.2,1);
/*FEIJAO*/
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (1,76.4,2);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (2,13.6,2);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (3,4.8,2);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (4,1.8,2);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (5,254.6,2);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (6,26.6,2);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (7,1.3,2);
/*FRANGO*/
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (1,157.0,3);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (2,0.0,3);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (3,36.0,3);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (4,86.0,3);
/*CARNE VERMELHA*/
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (1,284.4,4);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (2,0.0,4);
INSERT INTO tab_nutriente (LOV_NUTRIENTE_ID,QTD,TAB_ALIMENTO_ID) VALUES (3,16.2,4);





