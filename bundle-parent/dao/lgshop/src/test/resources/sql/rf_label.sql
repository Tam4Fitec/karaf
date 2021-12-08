DROP TABLE IF EXISTS rf_label;

CREATE TABLE rf_label (
  lbl_namespace varchar(45) NOT NULL,
  lbl_locale varchar(5) NOT NULL DEFAULT 'fr_FR',
  id_label int(11) NOT NULL DEFAULT '0',
  lbl_label varchar(150) DEFAULT NULL,
  lbl_rank int(11) NOT NULL,
  lbl_enabled char(1) NOT NULL DEFAULT 'N',
  id_lbl bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id_lbl)
);

INSERT INTO rf_label VALUES('payment_card', 'fr_FR', '1', 'American Express', '1', 'Y', '2862');
INSERT INTO rf_label VALUES('payment_card', 'fr_FR', '2', 'Carte Bleue', '2', 'Y', '2863');
INSERT INTO rf_label VALUES('payment_card', 'fr_FR', '3', 'MasterCard', '3', 'Y', '2864');
INSERT INTO rf_label VALUES('payment_card', 'fr_FR', '4', 'Visa', '4', 'Y', '2865');
INSERT INTO rf_label VALUES('payment_card', 'fr_FR', '5', 'Aurore', '5', 'Y', '2866');
INSERT INTO rf_label VALUES('display_lang', 'fr_FR', '1', 'Français', '5', 'Y', '2248');
INSERT INTO rf_label VALUES('companytypes', 'fr_FR', '1', 'SA', '1', 'Y', '130');