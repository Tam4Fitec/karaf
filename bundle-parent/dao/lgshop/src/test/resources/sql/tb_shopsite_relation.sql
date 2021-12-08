DROP TABLE IF EXISTS tb_shopsite_relation;

CREATE TABLE tb_shopsite_relation (
  id_label int(11) NOT NULL,
  id_shopsite bigint(20) NOT NULL,
  shr_namespace varchar(45) NOT NULL,
  PRIMARY KEY (id_label,id_shopsite,shr_namespace)
);

INSERT INTO tb_shopsite_relation VALUES
('1', '2094', 'command_mode'),
('2', '2094', 'command_mode'),
('3', '2094', 'command_mode'),
('4', '2094', 'command_mode');
