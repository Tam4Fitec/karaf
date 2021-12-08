DROP TABLE IF EXISTS rf_country;

CREATE TABLE rf_country (
  id_country smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT 'country primary key',
  cty_name varchar(30) NOT NULL,
  cty_alpha2_code char(2) NOT NULL,
  cty_alpha3_code char(3) DEFAULT NULL,
  cty_vat decimal(5,2) DEFAULT NULL,
  cty_conversion decimal(5,2) DEFAULT NULL,
  cty_currency char(3) DEFAULT NULL,
  cty_internal_number tinyint(3) unsigned DEFAULT NULL,
  cty_leguide_country char(1) DEFAULT NULL,
  cty_time_zone varchar(64) NOT NULL DEFAULT '+00:00',
  PRIMARY KEY (id_country),
);

INSERT INTO rf_country (id_country, cty_name, cty_alpha2_code, cty_alpha3_code, cty_vat, cty_conversion, cty_currency,
cty_internal_number, cty_leguide_country, cty_time_zone) VALUES('250', 'France', 'FR', 'FRA', '19.60', '1.00', 'EUR', '1', '1', 'Europe/Paris');