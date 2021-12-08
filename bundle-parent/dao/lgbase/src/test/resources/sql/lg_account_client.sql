-- create schema if not exists lgbase;
DROP TABLE if exists lg_account_client;

CREATE TABLE lg_account_client (
  accountid int(11) NOT NULL AUTO_INCREMENT,
  clientid varchar(200) NOT NULL,
  PRIMARY KEY (accountid)
);

insert into lg_account_client(accountid, clientid) values (100, 'CLIENT1');
insert into lg_account_client(accountid, clientid) values (101, 'CLIENT1');
insert into lg_account_client(accountid, clientid) values (200, 'CLIENT2');