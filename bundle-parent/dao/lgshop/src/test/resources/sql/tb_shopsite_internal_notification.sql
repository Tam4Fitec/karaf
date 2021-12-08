DROP TABLE IF EXISTS tb_shopsite_internal_notification;

CREATE TABLE tb_shopsite_internal_notification (
  id_shopsite bigint(20) unsigned NOT NULL,
  sin_price float NOT NULL,
  sin_security float NOT NULL,
  sin_service float NOT NULL,
  sin_ergonomic float NOT NULL,
  sin_catalog float NOT NULL,
  sin_note_global float NOT NULL,
  sin_note_comment text,
  sin_leguide_comment text,
  sin_public_comment text,
);

INSERT INTO tb_shopsite_internal_notification VALUES(2094, 5, 5, 5, 5, 5, 5, 'comment', 'comment', 'comment');