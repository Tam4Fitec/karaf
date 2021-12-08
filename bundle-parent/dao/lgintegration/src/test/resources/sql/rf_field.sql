DROP TABLE IF EXISTS rf_field;

CREATE TABLE rf_field (
  id_field int(10) unsigned NOT NULL AUTO_INCREMENT,
  fld_name varchar(255) NOT NULL,
  fld_label varchar(100) NOT NULL,
  fld_description varchar(255) DEFAULT NULL,
  PRIMARY KEY (id_field)
);

INSERT INTO rf_field VALUES ('1', 'Internal reference', 'id', 'Internal offer reference');
