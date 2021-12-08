DROP TABLE IF EXISTS tb_shopsite_catalog;

CREATE TABLE tb_shopsite_catalog (
  id_shopsite bigint(20) unsigned NOT NULL DEFAULT '0',
  shc_mode varchar(20) DEFAULT NULL,
  shc_catalog_url text,
  shc_catalog_ftp varchar(1) NOT NULL DEFAULT 'N',
  shc_ecommerce_id int(11) DEFAULT NULL,
  shc_ecommerce_other varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_shopsite)
);

INSERT INTO tb_shopsite_catalog VALUES ('1', 'ecommerce', '', 'N', '0', '');