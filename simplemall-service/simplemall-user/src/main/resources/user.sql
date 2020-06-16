CREATE DATABASE IF NOT EXISTS `simplemall`;

CREATE TABLE IF NOT EXISTS `simplemall`.`user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL DEFAULT '',
  `email` varchar(128) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 08:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `key_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;