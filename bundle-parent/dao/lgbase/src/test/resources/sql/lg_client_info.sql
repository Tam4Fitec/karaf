CREATE TABLE if not exists lg_client_info (
  client_id varchar(20) NOT NULL,
  heading varchar(35) DEFAULT NULL,
  address1 varchar(35) DEFAULT NULL,
  address2 varchar(35) DEFAULT NULL,
  city varchar(35) DEFAULT NULL,
  country varchar(35) DEFAULT NULL,
  zip_code varchar(9) DEFAULT NULL,
  intra_community_id varchar(25) DEFAULT NULL,
  PRIMARY KEY (client_id),
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
