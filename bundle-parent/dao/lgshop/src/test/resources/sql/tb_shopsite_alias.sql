DROP TABLE IF EXISTS tb_shopsite_alias;

CREATE TABLE tb_shopsite_alias (
  id_shopsite bigint(20) unsigned NOT NULL,
  alias1 varchar(50) NOT NULL DEFAULT '',
  alias2 varchar(50) NOT NULL DEFAULT '',
  alias3 varchar(50) NOT NULL DEFAULT '',
  alias4 varchar(50) NOT NULL DEFAULT '',
  alias5 varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (id_shopsite)
);

INSERT INTO tb_shopsite_alias VALUES(100, 'alias1', 'alias2', 'alias3', 'alias4', 'alias5');