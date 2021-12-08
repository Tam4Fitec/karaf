DROP TABLE IF EXISTS tb_shopsite_relation_nm;

CREATE TABLE tb_shopsite_relation_nm (
  rf_shopsite_id bigint(20) unsigned NOT NULL,
  rf_label_id bigint(20) unsigned NOT NULL,
  PRIMARY KEY (rf_shopsite_id,rf_label_id)
);

INSERT INTO tb_shopsite_relation_nm VALUES(2094, 0);
INSERT INTO tb_shopsite_relation_nm VALUES(2095, 0);