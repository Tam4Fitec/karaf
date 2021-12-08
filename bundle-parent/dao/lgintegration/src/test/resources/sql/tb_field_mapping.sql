DROP TABLE IF EXISTS tb_field_mapping;

CREATE TABLE tb_field_mapping (
  fmp_map_value text,
  id_source int(10) NOT NULL,
  id_field int(10) NOT NULL,
  id_mapping_function int(10) NOT NULL DEFAULT '1',
  PRIMARY KEY (id_source,id_field)
);

INSERT INTO tb_field_mapping VALUES ('6', '35488', '1', '1');