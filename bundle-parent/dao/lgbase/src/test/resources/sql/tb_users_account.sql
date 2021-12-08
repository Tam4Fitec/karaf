DROP TABLE IF EXISTS tb_users_account;

CREATE TABLE tb_users_account (
  tb_users_id bigint(20) NOT NULL,
  tb_account_id bigint(20) NOT NULL,
  PRIMARY KEY (tb_users_id,tb_account_id)
);

insert into tb_users_account values(2, 100);
insert into tb_users_account values(10, 100);
insert into tb_users_account values(10, 101);
