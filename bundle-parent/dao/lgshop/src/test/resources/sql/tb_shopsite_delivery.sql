DROP TABLE IF EXISTS tb_shopsite_delivery;

CREATE TABLE tb_shopsite_delivery (
  id_shopsite bigint(20) NOT NULL,
  shd_cooling_off_period int(11) NOT NULL,
  shd_applicable_all_products varchar(1) NOT NULL DEFAULT 'N',
  shd_multiple_address varchar(1) NOT NULL DEFAULT 'N',
  shd_multiple_person varchar(1) NOT NULL DEFAULT 'N',
  shd_order_tracking varchar(1) NOT NULL DEFAULT 'N',
  shd_free varchar(1) NOT NULL DEFAULT 'N',
  shd_free_on_over int(11) DEFAULT NULL,
  shd_express varchar(1) NOT NULL DEFAULT 'N',
  shd_wedding_list varchar(1) NOT NULL DEFAULT 'N',
  shd_additional_remarks varchar(255) DEFAULT NULL,
  shd_command_phone_number varchar(128) DEFAULT NULL,
  shd_payment_mode_other varchar(60) DEFAULT NULL,
  shd_store_card varchar(1) DEFAULT NULL,
  shd_store_card_info varchar(128) DEFAULT NULL,
  shd_interest_free_credit varchar(1) DEFAULT NULL,
  shd_interest_free_credit_info varchar(255) DEFAULT NULL,
  shd_delivery_mode_other varchar(60) DEFAULT NULL,
  shd_pick_up_point varchar(1) DEFAULT NULL,
  shd_pick_up_point_other varchar(128) DEFAULT NULL,
  shd_payment_when_sent varchar(1) DEFAULT NULL,
  shd_payment_after_client_checking varchar(1) DEFAULT NULL,
  shd_home_installation varchar(1) DEFAULT NULL,
  shd_previous_material_removal varchar(1) DEFAULT NULL,
  shd_home_repairs varchar(1) DEFAULT NULL,
  shd_in_store_pick_up varchar(1) DEFAULT NULL,
  shd_in_store_pick_up_from varchar(5) DEFAULT NULL,
  shd_in_store_pick_up_infos varchar(150) DEFAULT NULL,
  PRIMARY KEY (id_shopsite),
);

INSERT INTO tb_shopsite_delivery(id_shopsite, shd_cooling_off_period, shd_applicable_all_products, shd_multiple_address, shd_multiple_person,
shd_order_tracking, shd_free, shd_free_on_over, shd_express, shd_wedding_list, shd_additional_remarks, shd_command_phone_number, shd_payment_mode_other,
shd_store_card, shd_store_card_info, shd_interest_free_credit, shd_interest_free_credit_info, shd_delivery_mode_other, shd_pick_up_point, shd_pick_up_point_other,
shd_payment_when_sent, shd_payment_after_client_checking, shd_home_installation, shd_previous_material_removal, shd_home_repairs, shd_in_store_pick_up,
shd_in_store_pick_up_from, shd_in_store_pick_up_infos) VALUES ('2094', '15', 'N', 'Y', 'Y', 'Y', 'N', '0', 'Y', 'N', '',
NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Y', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);