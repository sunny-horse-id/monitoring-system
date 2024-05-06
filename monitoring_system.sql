-- 创建 monitoring_system 的数据库结构
DROP DATABASE IF EXISTS `monitoring_system`;
CREATE DATABASE IF NOT EXISTS `monitoring_system`;
USE `monitoring_system`;

-- 创建 表 monitoring_system.user 结构
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `username`    varchar(20) NOT NULL UNIQUE COMMENT '用户名',
    `password`    varchar(32) COMMENT '密码',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `update_time` datetime    NOT NULL COMMENT '修改时间'
) COMMENT '用户表';