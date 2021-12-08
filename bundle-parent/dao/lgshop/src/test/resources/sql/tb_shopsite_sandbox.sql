DROP TABLE IF EXISTS tb_shopsite_sandbox;

CREATE TABLE tb_shopsite_sandbox (
  id_shopsite bigint(20) NOT NULL DEFAULT '0',
  id_sand_commercial int(10) NOT NULL,
  id_sand_delivery_zone_update date NOT NULL DEFAULT '2009-01-01',
  id_sand_flag int(5) NOT NULL,
  id_sand_delivery_zone bigint(20) NOT NULL DEFAULT '1',
  id_sand_mantis int(5) NOT NULL DEFAULT '0',
  id_sand_nmediation float NOT NULL,
  id_sand_mediation char(1) NOT NULL DEFAULT 'N',
  id_sand_paynova int(10) NOT NULL DEFAULT '0',
  id_sand_agency int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (id_shopsite)
);

INSERT INTO tb_shopsite_sandbox VALUES ('2094', '2', '2014-09-04', '65527', '17', '34542', '5', 'Y', '0', '0');