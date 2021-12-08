DROP TABLE IF EXISTS tb_users_opt_in_out;

CREATE TABLE tb_users_opt_in_out (
  id_user bigint(20) NOT NULL,
  uso_tips varchar(1) NOT NULL DEFAULT 'N',
  uso_leguide varchar(1) NOT NULL DEFAULT 'N',
  uso_evenement varchar(1) NOT NULL DEFAULT 'N',
  uso_partners varchar(1) NOT NULL DEFAULT 'N',
  uso_stats varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (id_user)
);

insert into tb_users_opt_in_out values(10, 'N', 'N', 'N', 'N', 'N');
