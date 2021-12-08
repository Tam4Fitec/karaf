DROP TABLE IF EXISTS rf_condition_operator;

CREATE TABLE rf_condition_operator (
  id_condition_operator int(10) NOT NULL AUTO_INCREMENT,
  cop_name varchar(255) NOT NULL,
  cop_label varchar(100) NOT NULL,
  PRIMARY KEY (id_condition_operator)
  );

  INSERT INTO rf_condition_operator VALUES
  ('1', '=', 'lg_condition_op_egal'),
  ('2', '!=', 'lg_condition_op_different'),
  ('3', '>', 'lg_condition_op_superior'),
  ('4', '<', 'lg_condition_op_inferior'),
  ('5', '>=', 'lg_condition_op_superior_egal'),
  ('6', '<=', 'lg_condition_op_inferior_egal'),
  ('7', 'Contains', 'lg_condition_strpos'),
  ('8', 'Preg match', 'lg_condition_preg_match'),
  ('9', 'Not contains', 'lg_condition_not_strpos');
