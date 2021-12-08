DROP TABLE IF EXISTS tb_shopsite_privacy_policy;

CREATE TABLE tb_shopsite_privacy_policy (
  id_shopsite bigint(20) unsigned NOT NULL,
  spp_data_encryption varchar(1) DEFAULT 'N',
  spp_personal_data_shared varchar(1) DEFAULT 'N',
  spp_personal_data_selled varchar(1) DEFAULT 'N',
  spp_authorization_asked varchar(1) DEFAULT 'N',
  spp_gift_wrapping varchar(1) DEFAULT 'N',
  spp_cater_to_individuals varchar(1) DEFAULT 'N',
  spp_cater_to_professionals varchar(1) DEFAULT 'N',
  spp_open_user_accounts varchar(1) DEFAULT 'N',
  spp_loyalty_program varchar(1) DEFAULT 'N',
  spp_security_protocol_other varchar(60) DEFAULT NULL,
  spp_quality_labelling_other varchar(60) DEFAULT NULL,
  spp_order_without_user_account varchar(1) DEFAULT NULL,
  spp_systematic_garantee_on_products varchar(1) DEFAULT NULL,
  spp_systematic_garantee_on_products_infos varchar(150) DEFAULT NULL,
  spp_mobile_friendly varchar(1) DEFAULT 'N',
);

INSERT INTO tb_shopsite_privacy_policy VALUES ('2094', 'N', 'N', 'N', 'N', 'Y', 'Y', 'N', 'Y', 'Y', NULL, NULL, NULL, NULL, NULL, 'Y');
