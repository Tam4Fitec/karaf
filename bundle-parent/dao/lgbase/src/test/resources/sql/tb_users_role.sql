DROP TABLE IF EXISTS tb_users_role;

CREATE TABLE tb_users_role (
  user_uid bigint(20) NOT NULL,
  role_uid bigint(20) NOT NULL,
  entity_uid bigint(20) NOT NULL,
  PRIMARY KEY (user_uid,role_uid,entity_uid)
);

insert into tb_users_role values(1, 1, 1000);
insert into tb_users_role values(1, 2, 100);
insert into tb_users_role values(10, 1, 1000);
