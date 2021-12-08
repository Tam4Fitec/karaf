DROP TABLE IF EXISTS wm_shopsite;

CREATE TABLE wm_shopsite (
  id_shopsite bigint(20) NOT NULL,
  shs_name varchar(255) DEFAULT NULL,
  shs_active char(1) NOT NULL DEFAULT 'Y',
  id_country int(11) NOT NULL,
  shs_main_language int(10) NOT NULL,
  shs_create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  shs_shop_state varchar(20) DEFAULT 'free',
  id_sand_commercial int(10) DEFAULT NULL,
  id_sand_delivery_zone_update date DEFAULT '2009-01-01',
  id_sand_flag int(5) DEFAULT NULL,
  id_sand_delivery_zone bigint(20) DEFAULT '1',
  id_sand_mantis int(5) DEFAULT '0',
  shu_displayed_url varchar(255) DEFAULT NULL,
  shu_tracked_url varchar(255) DEFAULT NULL,
  shu_logo_url varchar(255) DEFAULT NULL,
  shu_gtsd varchar(255) DEFAULT NULL,
  shu_privacy_notice varchar(255) DEFAULT NULL,
  shc_mode varchar(20) DEFAULT NULL,
  shc_catalog_url varchar(100) DEFAULT NULL,
  shc_catalog_ftp varchar(1) DEFAULT 'N',
  shc_ecommerce_id int(11) DEFAULT NULL,
  shc_ecommerce_other varchar(45) DEFAULT NULL,
  shd_cooling_off_period int(11) DEFAULT NULL,
  shd_applicable_all_products varchar(1) DEFAULT 'N',
  shd_multiple_address varchar(1) DEFAULT 'N',
  shd_multiple_person varchar(1) DEFAULT 'N',
  shd_order_tracking varchar(1) DEFAULT 'N',
  shd_free varchar(1) DEFAULT 'N',
  shd_free_on_over int(11) DEFAULT NULL,
  shd_express varchar(1) DEFAULT 'N',
  shd_wedding_list varchar(1) DEFAULT 'N',
  shd_additional_remarks varchar(255) DEFAULT NULL,
  spp_data_encryption varchar(1) DEFAULT 'N',
  spp_personal_data_shared varchar(1) DEFAULT 'N',
  spp_personal_data_selled varchar(1) DEFAULT 'N',
  spp_authorization_asked varchar(1) DEFAULT 'N',
  spp_gift_wrapping varchar(1) DEFAULT 'N',
  spp_cater_to_individuals varchar(1) DEFAULT 'N',
  spp_cater_to_professionals varchar(1) DEFAULT 'N',
  spp_open_user_accounts varchar(1) DEFAULT 'N',
  spp_loyalty_program varchar(1) DEFAULT 'N',
  sso_compagny_name varchar(150) DEFAULT NULL,
  sso_adress varchar(255) DEFAULT NULL,
  sso_adress2 varchar(255) DEFAULT NULL,
  sso_zipcode varchar(20) DEFAULT NULL,
  sso_city varchar(45) DEFAULT NULL,
  sso_country int(11) DEFAULT NULL,
  sso_company_phone varchar(128) DEFAULT NULL,
  sso_company_type int(10) DEFAULT NULL,
  sso_Sirets_number varchar(25) DEFAULT NULL,
  sso_rcs_number varchar(25) DEFAULT NULL,
  sso_Tva_Intra_number varchar(15) DEFAULT NULL,
  sso_create_date timestamp NOT NULL DEFAULT '2008-12-31 23:00:00',
  sso_update_date timestamp NOT NULL DEFAULT '2008-12-31 23:00:00',
  sps_sort tinyint(3) DEFAULT '3',
  sps_price int(11) DEFAULT '0',
  sps_shop_state int(11) DEFAULT '8',
  sps_type_clic char(1) DEFAULT 'g',
  sps_partner_enable varchar(1) DEFAULT 'N',
  sps_logo_enable varchar(1) DEFAULT 'N',
  sps_logo_engine_enable varchar(1) DEFAULT 'N',
  sps_product_image_enable varchar(1) DEFAULT 'N',
  sps_sp_plus varchar(1) DEFAULT 'N',
  sps_adult_content varchar(1) DEFAULT 'N',
  sps_segmentation char(1) NOT NULL DEFAULT 'D',
  sin_price float DEFAULT NULL,
  sin_security float DEFAULT NULL,
  sin_service float DEFAULT NULL,
  sin_ergonomic float DEFAULT NULL,
  sin_catalog float DEFAULT NULL,
  sin_note_global float DEFAULT NULL,
  sin_note_comment text,
  sin_leguide_comment text,
  shl_general_description varchar(255) DEFAULT NULL,
  shl_details_description text,
  shl_physical_shop varchar(1) DEFAULT 'N',
  shl_physical_shop_referencing int(11) DEFAULT NULL,
  shl_e_commerce_solution varchar(1) DEFAULT 'N',
  shl_e_commerce_solution_referencing int(10) DEFAULT NULL,
  shl_customer_service_phone_number varchar(128) DEFAULT NULL,
  shl_customer_service_fax_number varchar(128) DEFAULT NULL,
  shl_customer_service_email varchar(128) DEFAULT NULL,
  id_sand_nmediation float DEFAULT NULL,
  id_sand_mediation char(1) DEFAULT 'N',
  id_sand_paynova int(10) DEFAULT '0',
  id_sand_agency int(10) DEFAULT '0',
  sin_public_comment text,
  store_id int(10) DEFAULT NULL,
  shs_display_leguide char(1) NOT NULL DEFAULT 'N',
);

INSERT INTO wm_shopsite VALUES ('2094', 'La Redoute', 'Y', '1', '1', '2009-04-27 19:00:13', 'client', '2', '2014-09-04', '65527', '17', '34542',
'http://www.laredoute.fr', 'http://www.laredoute.fr/?cod=33fr12314847', 'http://img.leguide.com/logo_sb/fr/l/logo_248.gif', '', '', 'automatic',
'http://flux.lengow.com/shopbot/leguidecom-group/4914/txt/', 'N', '0', 'NULL', '15', 'N', 'Y', 'Y', 'Y', 'N', '0', 'Y', 'N', '', 'N', 'N', 'N',
'N', 'Y', 'Y', 'N', 'Y', 'Y', 'La Redoute', '57, r. de Blanchemaille', '', 'F-59100', 'Roubaix', '1', '(33) 0892350353', '1', '477181186', '', '',
'2002-06-10 00:00:00', '2009-04-28 04:12:30', '50', '16', '30', 'p', 'Y', 'Y', 'Y', 'Y', 'N', 'N', 'A', '4', '4', '4.5', '4', '5', '4.3',
'', '', '', '', 'Y', '0', '0', '0', '(33) 0892350353', '03 20 70 25 15', '', '5', 'Y', '0', '0',
'', '248', 'Y');