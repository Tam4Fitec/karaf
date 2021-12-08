CREATE TABLE brands_grey (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `brand_id` int(10) unsigned DEFAULT NULL,
  `name` varchar(255) DEFAULT '',
  `name_normalized` varchar(250) DEFAULT NULL,
  `is_white_brand` TINYINT NOT NULL DEFAULT 0,
  `insert_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_brands` (`brand_id`),
  UNIQUE KEY `gbr` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE brands_locale_category (
 `grey_id` int(10) unsigned NOT NULL,
 `locale` VARCHAR(5) NOT NULL,
 `id_thes` mediumint(8) unsigned NOT NULL,
 `insert_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`grey_id`, `locale`, `id_thes`),
  CONSTRAINT `fk_grey_1` FOREIGN KEY (`grey_id`) REFERENCES `brands_grey` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


