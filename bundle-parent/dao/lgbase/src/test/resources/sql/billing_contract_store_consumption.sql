DROP TABLE IF EXISTS billing_contract_store_consumption;

CREATE TABLE billing_contract_store_consumption (
  consumption_id int(11) NOT NULL AUTO_INCREMENT,
  contract_code varchar(32) DEFAULT NULL,
  store_uid int(10) NOT NULL,
  consumption_type varchar(20) NOT NULL,
  current_amount double(10) NOT NULL DEFAULT '0.000',
  maximum_amount double(10) NOT NULL DEFAULT '0.000',
  start_date date DEFAULT NULL,
  end_date date DEFAULT NULL,
  create_date date DEFAULT NULL,
  order_id int(10) DEFAULT NULL,
  amount_alert varchar(20) NOT NULL DEFAULT 'NONE',
  PRIMARY KEY (consumption_id)
);

insert into billing_contract_store_consumption values(10, 'CLIENT1_CONTRACT', 1000, 'NOTIMELIMIT', 100, 200, '2015-03-01', '2015-03-31', '2015-03-01', 1, 'NONE');
insert into billing_contract_store_consumption values(11, 'CLIENT1_CONTRACT', 1000, 'NOTIMELIMIT', 100, 200, '2015-04-01', '2015-04-30', '2015-04-01', 1, 'NONE');