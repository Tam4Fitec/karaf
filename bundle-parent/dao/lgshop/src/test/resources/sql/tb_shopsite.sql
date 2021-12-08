DROP TABLE IF EXISTS tb_shopsite;

CREATE TABLE tb_shopsite (
  id_shopsite bigint(20) NOT NULL AUTO_INCREMENT,
  shs_name varchar(255) DEFAULT NULL,
  shs_active char(1) NOT NULL DEFAULT 'Y',
  id_country int(11) NOT NULL,
  shs_main_language int(10) NOT NULL,
  shs_create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  shs_shop_state varchar(20) NOT NULL DEFAULT 'free',
  shs_on_line_publishing_date timestamp NOT NULL DEFAULT '1970-01-01 23:00:00',
  shs_last_update_date timestamp NOT NULL DEFAULT '1970-01-01 23:00:00',
  shs_display_leguide char(1) NOT NULL DEFAULT 'N',
  source varchar(255) DEFAULT 'LEGACY',
  selfcare_date timestamp NOT NULL DEFAULT '1970-01-01 23:00:00',
  contract_signed tinyint(1) DEFAULT NULL,
  esignature tinyint(1) DEFAULT NULL,
  download_date timestamp NULL DEFAULT NULL,
  cgu tinyint(1) NOT NULL DEFAULT '0',
  id_lead varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_shopsite)
);

INSERT INTO tb_shopsite VALUES ('2094', 'La Redoute', 'Y', '1', '1', '2009-04-27 19:00:13', 'client', '2002-06-10 00:00:00',
'2014-08-04 09:56:17', 'Y', 'LEGACY', '2002-06-10 00:00:00', NULL, NULL, NULL, 1, NULL);