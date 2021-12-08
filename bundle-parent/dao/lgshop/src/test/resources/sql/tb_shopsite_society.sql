DROP TABLE IF EXISTS tb_shopsite_society;

CREATE TABLE tb_shopsite_society (
  id_shopsite bigint(20) NOT NULL,
  sso_compagny_name varchar(150) NOT NULL,
  sso_adress varchar(255) NOT NULL,
  sso_adress2 varchar(255) DEFAULT NULL,
  sso_zipcode varchar(20) NOT NULL,
  sso_city varchar(45) NOT NULL,
  sso_country int(11) DEFAULT NULL,
  sso_company_phone varchar(128) DEFAULT NULL,
  sso_company_type int(10) DEFAULT NULL,
  sso_other_company_type varchar(255) DEFAULT NULL,
  sso_Sirets_number varchar(25) DEFAULT NULL,
  sso_rcs_number varchar(25) DEFAULT NULL,
  sso_Tva_Intra_number varchar(15) DEFAULT NULL,
  sso_create_date timestamp NOT NULL DEFAULT '2008-12-31 23:00:00',
  sso_update_date timestamp NOT NULL DEFAULT '2008-12-31 23:00:00',
  PRIMARY KEY (id_shopsite)
);

INSERT INTO tb_shopsite_society VALUES ('2094', 'La Redoute', '57, r. de Blanchemaille', '', 'F-59100', 'Roubaix', '1', '(33) 0892350353', '1',
NULL, '477181186', '', '', '2002-06-10 00:00:00', '2009-04-28 04:12:30');