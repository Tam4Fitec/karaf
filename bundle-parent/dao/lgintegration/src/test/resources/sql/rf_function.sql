DROP TABLE IF EXISTS rf_function;

CREATE TABLE rf_function (
  id_function int(10) NOT NULL AUTO_INCREMENT COMMENT 'Function primary key',
  fnc_name varchar(255) NOT NULL COMMENT 'Function name',
  fnc_label varchar(100) NOT NULL COMMENT 'Function label: name of the function, used for programming purpose',
  fnc_description varchar(255) DEFAULT NULL COMMENT 'Function description',
  PRIMARY KEY (id_function)
);

INSERT INTO rf_function VALUES ('2', 'Force', 'lg_force', 'To force at a specific value a field');