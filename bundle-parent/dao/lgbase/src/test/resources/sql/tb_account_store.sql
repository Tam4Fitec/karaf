DROP TABLE IF EXISTS tb_account_store;
CREATE TABLE tb_account_store (
  account_uid mediumint(10) NOT NULL,
  store_uid int(10) unsigned NOT NULL,
  PRIMARY KEY (account_uid,store_uid)
);

insert into tb_account_store(account_uid, store_uid) values(100, 1000);
insert into tb_account_store(account_uid, store_uid) values(100, 1001);
insert into tb_account_store(account_uid, store_uid) values(999, 9999);