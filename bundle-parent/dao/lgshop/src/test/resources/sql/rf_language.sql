DROP TABLE IF EXISTS rf_language;

CREATE TABLE rf_language (
  id_language tinyint(3),
  localename char(5) NOT NULL,
  language char(2) NOT NULL,
  country char(2) NOT NULL,
  encoding varchar(32) DEFAULT NULL,
  mimecharset varchar(32) DEFAULT NULL,
  PRIMARY KEY (id_language,localename)
);

INSERT INTO rf_language(id_language, localename, language, country, encoding, mimecharset) VALUES ('1', 'fr_BE', 'fr', 'BE', 'utf8', NULL);
INSERT INTO rf_language(id_language, localename, language, country, encoding, mimecharset) VALUES ('1', 'fr_CH', 'fr', 'CH', 'utf8', NULL);
INSERT INTO rf_language(id_language, localename, language, country, encoding, mimecharset) VALUES ('1', 'fr_FR', 'fr', 'FR', 'utf8', NULL);
INSERT INTO rf_language(id_language, localename, language, country, encoding, mimecharset) VALUES ('1', 'fr_LU', 'fr', 'LU', 'utf8', NULL);
INSERT INTO rf_language(id_language, localename, language, country, encoding, mimecharset) VALUES ('2', 'es_ES', 'es', 'ES', 'utf8', NULL);
