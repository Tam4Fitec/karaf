DROP TABLE IF EXISTS tb_shopsite_listing;

CREATE TABLE tb_shopsite_listing (
  id_shopsite bigint(20) unsigned NOT NULL,
  shl_general_description varchar(255) DEFAULT NULL,
  shl_details_description text,
  shl_physical_shop varchar(1) NOT NULL DEFAULT 'N',
  shl_physical_shop_referencing int(11) DEFAULT NULL,
  shl_e_commerce_solution varchar(1) NOT NULL DEFAULT 'N',
  shl_e_commerce_solution_referencing int(10) DEFAULT NULL,
  shl_customer_service_phone_number varchar(128) NOT NULL DEFAULT '  ',
  shl_customer_service_fax_number varchar(128) DEFAULT NULL,
  shl_customer_service_email varchar(128) DEFAULT NULL,
  id_language int(11) NOT NULL,
  shl_customer_service_rate varchar(128) DEFAULT NULL,
  shl_customer_service_opening_schedules varchar(150) DEFAULT NULL
);

INSERT INTO tb_shopsite_listing VALUES ('2094', 'La Redoute : portail de la mode et de la déco',
'Le site vous donne accès au catalogue de La Redoute à travers des boutiques thématiques',
'Y', '0', '0', '0', '(33) 0892350353', '03 20 70 25 15', '', '1', NULL, NULL);