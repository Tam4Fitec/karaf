DROP TABLE IF EXISTS tb_shopsite_state_history;

CREATE TABLE tb_shopsite_state_history (
  id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  shi_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  id_shopsite bigint(20) unsigned NOT NULL,
  shi_shop_state int(11) NOT NULL DEFAULT '8',
  shi_patner_enable varchar(1) NOT NULL DEFAULT 'N',
  shi_logo_enable varchar(1) NOT NULL DEFAULT 'N',
  shi_logo_engine_enable varchar(1) NOT NULL DEFAULT 'N',
  shi_product_image_enable varchar(1) NOT NULL DEFAULT 'N',
  shi_dooyoo_enable varchar(1) NOT NULL DEFAULT 'N',
  shi_strategic_enable varchar(1) NOT NULL DEFAULT 'N',
  shi_adult_content varchar(1) NOT NULL DEFAULT 'N',
  shi_segmentation varchar(1) DEFAULT NULL,
  shi_zeus_notation int(11) DEFAULT NULL,
  shi_id_ref_state int(11) DEFAULT NULL,
  shi_reason varchar(50) DEFAULT NULL,
  shi_ksite_flags bigint(20) NOT NULL DEFAULT '0',
  shi_user varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tb_shopsite_state_history VALUES
('9121', '2014-05-18 05:19:01', '2094', '30', 'N', 'Y', 'Y', 'Y', 'N', 'N', 'N', NULL, NULL, '1', NULL, '0', 'capping-partner'),
('14296', '2014-06-03 12:33:08', '2094', '30', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'N', NULL, NULL, '1', NULL, '0', 'it_backoffice')