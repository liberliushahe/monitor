CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `passWord` varchar(50) NOT NULL DEFAULT '',
  `trueName` varchar(50) NOT NULL DEFAULT '' COMMENT '用户真实姓名或昵称',
  `roleId` varchar(1024) NOT NULL DEFAULT '',
  `roleName` varchar(1024) NOT NULL DEFAULT '',
  `auth` varchar(1024) NOT NULL DEFAULT '',
  `authName` varchar(1024) NOT NULL DEFAULT '',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `sequence` int(11) NOT NULL DEFAULT '0' COMMENT '排序，越大越靠前',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户类型：0普通用户，1：管理员',
  `email` varchar(45) DEFAULT NULL,
  `avatarUrl` varchar(500) NOT NULL DEFAULT '' COMMENT '用户头像',
  `loginType` int(11) NOT NULL DEFAULT '0' COMMENT '0：账号登陆，1：微信登陆',
  `thirdlyId` varchar(100) DEFAULT NULL COMMENT '第三方唯一ID',
   PRIMARY KEY (`id`),
   UNIQUE KEY `loginType_userName` (`userName`,`loginType`),
   UNIQUE KEY `loginType_Email` (`email`,`loginType`),
   KEY `index_thirdlyId` (`thirdlyId`)
) 