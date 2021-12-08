DROP TABLE IF EXISTS tb_source_function;

CREATE TABLE tb_source_function (
  id_source_function int(10) NOT NULL AUTO_INCREMENT,
  sfn_param_1 text,
  sfn_param_2 text,
  sfn_order int(3) NOT NULL DEFAULT '0',
  sfn_active char(1) NOT NULL DEFAULT 'Y',
  id_source int(10) NOT NULL,
  id_function int(10) NOT NULL,
  id_field int(10) NOT NULL,
  id_merchant_field int(3) NOT NULL DEFAULT '-1',
  sfn_condition_active char(1) NOT NULL DEFAULT 'N',
  sfn_condition_id_field_1 int(10) NOT NULL DEFAULT '1',
  id_condition_operator int(10) NOT NULL DEFAULT '1',
  sfn_condition_field_type varchar(1) NOT NULL DEFAULT '0',
  sfn_condition_id_field_2 int(10) NOT NULL DEFAULT '1',
  sfn_condition_param_2 text NOT NULL,
  PRIMARY KEY (id_source_function)
);

INSERT INTO tb_source_function VALUES ('1212', 'EUR', '', '1', 'Y', '35488', '2', '1', '-1', 'N', '1', '1', '0', '1', '');