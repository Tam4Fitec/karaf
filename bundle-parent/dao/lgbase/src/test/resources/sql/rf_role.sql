DROP TABLE IF EXISTS rf_role;

CREATE TABLE rf_role (
  id_role bigint(20) NOT NULL AUTO_INCREMENT,
  rol_code varchar(45) NOT NULL,
  rol_type varchar(45) NOT NULL DEFAULT 'SITE',
  rol_comment varchar(255) DEFAULT NULL,
  rol_enabled char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY (id_role));

 insert into rf_role values(1, 'ADMIN_SITE', 'SITE', 'COMMENT', 'Y');
 insert into rf_role values(2, 'ADMIN_ACCOUNT', 'ACCOUNT', 'COMMENT', 'Y');