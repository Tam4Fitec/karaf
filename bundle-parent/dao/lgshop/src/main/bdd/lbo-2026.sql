use lgshop;

CREATE TABLE `rf_ksite` (
  `id` int(10) unsigned NOT NULL,
  `label` varchar(255) NOT NULL,
  `bit_index` int(10) unsigned NOT NULL,
  `bit_value` bigint(20) NOT NULL,
  `partner_bl_sensitive` TINYINT(1) NOT NULL DEFAULT 0,
  `adult_content_bl_sensitive` TINYINT(1) NOT NULL DEFAULT 1,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_shopsite_blacklist_whitelist` (
  `id_shopsite` bigint(20) unsigned NOT NULL,
  `rf_ksite_id` int(10) unsigned NOT null,
  `blacklist_whitelist_state` ENUM('BLACKLISTED', 'WHITELISTED') NOT NULL,
   PRIMARY KEY (`id_shopsite`, `rf_ksite_id`),
   FOREIGN KEY (`id_shopsite`) REFERENCES tb_shopsite(id_shopsite) ON DELETE CASCADE,
   FOREIGN KEY (`rf_ksite_id`) REFERENCES rf_ksite(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


alter table `tb_shopsite_state` add ksite_flags bigint(20);

insert into `rf_ksite` (`id`, `label`,`bit_index`,`bit_value`,`partner_bl_sensitive`,`adult_content_bl_sensitive`) VALUES
  (1, 'LeGuide.com/Pikengo',        0, 1, 0, 1),
  (2, 'Webmarchand.xx, Gooster.xx', 1, 2, 0, 1),
  (3, 'zeus',                       2, 4, 0, 0),
  (4, 'available',                  3, 8, 0, 0),
  (5, 'Orange',                     4, 16, 1, 1),
  (6, 'windows8',                   5, 32, 0, 1),
  (7, 'choozen',                    6, 64, 0, 1),
  (8, 'bouygues Telecom',           7, 128, 1, 1),
  (9, 'Orange Mobile',              8, 256, 1, 1),
  (10, 'Free',                      9, 512, 1, 1),
  (11, 'SFR Shopping',              10, 1024, 1, 1),
  (12, 'To Define',                 11, 2048, 1, 1),
  (13, 'Generic Partner',           12, 4096, 1, 1),
  (14, 'Available (ex Figaro)',     13, 8192, 1, 1),
  (15, 'Kelkoo',                    14, 16384, 1, 1),
  (16, 'Available',                 15, 32768, 0, 1);

