/*
 Navicat Premium Data Transfer

 Source Server         : gjw-mysql
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : syl-blog

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 07/10/2019 15:43:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user`
(
    `admin_user_id`   int(11)                                                NOT NULL AUTO_INCREMENT COMMENT '管理员id',
    `login_user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆名称',
    `login_password`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登陆密码',
    `nick_name`       varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员显示昵称',
    `locked`          tinyint(4)                                             NULL DEFAULT 0 COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
    PRIMARY KEY (`admin_user_id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tb_admin_user
-- ----------------------------
INSERT INTO `tb_admin_user`
VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'gjw', 0);

SET FOREIGN_KEY_CHECKS = 1;

/*Table structure for table `tb_blog_category` */

CREATE TABLE `tb_blog_category`
(
    `category_id`   int(11)     NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
    `category_name` varchar(50) NOT NULL COMMENT '分类的名称',
    `category_icon` varchar(50) NOT NULL COMMENT '分类的图标',
    `category_rank` int(11)     NOT NULL DEFAULT '1' COMMENT '分类的排序值 被使用的越多数值越大',
    `is_deleted`    tinyint(4)  NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
    `create_time`   datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`category_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `tb_blog_tag`;

CREATE TABLE `tb_blog_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
  `tag_name` varchar(100) NOT NULL COMMENT '标签名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tb_blog_tag_relation`;

CREATE TABLE `tb_blog_tag_relation` (
  `relation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `blog_id` bigint(20) NOT NULL COMMENT '博客id',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
