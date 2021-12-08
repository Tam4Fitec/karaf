CREATE TABLE if not exists lg_client_group (
  group_id int(11) NOT NULL AUTO_INCREMENT,
  group_label varchar(64) NOT NULL,
  PRIMARY KEY (group_id) USING BTREE
)