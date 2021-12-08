CREATE SCHEMA IF NOT EXISTS lgshop;

DROP TABLE IF EXISTS lgshop.tb_shopsite_state;

CREATE TABLE lgshop.tb_shopsite_state (
  id_shopsite bigint(20) unsigned NOT NULL,
  sps_sort tinyint(3) unsigned NOT NULL DEFAULT '3',
  sps_price int(11) NOT NULL DEFAULT '101',
  sps_shop_state int(11) NOT NULL DEFAULT '8',
  sps_type_clic char(1) NOT NULL DEFAULT 'g',
  sps_patner_enable varchar(1) NOT NULL DEFAULT 'N',
  sps_logo_enable varchar(1) NOT NULL DEFAULT 'N',
  sps_logo_engine_enable varchar(1) NOT NULL DEFAULT 'N',
  sps_product_image_enable varchar(1) NOT NULL DEFAULT 'N' COMMENT 'Is product image enable',
  sps_sp_plus varchar(1) NOT NULL DEFAULT 'N',
  sps_adult_content varchar(1) NOT NULL DEFAULT 'N',
  sps_dooyoo_enable varchar(1) NOT NULL DEFAULT 'N',
  sps_strategic_enable varchar(1) NOT NULL DEFAULT 'N',
  sps_internal_enable varchar(1) NOT NULL DEFAULT 'N',
  sps_segmentation char(1) NOT NULL DEFAULT 'D',
  zeus_notation int(11) NOT NULL DEFAULT '1',
  sps_id_ref_state int(11) DEFAULT '19',
  sps_reason varchar(50) DEFAULT NULL,
  ksite_flags bigint(20) DEFAULT '0',
  PRIMARY KEY (id_shopsite),
);

INSERT INTO lgshop.tb_shopsite_state VALUES ('2094', '50', '16', '30', 'p', 'Y', 'Y', 'Y', 'Y', 'N', 'N', 'Y', 'N', 'N', 'A', '10', '1', NULL, '32767');
