CREATE TABLE if not exists lg_client (
  client_id varchar(20) NOT NULL,
  group_id int(11) DEFAULT NULL,
  create_date date DEFAULT NULL,
  is_sage tinyint(1) unsigned NOT NULL DEFAULT '0',
  send_invoice tinyint(3) unsigned NOT NULL DEFAULT '0',
  payment_mean_type varchar(50) DEFAULT NULL,
  PRIMARY KEY (client_id)
);

insert into lg_client (client_id, group_id, create_date, is_sage, send_invoice, payment_mean_type) values ('CLIENT1', 0, now(), 0, 0, 'BANK_CARD');