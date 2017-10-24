
-- ----------------------------
-- 后台管理员表
-- ----------------------------
DROP TABLE IF EXISTS `user_platform`;
CREATE TABLE `user_platform` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `login_username` varchar(50) UNIQUE DEFAULT NULL,
  `login_password` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) UNIQUE DEFAULT NULL,
  `role` varchar(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_motify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table user_platform AUTO_INCREMENT=20000000000;
