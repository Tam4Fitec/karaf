DROP TABLE IF EXISTS tb_shopsite_url;

CREATE TABLE tb_shopsite_url (
  id_shopsite bigint(20) unsigned NOT NULL DEFAULT '0',
  shu_displayed_url varchar(255) DEFAULT NULL,
  shu_tracked_url varchar(500) DEFAULT NULL,
  shu_logo_url varchar(255) DEFAULT NULL,
  shu_gtsd varchar(255) DEFAULT NULL,
  shu_privacy_notice varchar(255) DEFAULT NULL,
  shu_status varchar(30) NOT NULL,
  shu_logo_status varchar(20) DEFAULT NULL,
  PRIMARY KEY (id_shopsite)
);

INSERT INTO tb_shopsite_url VALUES ('2094', 'http://www.laredoute.fr', 'http://www.laredoute.fr/?cod=33fr12314847',
'http://img.leguide.com/logo_sb/fr/l/logo_248.gif', '', '', 'NEW', NULL);
