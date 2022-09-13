-- 创建订单数据库
CREATE DATABASE seata_order;
-- 创建库存数据库
CREATE DATABASE seata_storage;
-- 创建账户数据库
CREATE DATABASE seata_account;


-- 订单数据库中，创建订单表

use seata_order;

CREATE TABLE t_order (
                         `id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `user_id` BIGINT(11) DEFAULT NULL COMMENT '用户id',
                         `product_id` BIGINT(11) DEFAULT NULL COMMENT '产品id',
                         `count` INT(11) DEFAULT NULL COMMENT '数量',
                         `money` DECIMAL(11,0) DEFAULT NULL COMMENT '金额',
                         `status` INT(1) DEFAULT NULL COMMENT '订单状态：0：创建中；1：已完结'
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- 库存数据库中创建库存表
use seata_storage;

CREATE TABLE t_storage (
                           `id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
                           `product_id` BIGINT(11) DEFAULT NULL COMMENT '产品id',
                           `total` INT(11) DEFAULT NULL COMMENT '总库存',
                           `used` INT(11) DEFAULT NULL COMMENT '已用库存',
                           `residue` INT(11) DEFAULT NULL COMMENT '剩余库存'
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



INSERT INTO seata_storage.t_storage(`id`, `product_id`, `total`, `used`, `residue`)
VALUES ('1', '1', '100', '0', '100');

-- 账户数据库中创建 账户表
use seata_account;

CREATE TABLE t_account (
                           `id` BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',
                           `user_id` BIGINT(11) DEFAULT NULL COMMENT '用户id',
                           `total` DECIMAL(10,0) DEFAULT NULL COMMENT '总额度',
                           `used` DECIMAL(10,0) DEFAULT NULL COMMENT '已用余额',
                           `residue` DECIMAL(10,0) DEFAULT '0' COMMENT '剩余可用额度'
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO seata_account.t_account(`id`, `user_id`, `total`, `used`, `residue`)  VALUES ('1', '1', '1000', '0', '1000');


-- 每个数据库中，都要有 回滚日志表

use seata_order;

CREATE TABLE `undo_log` (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` BIGINT(20) NOT NULL,
                            `xid` VARCHAR(100) NOT NULL,
                            `context` VARCHAR(128) NOT NULL,
                            `rollback_info` LONGBLOB NOT NULL,
                            `log_status` INT(11) NOT NULL,
                            `log_created` DATETIME NOT NULL,
                            `log_modified` DATETIME NOT NULL,
                            `ext` VARCHAR(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


use seata_storage;

CREATE TABLE `undo_log` (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` BIGINT(20) NOT NULL,
                            `xid` VARCHAR(100) NOT NULL,
                            `context` VARCHAR(128) NOT NULL,
                            `rollback_info` LONGBLOB NOT NULL,
                            `log_status` INT(11) NOT NULL,
                            `log_created` DATETIME NOT NULL,
                            `log_modified` DATETIME NOT NULL,
                            `ext` VARCHAR(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



use seata_order;


CREATE TABLE `undo_log` (
                            `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                            `branch_id` BIGINT(20) NOT NULL,
                            `xid` VARCHAR(100) NOT NULL,
                            `context` VARCHAR(128) NOT NULL,
                            `rollback_info` LONGBLOB NOT NULL,
                            `log_status` INT(11) NOT NULL,
                            `log_created` DATETIME NOT NULL,
                            `log_modified` DATETIME NOT NULL,
                            `ext` VARCHAR(100) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
