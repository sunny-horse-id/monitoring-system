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

-- 创建 表 monitoring_system.log 结构
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`
(
    `id`               int UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `occurrence_time`  datetime     NOT NULL COMMENT '发生时间',
    `occurrence_place` varchar(40)  NOT NULL COMMENT '发生位置',
    `content`          varchar(256) NOT NULL COMMENT '故障内容',
    `type`             int          NOT NULL COMMENT '故障类型 0 故障 1 事故'
) COMMENT '故障信息表';

# 插入故障信息
INSERT INTO `log`
VALUES (1, '2023-01-01 08:32:19', '制氢侧', '氢气压力过高', 0);
INSERT INTO `log`
VALUES (2, '2023-01-31 08:32:19', '发电侧', '装置剧烈抖动', 0);
INSERT INTO `log`
VALUES (3, '2023-03-02 06:55:01', '储能侧', '电压过低', 0);
INSERT INTO `log`
VALUES (4, '2023-04-19 12:21:09', '储能侧', '电压过高', 0);
INSERT INTO `log`
VALUES (5, '2023-06-12 15:33:11', '制氢侧', '氢气压力过低', 0);
INSERT INTO `log`
VALUES (6, '2023-07-19 17:44:05', '发电侧', '流体PH过高', 0);
# 插入事故信息
INSERT INTO `log`
VALUES (7, '2023-4-30 12:43:05', '制氢侧', '储气罐泄露', 1);