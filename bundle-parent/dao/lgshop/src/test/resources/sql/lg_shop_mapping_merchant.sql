CREATE TABLE `mapping_merchant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kk_com_id` int(11) DEFAULT NULL,
  `lg_shop_id` int(11) DEFAULT NULL,
  `kk_merchant_name` varchar(255) DEFAULT NULL,
  `lg_merchant_name` varchar(255) DEFAULT NULL,
  `merchant_lang` varchar(2) NOT NULL,
  `locale` varchar(10) DEFAULT NULL,
  `kk_backfill` varchar(1) NOT NULL DEFAULT 'N',
  `lg_backfill` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`id`)
);