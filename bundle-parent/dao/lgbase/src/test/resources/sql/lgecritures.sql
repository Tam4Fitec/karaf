create schema if not exists lgbase;

CREATE TABLE if not exists lgbase.lg_ecritures (
  journal varchar(6) DEFAULT NULL,
  date_comptable date NOT NULL,
  numero_piece int(10) unsigned NOT NULL,
  general varchar(20) NOT NULL,
  auxiliaire varchar(20) NOT NULL,
  debit float4 NOT NULL DEFAULT '0.000',
  credit float4 NOT NULL DEFAULT '0.000',
  ref_interne varchar(50) NOT NULL,
  libelle varchar(50) NOT NULL,
  nature_piece varchar(30) NOT NULL,
  lettrage varchar(5) NOT NULL,
  date_echeance date NOT NULL,
  sens char(1) NOT NULL
);


insert into lgbase.lg_ecritures values ('VTE', '2015-01-01', 1, '41180000', '1000BEBES', 400.0, 0.0, '08070070', '1000BEBES08070070', 'FC', 'AAAA', '2015-02-28', 'D');
insert into lgbase.lg_ecritures values ('BQE', '2015-03-05', 2, '41180000', '1000BEBES', 0.0, 200.0, '08070070', 'Paiment CB', 'RC', 'AAAA', '2015-03-05', 'C');

CREATE TABLE if not exists lg_ecritures (
  journal varchar(6) DEFAULT NULL,
  date_comptable date NOT NULL,
  numero_piece int(10) unsigned NOT NULL,
  general varchar(20) NOT NULL,
  auxiliaire varchar(20) NOT NULL,
  debit float4 NOT NULL DEFAULT '0.000',
  credit float4 NOT NULL DEFAULT '0.000',
  ref_interne varchar(50) NOT NULL,
  libelle varchar(50) NOT NULL,
  nature_piece varchar(30) NOT NULL,
  lettrage varchar(5) NOT NULL,
  date_echeance date NOT NULL,
  sens char(1) NOT NULL
);


insert into lg_ecritures values ('TES', '2015-04-10', 2, '41180000', 'CLIENT_TEST', 0.0, 200.0, '100', 'Paiment CB', 'RC', 'AAAA', '2015-03-05', 'D');
