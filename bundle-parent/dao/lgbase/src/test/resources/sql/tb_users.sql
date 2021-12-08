DROP TABLE IF EXISTS tb_users;

CREATE TABLE tb_users (
  id_user bigint(20) NOT NULL AUTO_INCREMENT,
  usr_email varchar(255) NOT NULL,
  usr_password varchar(32) NOT NULL,
  usr_civility tinyint(4) NOT NULL DEFAULT '0',
  usr_firstname varchar(32) NOT NULL DEFAULT '',
  usr_lastname varchar(32) NOT NULL DEFAULT '',
  usr_phone_number varchar(32) DEFAULT NULL,
  usr_mobile_number varchar(32) DEFAULT NULL,
  usr_fax_number varchar(32) DEFAULT NULL,
  usr_service_id int(10) DEFAULT '0',
  usr_function_id int(10) DEFAULT '0',
  usr_other_service varchar(255) DEFAULT NULL,
  usr_other_function varchar(255) DEFAULT NULL,
  usr_status varchar(20) NOT NULL DEFAULT 'AUTO',
  usr_create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  usr_last_login timestamp NOT NULL DEFAULT '1970-01-01 23:00:00',
  usr_add_date timestamp NOT NULL DEFAULT '1970-01-01 23:00:00',
  usr_main_language varchar(5) NOT NULL DEFAULT 'fr_FR',
  opt_out_token_partner varchar(255) DEFAULT NULL,
  opt_out_token_leguide varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_user)
);

insert into tb_users values (1, 'user99@leguide.com', 'test', 0, 'first', 'last', '0000', '0000', '0000', '0', '0', null, null, 'AUTO', '2015-04-20 01:00:00', '2015-04-20 01:00:00',
'2015-04-20 01:00:00', 'fr_FR', '784aabd331b82caae49295fa9e8dbc5b4fd3256cb5a5812a671ea1304cd7ad54', '31c471462d8169a788fa7b6e707a79dbda3e7f7c2ab40c41b4bbb5d5157ef8bd');
insert into tb_users values (2, 'user2@leguide.com', 'test', 0, 'first', 'last', '0000', '0000', '0000', '0', '0', null, null, 'AUTO', '2015-04-20 01:00:00', '2015-04-20 01:00:00',
'2015-04-20 01:00:00', 'fr_FR', '816c5f665e2c854705fb5250a9bc64cc2fef3160817deb2971cc915ee5810271', '17853aa3d905d17ee58e9109fee35677d9a9e03c4f1c30f47c7d5961dd20a46a');
insert into tb_users values (10, 'user@leguide.com', 'test', 0, 'first', 'last', '0000', '0000', '0000', '0', '0', null, null, 'AUTO', '2015-04-20 01:00:00', '2015-04-20 01:00:00',
'2015-04-20 01:00:00', 'fr_FR', '7c789d19430128cc172c45fc128c2d769acf9a3b38f38e970c91438b67257f83', '275604720ffb72f1ac54d4340fc524756fdb5da389d8c35e444ad03a6ee12685');
