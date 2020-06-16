CREATE DATABASE IF NOT EXISTS `simplemall`;

CREATE TABLE IF NOT EXISTS `simplemall`.`product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(128) NOT NULL DEFAULT '',
  `product_type` varchar(128) NOT NULL DEFAULT '',
  `product_icon` varchar(128) NOT NULL DEFAULT '',
  `product_intro` varchar(128) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_course_name` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
