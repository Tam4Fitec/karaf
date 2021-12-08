DROP TABLE IF EXISTS tb_catalog;

CREATE TABLE tb_catalog (
  id_catalog int(10) NOT NULL AUTO_INCREMENT,
  ctg_version varchar(6) DEFAULT '2.0',
  ctg_active char(1) NOT NULL DEFAULT 'Y',
  ctg_last_launch datetime DEFAULT NULL,
  ctg_end_processing datetime DEFAULT NULL,
  ctg_offers_count int(10) NOT NULL DEFAULT '0',
  ctg_categories_count int(10) NOT NULL DEFAULT '0',
  ctg_online_count int(10) NOT NULL DEFAULT '0',
  ctg_normalized char(1) NOT NULL DEFAULT 'N',
  ctg_state tinyint(3) DEFAULT NULL,
  ctg_backups_count tinyint(3) NOT NULL DEFAULT '1',
  ctg_to_categorize_count int(10) NOT NULL DEFAULT '0',
  id_shopsite bigint(20) NOT NULL,
  ctg_completeness float(6) NOT NULL DEFAULT '0.0000',
  ctg_validation_date datetime DEFAULT NULL,
  src_command text,
  src_command_active char(1) DEFAULT '0',
  ctg_last_valid_src datetime DEFAULT NULL,
  PRIMARY KEY (id_catalog)
);

INSERT INTO tb_catalog VALUES ('24901', '2.0', 'Y', '2015-05-11 03:00:01', '2015-05-11 01:00:49', '18197', '627',
'18302', 'N', '3', '1', '2', '2094', '2.3452', '2013-10-17 15:46:21', NULL, '0', NULL);