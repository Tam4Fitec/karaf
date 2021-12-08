DROP TABLE IF EXISTS billing_invoice;

CREATE TABLE billing_invoice (
  invoice_code varchar(32) NOT NULL,
  client_id varchar(20) NOT NULL,
  xml varchar(20),
  create_date date DEFAULT NULL,
  invoice_status varchar(20) NOT NULL,
  invoice_date date NOT NULL,
  amount_net double(10) NOT NULL DEFAULT '0.00',
  amount_with_tax double(10) NOT NULL DEFAULT '0.00',
  clic_nb int(10) NOT NULL DEFAULT '0',
  amount_cpc_net float(10) NOT NULL DEFAULT '0.000',
  payment_status varchar(20) NOT NULL DEFAULT 'STANDBY',
  PRIMARY KEY (invoice_code));

insert into billing_invoice values('100', 'CLIENT1', 'XML', '2015-04-20', 'SAVED', '2015-04-20', 100.00, 110.00, 1000, 100.00, 'STANDBY');
insert into billing_invoice values('200', 'CLIENT1', 'XML', '2015-04-20', 'SAVED', '2015-04-20', 100.00, 110.00, 1000, 100.00, 'STANDBY');
insert into billing_invoice values('300', 'CLIENT2', 'XML', '2015-04-20', 'SAVED', '2015-04-20', 100.00, 110.00, 1000, 100.00, 'STANDBY');