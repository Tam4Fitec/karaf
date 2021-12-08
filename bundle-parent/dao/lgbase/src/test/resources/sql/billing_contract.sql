DROP TABLE if exists billing_contract;

CREATE TABLE billing_contract (
  contract_code varchar(32) NOT NULL DEFAULT '',
  client_id varchar(20) NOT NULL,
  contract_type varchar(20) NOT NULL,
  create_date date NOT NULL COMMENT 'Date de signature du contrat',
  start_date date DEFAULT NULL COMMENT 'date d activation du contrat',
  end_date date DEFAULT NULL COMMENT 'Date de fin de contrat réelle',
  cancel_date date DEFAULT NULL COMMENT 'date de resiliation du contract (valeur informative et non applicative)',
  pricing_method varchar(20) NOT NULL,
  invoice_lang varchar(2) NOT NULL DEFAULT 'fr',
  contract_status varchar(20) NOT NULL,
  invoice_type varchar(20) NOT NULL DEFAULT 'NONE',
  origin varchar(20) NOT NULL DEFAULT 'UNKNOW',
  PRIMARY KEY (contract_code)
);