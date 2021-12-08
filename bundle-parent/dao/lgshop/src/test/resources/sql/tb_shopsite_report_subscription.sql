DROP TABLE IF EXISTS tb_shopsite_report_subscription;

CREATE TABLE tb_shopsite_report_subscription (
  id_subscription int(10) NOT NULL AUTO_INCREMENT,
  id_shopsite int(11) NOT NULL,
  contact_email varchar(50) NOT NULL,
  period varchar(10) NOT NULL,
  minute_of_day int(4) NOT NULL,
  day varchar(1) DEFAULT NULL,
  report_type varchar(20) DEFAULT NULL,
  complementary varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_subscription)
);

INSERT INTO tb_shopsite_report_subscription VALUES ('1', '2094', 'test@redoute.fr', 'day', '600', '', 'STATSCLICKS', '');
INSERT INTO tb_shopsite_report_subscription VALUES ('2', '2094', 'test2@redoute.fr', 'day', '996', '', 'PURCHASE', '');
INSERT INTO tb_shopsite_report_subscription VALUES ('3', '2094', 'test@redoute.fr', 'week', '600', '2', 'STATSCLICKS', '');
INSERT INTO tb_shopsite_report_subscription VALUES ('4', '2094', 'test2@redoute.fr', 'week', '996', '2', 'PURCHASE', '');
INSERT INTO tb_shopsite_report_subscription VALUES ('5', '1000', 'test@company1.fr', 'week', '996', '2', 'PRICING_MATCHING', '');
INSERT INTO tb_shopsite_report_subscription VALUES ('6', '2000', 'test@company2.fr', 'week', '996', '2', 'PRICING_MATCHING', '');
INSERT INTO tb_shopsite_report_subscription VALUES ('7', '3000', 'test@company3.fr', 'week', '996', '2', 'PRICING_MATCHING', '');

CREATE TABLE lgbase.pricing_subscription (
  ps_id bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  ps_shopsite_id bigint(20) NOT NULL,
  ps_start_user_email varchar(254) NOT NULL,
  ps_start_date date NOT NULL,
  ps_end_user_email varchar(254) DEFAULT NULL,
  ps_end_date date DEFAULT NULL,
  ps_type varchar(20) NOT NULL,
  PRIMARY KEY (ps_id)
);
INSERT INTO lgbase.pricing_subscription VALUES(1, '1000', 'test@company1.fr', '2016-01-01', 'test@company1.fr', '2016-01-31', 'BASICPI');
INSERT INTO lgbase.pricing_subscription VALUES(2, '2000', 'test@company2.fr', '2016-01-01', null, null, 'BASICPI');
INSERT INTO lgbase.pricing_subscription VALUES(3, '3000', 'test@company3.fr', '2016-01-01', 'test@company3.fr', '2016-03-31', 'BASICPI');