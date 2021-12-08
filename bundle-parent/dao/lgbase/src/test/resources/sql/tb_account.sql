DROP TABLE if exists tb_account;

CREATE TABLE tb_account (
  id_account int(10) NOT NULL AUTO_INCREMENT,
  act_name varchar(45) DEFAULT NULL,
  act_create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id_account)
);

insert into tb_account(id_account, act_name, act_create_date) values(100, 'ACCOUNT1', '2015-04-29');
insert into tb_account(id_account, act_name, act_create_date) values(101, 'ACCOUNT11', '2015-04-30');