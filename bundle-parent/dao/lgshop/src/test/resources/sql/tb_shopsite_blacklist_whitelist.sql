DROP TABLE IF EXISTS tb_shopsite_blacklist_whitelist;

CREATE TABLE tb_shopsite_blacklist_whitelist (
  id_shopsite bigint(20) NOT NULL,
  rf_ksite_id int(10) NOT NULL,
  blacklist_whitelist_state varchar(20) NOT NULL,
  PRIMARY KEY (id_shopsite,rf_ksite_id)
);

INSERT INTO tb_shopsite_blacklist_whitelist VALUES(100, 1, 'WHITELISTED');
INSERT INTO tb_shopsite_blacklist_whitelist VALUES(101, 2, 'BLACKLISTED');