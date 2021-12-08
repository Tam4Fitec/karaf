DROP TABLE IF EXISTS rf_ksite;

CREATE TABLE rf_ksite (
  id int(10) unsigned NOT NULL,
  label varchar(255) NOT NULL,
  bit_index int(10) unsigned NOT NULL,
  bit_value bigint(20) NOT NULL,
  partner_bl_sensitive tinyint(1) NOT NULL DEFAULT '0',
  adult_content_bl_sensitive tinyint(1) NOT NULL DEFAULT '1',
  id_language tinyint(3) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
  );

  INSERT INTO rf_ksite VALUES ('1', 'LeGuide.com/Pikengo', '0', '1', '0', '1', '0');
  INSERT INTO rf_ksite VALUES ('2', 'Webmarchand.xx, Gooster.xx', '1', '2', '0', '1', '0');
  INSERT INTO rf_ksite VALUES ('3', 'zeus', '2', '4', '0', '0', '0');
  INSERT INTO rf_ksite VALUES ('4', 'available', '3', '8', '0', '0', '0');
  INSERT INTO rf_ksite VALUES ('5', 'Orange', '4', '16', '1', '1', '0');


