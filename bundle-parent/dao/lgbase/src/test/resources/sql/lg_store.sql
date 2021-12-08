DROP TABLE IF EXISTS lg_store;

CREATE TABLE lg_store (
  store_uid int(10) NOT NULL AUTO_INCREMENT,
  country char(2) NOT NULL DEFAULT 'fr',
  store_id int(10) NOT NULL DEFAULT 0,
  store_name varchar(128) DEFAULT NULL,
  store_bl_partner_retargeting int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (store_uid)
);

insert into lg_store (store_uid, country, store_id, store_name, store_bl_partner_retargeting) values (1000, 'fr', 1000, 'STORE', 0);