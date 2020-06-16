CREATE DATABASE IF NOT EXISTS `simplemall`;

CREATE TABLE IF NOT EXISTS `simplemall`.`user_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL DEFAULT 0,
  `product_id` bigint(20) NOT NULL DEFAULT 0,
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_user_product` (`user_id`, `product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;