DROP TABLE IF EXISTS tb_source_parser;

CREATE TABLE tb_source_parser (
  id_source_parser int(10) NOT NULL AUTO_INCREMENT,
  id_source int(10) NOT NULL,
  sp_navigation varchar(300) NOT NULL,
  sp_index int(10) DEFAULT NULL,
  sp_absolute_index int(10) DEFAULT NULL,
  sp_attr_values varchar(5000) DEFAULT NULL,
  sp_attr_value varchar(25) DEFAULT NULL,
  PRIMARY KEY (id_source_parser)
);

INSERT INTO tb_source_parser VALUES ('2984', '35488', '/catalogue/product/description', '6', '8', NULL, NULL);