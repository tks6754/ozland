## 初始化数据库

CREATE DATABASE IF NOT EXISTS mybatisdb default charset utf8 COLLATE utf8_general_ci;

use mybatisdb;

CREATE  TABLE IF NOT EXISTS `user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_no` varchar(32) NOT NULL,
  `account_no` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

