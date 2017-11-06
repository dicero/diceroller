# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.6.25)
# Database: dicroller_test
# Generation Time: 2017-11-06 14:44:31 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table t_dpm_inner_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dpm_inner_account`;

CREATE TABLE `t_dpm_inner_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_no` varchar(27) NOT NULL COMMENT '账户',
  `account_title_no` varchar(30) NOT NULL COMMENT '科目',
  `account_name` varchar(20) NOT NULL COMMENT '账户名称',
  `drcr` varchar(2) NOT NULL COMMENT '余额方向;DR-借;CR-贷',
  `balance` decimal(10,8) NOT NULL COMMENT '余额-个',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_no` (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内部账户表';

LOCK TABLES `t_dpm_inner_account` WRITE;
/*!40000 ALTER TABLE `t_dpm_inner_account` DISABLE KEYS */;

INSERT INTO `t_dpm_inner_account` (`id`, `account_no`, `account_title_no`, `account_name`, `drcr`, `balance`, `create_time`, `update_time`)
VALUES
	(1,'1001001','1001','存款-比特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(2,'1001002','1001','存款-莱特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(3,'1002001','1002','管理-比特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(4,'1002002','1002','管理-莱特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(5,'1003011','1003','手续费-入款-比特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(6,'1003012','1003','手续费-出款-莱特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(7,'1003021','1003','手续费-入款-莱特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(8,'1003022','1003','手续费-出款-莱特币','DR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(9,'2001001','2001','客户资金-比特币','CR',0.00000094,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(10,'2001002','2001','客户资金-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(11,'2008001','2008','备付金-比特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(12,'2008002','2008','备付金-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(13,'2020001','2020','结算过渡户-入款-比特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(14,'2020002','2020','结算过渡户-入款-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(15,'2021001','2021','结算过渡户-出款-比特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(16,'2021002','2021','结算过渡户-出款-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(17,'2022001','2022','结算过渡户-退款-比特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(18,'2022002','2022','结算过渡户-退款-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(19,'2023001','2023','结算过渡户-交易-比特币','CR',0.00000006,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(20,'2023002','2023','结算过渡户-交易-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(21,'4001101','4001','待清算-入款待清算-比特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(22,'4001102','4001','待清算-出款待清算-比特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(23,'4001201','4001','待清算-入款待清算-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00'),
	(24,'4001202','4001','待清算-出款待清算-莱特币','CR',0.00000000,'2017-10-30 00:00:00','2017-10-30 00:00:00');

/*!40000 ALTER TABLE `t_dpm_inner_account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_dpm_inner_account_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dpm_inner_account_detail`;

CREATE TABLE `t_dpm_inner_account_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `account_no` varchar(27) NOT NULL COMMENT '账户',
  `txn_amt` decimal(10,8) NOT NULL COMMENT '金额-个',
  `txn_remark` varchar(200) NOT NULL COMMENT '备注',
  `drcr` varchar(2) NOT NULL COMMENT 'DR-借;CR-贷',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `voucher_no` varchar(40) NOT NULL COMMENT '凭证号',
  `before_amt` decimal(10,8) NOT NULL COMMENT '交易前余额-个',
  `after_amt` decimal(10,8) NOT NULL COMMENT '交易后余额-个',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内部账户流水表';

LOCK TABLES `t_dpm_inner_account_detail` WRITE;
/*!40000 ALTER TABLE `t_dpm_inner_account_detail` DISABLE KEYS */;

INSERT INTO `t_dpm_inner_account_detail` (`id`, `create_time`, `update_time`, `account_no`, `txn_amt`, `txn_remark`, `drcr`, `payment_seq_no`, `voucher_no`, `before_amt`, `after_amt`)
VALUES
	(3,'2017-11-04 00:12:47','2017-11-04 00:12:47','2001001',0.00000002,'内场交易记录','DR','P0001711040012480SEQ0072649','CI171104001249068870',0.00000098,0.00000096),
	(4,'2017-11-04 00:12:47','2017-11-04 00:12:47','2023001',0.00000002,'内场交易记录','CR','P0001711040012480SEQ0072649','CI171104001249068870',0.00000002,0.00000004),
	(5,'2017-11-04 00:17:03','2017-11-04 00:17:03','2001001',0.00000002,'内场交易记录','DR','P0001711040017050SEQ0581924','CI171104001706705954',0.00000096,0.00000094),
	(6,'2017-11-04 00:17:03','2017-11-04 00:17:03','2023001',0.00000002,'内场交易记录','CR','P0001711040017050SEQ0581924','CI171104001706705954',0.00000004,0.00000006),
	(7,'2017-11-04 00:18:23','2017-11-04 00:18:23','2001001',0.00000002,'内场交易记录','DR','P0001711040018250SEQ0375221','CI171104001826190411',0.00000094,0.00000092),
	(8,'2017-11-04 00:18:23','2017-11-04 00:18:23','2023001',0.00000002,'内场交易记录','CR','P0001711040018250SEQ0375221','CI171104001826190411',0.00000006,0.00000008),
	(9,'2017-11-04 00:29:02','2017-11-04 00:29:02','2023001',0.00000002,'内场交易记录','DR','P0001711040018250SEQ0375221','CI171104002905536132',0.00000008,0.00000006),
	(10,'2017-11-04 00:29:02','2017-11-04 00:29:02','2001001',0.00000002,'内场交易记录','CR','P0001711040018250SEQ0375221','CI171104002905536132',0.00000092,0.00000094);

/*!40000 ALTER TABLE `t_dpm_inner_account_detail` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_dpm_outer_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dpm_outer_account`;

CREATE TABLE `t_dpm_outer_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_no` varchar(27) NOT NULL COMMENT '账号',
  `account_title_no` varchar(12) NOT NULL COMMENT '科目代码',
  `account_name` varchar(20) NOT NULL COMMENT '账户名称',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `status_map` varchar(1) NOT NULL COMMENT '账户状态,1-可用,2-冻结,3-封号',
  `account_type` varchar(3) NOT NULL COMMENT '账户类型201-比特币户',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_no` (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外部账户表';

LOCK TABLES `t_dpm_outer_account` WRITE;
/*!40000 ALTER TABLE `t_dpm_outer_account` DISABLE KEYS */;

INSERT INTO `t_dpm_outer_account` (`id`, `account_no`, `account_title_no`, `account_name`, `member_id`, `status_map`, `account_type`, `create_time`, `update_time`)
VALUES
	(1,'200100001200000000020010000','10001','清掉',2000000000,'1','201','2017-10-29 15:39:43','2017-10-29 15:39:43'),
	(2,'200100002200000000020010000','10001','清掉',2000000000,'1','201','2017-10-29 15:41:06','2017-10-29 15:41:06'),
	(4,'200100001199999999920010000','10001','清掉',1999999999,'1','201','2017-10-29 15:39:43','2017-10-29 15:39:43'),
	(5,'200100002199999999920010000','10001','清掉',1999999999,'1','201','2017-10-29 15:41:06','2017-10-29 15:41:06');

/*!40000 ALTER TABLE `t_dpm_outer_account` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_dpm_outer_account_detail
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dpm_outer_account_detail`;

CREATE TABLE `t_dpm_outer_account_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `account_no` varchar(27) NOT NULL COMMENT '账户',
  `txn_amt` decimal(10,8) NOT NULL COMMENT '交易金额-个',
  `txn_remark` varchar(200) NOT NULL COMMENT '备注',
  `drcr` varchar(2) NOT NULL COMMENT 'DR-借,CR-贷',
  `voucher_no` varchar(40) NOT NULL COMMENT '凭证号',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `before_amt` decimal(10,8) NOT NULL COMMENT '交易前金额-个',
  `after_amt` decimal(10,8) NOT NULL COMMENT '交易后金额-个',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='外部账户流水表';

LOCK TABLES `t_dpm_outer_account_detail` WRITE;
/*!40000 ALTER TABLE `t_dpm_outer_account_detail` DISABLE KEYS */;

INSERT INTO `t_dpm_outer_account_detail` (`id`, `create_time`, `update_time`, `account_no`, `txn_amt`, `txn_remark`, `drcr`, `voucher_no`, `payment_seq_no`, `before_amt`, `after_amt`)
VALUES
	(1,'2017-11-04 00:12:47','2017-11-04 00:12:47','200100001200000000020010000',0.00000002,'内场交易记录','DR','CO171104001249849591','P0001711040012480SEQ0072649',0.00000003,0.00000001),
	(2,'2017-11-04 00:18:23','2017-11-04 00:18:23','200100001200000000020010000',0.00000002,'内场交易记录','DR','CO171104001826264870','P0001711040018250SEQ0375221',0.00000003,0.00000001),
	(3,'2017-11-04 00:29:02','2017-11-04 00:29:02','200100001199999999920010000',0.00000002,'内场交易记录','DR','CO171104002905876733','P0001711040018250SEQ0375221',0.00000003,0.00000001);

/*!40000 ALTER TABLE `t_dpm_outer_account_detail` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_dpm_outer_account_subset
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_dpm_outer_account_subset`;

CREATE TABLE `t_dpm_outer_account_subset` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标志',
  `account_no` varchar(27) NOT NULL DEFAULT '' COMMENT '账户',
  `balance` decimal(10,8) NOT NULL COMMENT '余额',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账户分户表';

LOCK TABLES `t_dpm_outer_account_subset` WRITE;
/*!40000 ALTER TABLE `t_dpm_outer_account_subset` DISABLE KEYS */;

INSERT INTO `t_dpm_outer_account_subset` (`id`, `create_time`, `update_time`, `member_id`, `account_no`, `balance`, `remark`)
VALUES
	(1,'2017-10-10 00:00:00','2017-10-10 00:00:00',2000000000,'200100001200000000020010000',0.00000001,'xxx-备注'),
	(2,'2017-10-10 00:00:00','2017-10-10 00:00:00',1999999999,'200100001199999999920010000',0.00000001,'xxx-备注');

/*!40000 ALTER TABLE `t_dpm_outer_account_subset` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_tss_payment_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_payment_order`;

CREATE TABLE `t_tss_payment_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `voucher_no` varchar(40) NOT NULL COMMENT '凭证号',
  `amt` decimal(10,8) NOT NULL COMMENT '交易金额-个',
  `status` varchar(20) NOT NULL COMMENT '初始化-init,成功-success,失败-fail',
  `request_no` varchar(40) NOT NULL COMMENT '唯一请求号',
  `member_id` int(11) NOT NULL COMMENT '会员编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付单表';



# Dump of table t_tss_payment_party
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_payment_party`;

CREATE TABLE `t_tss_payment_party` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `party_type` varchar(20) NOT NULL COMMENT '参与方类型,内部户-InnerMember,外部户-OuterMember',
  `account_no` varchar(27) NOT NULL COMMENT '参与方账户',
  `party_memo` varchar(20) NOT NULL COMMENT '参与说明,-手续费账户,-分润账户',
  `amount` decimal(10,8) NOT NULL COMMENT '金额-个',
  `charge_fee` decimal(10,8) NOT NULL COMMENT '费用',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='支付参与方';



# Dump of table t_tss_recharge_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_recharge_order`;

CREATE TABLE `t_tss_recharge_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `request_no` varchar(40) NOT NULL COMMENT '请求号',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值订单表';



# Dump of table t_tss_trade_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_trade_order`;

CREATE TABLE `t_tss_trade_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `trade_voucher_no` varchar(40) NOT NULL COMMENT '凭证号',
  `trade_src_voucher_no` varchar(40) NOT NULL COMMENT '原始凭证号',
  `trade_amount` decimal(10,8) NOT NULL COMMENT '金额-个',
  `buyer_id` int(11) NOT NULL COMMENT '付款方会员标识',
  `buyer_name` varchar(20) NOT NULL COMMENT '付款方名称',
  `buyer_account_no` varchar(27) NOT NULL COMMENT '付款方账户',
  `seller_id` int(11) DEFAULT NULL COMMENT '收款方会员标识',
  `seller_name` varchar(20) DEFAULT '' COMMENT '收款方会员标识',
  `seller_account_no` varchar(27) DEFAULT '' COMMENT '收款方会员标识',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  `status` varchar(20) NOT NULL COMMENT '状态,成功-success,失败-fail,初始化-init',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易订单表';

LOCK TABLES `t_tss_trade_order` WRITE;
/*!40000 ALTER TABLE `t_tss_trade_order` DISABLE KEYS */;

INSERT INTO `t_tss_trade_order` (`id`, `create_time`, `update_time`, `trade_voucher_no`, `trade_src_voucher_no`, `trade_amount`, `buyer_id`, `buyer_name`, `buyer_account_no`, `seller_id`, `seller_name`, `seller_account_no`, `remark`, `status`)
VALUES
	(1,'2017-11-04 00:12:38','2017-11-04 00:12:38','P0001711040012480SEQ0072649','REQ171104001248886186',0.00000002,2000000000,'客户','200100001200000000020010000',1999999999,'平台账户','200100001199999999920010000','交易','init'),
	(2,'2017-11-04 00:16:55','2017-11-04 00:16:55','P0001711040017050SEQ0581924','REQ171104001705817817',0.00000002,2000000000,'客户','200100001200000000020010000',1999999999,'平台账户','200100001199999999920010000','交易','init'),
	(3,'2017-11-04 00:18:14','2017-11-04 00:18:14','P0001711040018250SEQ0375221','REQ171104001825175715',0.00000002,2000000000,'客户','200100001200000000020010000',1999999999,'平台账户','200100001199999999920010000','交易','init'),
	(4,'2017-11-04 00:28:54','2017-11-04 00:28:54','P0001711040029040SEQ0511873','REQ171104002904050482',0.00000002,2000000000,'客户','200100001200000000020010000',1999999999,'平台账户','200100001199999999920010000','交易','init');

/*!40000 ALTER TABLE `t_tss_trade_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table t_tss_trade_service
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_trade_service`;

CREATE TABLE `t_tss_trade_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易指令表';



# Dump of table t_tss_trade_voucher
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_trade_voucher`;

CREATE TABLE `t_tss_trade_voucher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员编号',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `voucher_no` varchar(40) DEFAULT NULL COMMENT '凭证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='凭证表';



# Dump of table t_tss_withdraw_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_tss_withdraw_order`;

CREATE TABLE `t_tss_withdraw_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `address` varchar(40) NOT NULL COMMENT '客户比特币地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提现单表';



# Dump of table tb_audit_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_audit_log`;

CREATE TABLE `tb_audit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `audit_id` int(11) NOT NULL COMMENT '审核单id',
  `audit_type` varchar(20) NOT NULL COMMENT '审核类型',
  `begin_status` varchar(20) NOT NULL COMMENT '审核前状态',
  `end_status` varchar(20) NOT NULL COMMENT '审核后状态',
  `operator` varchar(20) NOT NULL COMMENT '审核人名称',
  `remark` varchar(200) NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核日志记录表';



# Dump of table tb_audit_personal_submit
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_audit_personal_submit`;

CREATE TABLE `tb_audit_personal_submit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `request_no` varchar(40) NOT NULL COMMENT '唯一请求号',
  `audit_type` varchar(20) NOT NULL COMMENT '审核单类型',
  `creator` varchar(20) NOT NULL COMMENT '创建人名称',
  `member_id` int(11) NOT NULL COMMENT '客户标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户提交审核记录表';



# Dump of table tb_audit_sys_submit
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_audit_sys_submit`;

CREATE TABLE `tb_audit_sys_submit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `request_no` varchar(40) NOT NULL COMMENT '唯一请求号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统审核提交记录表';



# Dump of table tb_clearing_order_inner
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_clearing_order_inner`;

CREATE TABLE `tb_clearing_order_inner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `session_id` varchar(40) NOT NULL COMMENT '场次',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '流水号',
  `clearing_code` varchar(20) NOT NULL COMMENT '清算指令',
  `party_role` varchar(20) NOT NULL COMMENT '参与角色payee-付款方,payer-收款方',
  `party_id` varchar(20) NOT NULL COMMENT '参与方OuterMember-外部户,InnerMember-内部户',
  `account_no` varchar(27) NOT NULL COMMENT '账户',
  `drcr` varchar(2) NOT NULL COMMENT 'DR-借,CR-贷',
  `amt` decimal(10,8) NOT NULL COMMENT '金额-个',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清结算内场表';

LOCK TABLES `tb_clearing_order_inner` WRITE;
/*!40000 ALTER TABLE `tb_clearing_order_inner` DISABLE KEYS */;

INSERT INTO `tb_clearing_order_inner` (`id`, `create_time`, `update_time`, `session_id`, `payment_seq_no`, `clearing_code`, `party_role`, `party_id`, `account_no`, `drcr`, `amt`)
VALUES
	(3,'2017-11-04 00:12:47','2017-11-04 00:12:47','CI171104001249068870','P0001711040012480SEQ0072649','1001','payee','InnerMember','2001001','DR',0.00000002),
	(4,'2017-11-04 00:12:47','2017-11-04 00:12:47','CI171104001249068870','P0001711040012480SEQ0072649','1001','payer','InnerMember','2023001','CR',0.00000002),
	(5,'2017-11-04 00:17:03','2017-11-04 00:17:03','CI171104001706705954','P0001711040017050SEQ0581924','1001','payee','InnerMember','2001001','DR',0.00000002),
	(6,'2017-11-04 00:17:03','2017-11-04 00:17:03','CI171104001706705954','P0001711040017050SEQ0581924','1001','payer','InnerMember','2023001','CR',0.00000002),
	(7,'2017-11-04 00:18:23','2017-11-04 00:18:23','CI171104001826190411','P0001711040018250SEQ0375221','1001','payee','InnerMember','2001001','DR',0.00000002),
	(8,'2017-11-04 00:18:23','2017-11-04 00:18:23','CI171104001826190411','P0001711040018250SEQ0375221','1001','payer','InnerMember','2023001','CR',0.00000002),
	(9,'2017-11-04 00:29:02','2017-11-04 00:29:02','CI171104002905536132','P0001711040018250SEQ0375221','1002','payee','InnerMember','2023001','DR',0.00000002),
	(10,'2017-11-04 00:29:02','2017-11-04 00:29:02','CI171104002905536132','P0001711040018250SEQ0375221','1002','payer','InnerMember','2001001','CR',0.00000002);

/*!40000 ALTER TABLE `tb_clearing_order_inner` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_clearing_order_outer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_clearing_order_outer`;

CREATE TABLE `tb_clearing_order_outer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `session_id` varchar(40) NOT NULL COMMENT '场次',
  `party_role` varchar(20) NOT NULL COMMENT '参与角色payee-付款方,payer-收款方',
  `party_id` varchar(20) NOT NULL COMMENT '参与方OuterMember-外部户,InnerMember-内部户',
  `account_no` varchar(27) NOT NULL COMMENT '账户',
  `amt` decimal(10,8) NOT NULL COMMENT '金额',
  `clearing_code` varchar(20) NOT NULL COMMENT '清算指令',
  `payment_seq_no` varchar(27) NOT NULL DEFAULT '' COMMENT '支付流水号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清结算外场表';

LOCK TABLES `tb_clearing_order_outer` WRITE;
/*!40000 ALTER TABLE `tb_clearing_order_outer` DISABLE KEYS */;

INSERT INTO `tb_clearing_order_outer` (`id`, `create_time`, `update_time`, `session_id`, `party_role`, `party_id`, `account_no`, `amt`, `clearing_code`, `payment_seq_no`)
VALUES
	(2,'2017-11-04 00:12:47','2017-11-04 00:12:47','CO171104001249849591','payee','OuterMember','200100001200000000020010000',0.00000002,'1001','P0001711040012480SEQ0072649'),
	(3,'2017-11-04 00:17:03','2017-11-04 00:17:03','CO171104001706566593','payee','OuterMember','200100001200000000020010000',0.00000002,'1001','P0001711040017050SEQ0581924'),
	(4,'2017-11-04 00:18:23','2017-11-04 00:18:23','CO171104001826264870','payee','OuterMember','200100001200000000020010000',0.00000002,'1001','P0001711040018250SEQ0375221'),
	(5,'2017-11-04 00:29:02','2017-11-04 00:29:02','CO171104002905876733','payer','OuterMember','200100001199999999920010000',0.00000002,'1002','P0001711040018250SEQ0375221');

/*!40000 ALTER TABLE `tb_clearing_order_outer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_settlement_carrier
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_settlement_carrier`;

CREATE TABLE `tb_settlement_carrier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `request_no` varchar(40) NOT NULL COMMENT '请求号',
  `payment_seq_no` varchar(40) NOT NULL COMMENT '支付流水号',
  `status` varchar(20) NOT NULL COMMENT '状态：W-待结算；P-结算中；S-结算成功；F-结算失败；',
  `summary` varchar(200) DEFAULT NULL COMMENT '摘要',
  `payment_type` varchar(20) NOT NULL COMMENT 'I-入款,O-出款,T-转账,R-退款到卡,F-退票,B-退款到账户',
  `settlement_type` varchar(20) NOT NULL COMMENT '结算类型,I:内场,O:外场',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清结算载体表';

LOCK TABLES `tb_settlement_carrier` WRITE;
/*!40000 ALTER TABLE `tb_settlement_carrier` DISABLE KEYS */;

INSERT INTO `tb_settlement_carrier` (`id`, `create_time`, `update_time`, `request_no`, `payment_seq_no`, `status`, `summary`, `payment_type`, `settlement_type`)
VALUES
	(3,'2017-11-04 00:12:47','2017-11-04 00:12:47','SId171104001249697588-49343','P0001711040012480SEQ0072649','S','内场结算','B','I'),
	(4,'2017-11-04 00:12:47','2017-11-04 00:12:47','SId171104001249697588-49467','P0001711040012480SEQ0072649','F','外场结算','B','O'),
	(5,'2017-11-04 00:17:03','2017-11-04 00:17:03','SId171104001705175797-06112','P0001711040017050SEQ0581924','S','内场结算','B','I'),
	(6,'2017-11-04 00:17:03','2017-11-04 00:17:03','SId171104001705175797-06321','P0001711040017050SEQ0581924','W','外场结算','B','O'),
	(7,'2017-11-04 00:18:23','2017-11-04 00:18:23','SId171104001826859178-26463','P0001711040018250SEQ0375221','S','内场结算','B','I'),
	(8,'2017-11-04 00:18:23','2017-11-04 00:18:23','SId171104001826859178-26596','P0001711040018250SEQ0375221','F','外场结算','B','O'),
	(9,'2017-11-04 00:29:02','2017-11-04 00:29:02','SId171104001826859178-05101','P0001711040018250SEQ0375221','S','内场结算','B','I'),
	(10,'2017-11-04 00:29:02','2017-11-04 00:29:02','SId171104001826859178-05209','P0001711040018250SEQ0375221','F','外场结算','B','O');

/*!40000 ALTER TABLE `tb_settlement_carrier` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_settlement_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_settlement_order`;

CREATE TABLE `tb_settlement_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `session_id` varchar(40) NOT NULL COMMENT '结算单标识',
  `payment_seq_no` varchar(27) NOT NULL COMMENT '支付流水号',
  `clearing_code_list` varchar(200) DEFAULT '' COMMENT '清结算指令',
  `status` varchar(20) NOT NULL DEFAULT '' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='清结算单表';

LOCK TABLES `tb_settlement_order` WRITE;
/*!40000 ALTER TABLE `tb_settlement_order` DISABLE KEYS */;

INSERT INTO `tb_settlement_order` (`id`, `create_time`, `update_time`, `session_id`, `payment_seq_no`, `clearing_code_list`, `status`)
VALUES
	(1,'2017-11-04 00:12:38','2017-11-04 00:12:38','SId171104001249697588','P0001711040012480SEQ0072649',NULL,'W'),
	(2,'2017-11-04 00:16:55','2017-11-04 00:16:55','SId171104001705175797','P0001711040017050SEQ0581924',NULL,'W'),
	(3,'2017-11-04 00:18:14','2017-11-04 00:18:14','SId171104001826859178','P0001711040018250SEQ0375221','1001|1002','S');

/*!40000 ALTER TABLE `tb_settlement_order` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tb_settlement_session
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tb_settlement_session`;

CREATE TABLE `tb_settlement_session` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='结算单任务表';



# Dump of table tr_personal_advise
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_advise`;

CREATE TABLE `tr_personal_advise` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `email` varchar(20) DEFAULT NULL COMMENT '联系email',
  `content` text NOT NULL COMMENT '内容',
  `readed` int(11) NOT NULL COMMENT '0-未读,1-已读',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户建议反馈表';



# Dump of table tr_personal_bill
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_bill`;

CREATE TABLE `tr_personal_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `trade_type` varchar(2) NOT NULL COMMENT '交易类型R-充值,W-提现,FI-收入,FO-支出',
  `seq_no` varchar(40) NOT NULL COMMENT '流水号',
  `trade_status` varchar(2) NOT NULL COMMENT '交易状态初始化-init, 成功-success,fail-失败',
  `trade_amt` decimal(10,8) NOT NULL COMMENT '交易金额-个',
  `trade_title` varchar(20) NOT NULL COMMENT '账单标题',
  `trade_info` varchar(40) DEFAULT NULL COMMENT '账单说明',
  `bit_address` varchar(40) DEFAULT NULL COMMENT '币地址',
  `stake_id` varchar(40) DEFAULT NULL COMMENT '押注id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户账单流水表';



# Dump of table tr_personal_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_info`;

CREATE TABLE `tr_personal_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `notify_email` varchar(20) DEFAULT NULL COMMENT '客户邮箱',
  `notify_phone` varchar(20) DEFAULT NULL COMMENT '客户联系电话',
  `notify_bit_address` varchar(40) DEFAULT NULL COMMENT '客户币地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息表';



# Dump of table tr_personal_member
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_member`;

CREATE TABLE `tr_personal_member` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户会员id',
  `pwd` varchar(40) DEFAULT NULL COMMENT '密码',
  `member_account` varchar(20) DEFAULT NULL COMMENT '客户登录账号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户会员表';

LOCK TABLES `tr_personal_member` WRITE;
/*!40000 ALTER TABLE `tr_personal_member` DISABLE KEYS */;

INSERT INTO `tr_personal_member` (`member_id`, `pwd`, `member_account`, `create_time`, `update_time`)
VALUES
	(2000000000,'密码','测试登录名','2017-10-10 00:00:00','2017-10-10 00:00:00');

/*!40000 ALTER TABLE `tr_personal_member` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tr_personal_seed
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_seed`;

CREATE TABLE `tr_personal_seed` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标志',
  `seed` varchar(40) NOT NULL COMMENT '种子',
  `default_use` int(11) NOT NULL COMMENT '0-不使用,1-使用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户种子表';



# Dump of table tr_personal_stake
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_stake`;

CREATE TABLE `tr_personal_stake` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标志',
  `fund_type` int(11) DEFAULT NULL COMMENT '1-收入,2-支出',
  `amt` decimal(10,8) NOT NULL COMMENT '金额-个',
  `stake_id` varchar(40) NOT NULL COMMENT '押注id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户押注数据表';



# Dump of table tr_personal_stake_history
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_stake_history`;

CREATE TABLE `tr_personal_stake_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `all_stake_amt` decimal(10,8) NOT NULL COMMENT '总押注金额-个',
  `all_win_amt` decimal(10,8) NOT NULL COMMENT '盈利总金额',
  `all_lose_amt` decimal(10,8) NOT NULL COMMENT '总赔金额-个',
  `all_win_games` int(11) NOT NULL COMMENT '盈利总局数',
  `all_lose_games` int(11) NOT NULL COMMENT '总赔局数',
  `winning_pos` decimal(3,2) NOT NULL COMMENT '胜率',
  `stake_id` varchar(40) NOT NULL COMMENT '押注id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户押注历史数据表';



# Dump of table tr_personal_stake_today
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tr_personal_stake_today`;

CREATE TABLE `tr_personal_stake_today` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `member_id` int(11) NOT NULL COMMENT '会员标识',
  `all_stake_amt` decimal(10,8) NOT NULL COMMENT '今日总押注金额',
  `all_win_amt` decimal(10,8) NOT NULL COMMENT '今日总盈利金额',
  `all_lose_amt` decimal(10,8) NOT NULL COMMENT '今日总赔金额',
  `all_win_games` int(11) NOT NULL COMMENT '今日盈利总局数',
  `all_lose_games` int(11) NOT NULL COMMENT '今日赔总局数',
  `winning_pos` decimal(3,2) NOT NULL COMMENT '今日胜率',
  `cal_date` date NOT NULL COMMENT '时间',
  `stake_id` varchar(40) NOT NULL COMMENT '押注id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户押注日切表';



# Dump of table user_platform
# ------------------------------------------------------------

DROP TABLE IF EXISTS `user_platform`;

CREATE TABLE `user_platform` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `login_username` varchar(50) DEFAULT NULL,
  `login_password` varchar(50) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `role` varchar(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_motify` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_username` (`login_username`),
  UNIQUE KEY `nick_name` (`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_platform` WRITE;
/*!40000 ALTER TABLE `user_platform` DISABLE KEYS */;

INSERT INTO `user_platform` (`id`, `login_username`, `login_password`, `nick_name`, `role`, `gmt_create`, `gmt_motify`)
VALUES
	(1,'zhangsan','39E5A6B8D9E36186E5E1F083BBBD64D8','nickname','SUPER_ADMIN','2017-10-29 14:36:40','2017-10-29 14:36:40'),
	(2,'admin','FFFDE1E68BAEB8DF53C3F5D440D7FC64',NULL,'SUPER_ADMIN','2017-11-05 14:25:35','2017-11-05 14:25:35');

/*!40000 ALTER TABLE `user_platform` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
