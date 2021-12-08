DROP TABLE IF EXISTS billing_contract_store_purchase;

CREATE TABLE billing_contract_store_purchase (
  purchase_id int(11) NOT NULL AUTO_INCREMENT,
  contract_code varchar(32) NOT NULL,
  store_uid int(10) NOT NULL,
  order_id int(10) DEFAULT NULL,
  create_date date NOT NULL,
  amount float(10,3) NOT NULL DEFAULT '0.000',
  cpc float(10,3) NOT NULL DEFAULT '0.000',
  clic_nb int(11) NOT NULL DEFAULT '0',
  invoice_status tinyint(1) NOT NULL DEFAULT '0',
  purchase_type varchar(20) DEFAULT NULL,
  PRIMARY KEY (purchase_id));

insert into billing_contract_store_purchase values(10, 'CLIENT1_CONTRACT', 1000, 1, '2015-04-20 00:00:00', '100', '0.5', '1000', 'SOLDE', '1');