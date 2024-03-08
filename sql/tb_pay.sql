-- ----------------------------
-- Table structure for tb_pay
-- ----------------------------
DROP TABLE IF EXISTS `tb_pay`;
CREATE TABLE `tb_pay`  (
                           `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                           `pay_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '支付流水号',
                           `order_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单流水号',
                           `user_id` bigint(0) NULL DEFAULT 1 COMMENT '用户id',
                           `amount` decimal(10, 2) NOT NULL DEFAULT 9.90 COMMENT '交易金额',
                           `deleted` tinyint(0) UNSIGNED NULL DEFAULT 0 COMMENT '删除标识 0：不删除，1：删除',
                           `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
                           `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '支付表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_pay
-- ----------------------------
INSERT INTO `tb_pay` VALUES (7, 'pay20240308001', 'pay202403080021001', 1, 29.90, 0, '2024-03-08 01:01:54', '2024-03-08 01:12:39');
INSERT INTO `tb_pay` VALUES (8, 'pay20240308002', 'pay202403080021003', 1, 19.90, 0, '2024-03-08 01:17:06', '2024-03-08 01:17:06');
INSERT INTO `tb_pay` VALUES (9, '202403081001', '202403081002', 1, 19.90, 0, '2024-03-08 01:45:03', '2024-03-08 01:45:03');

SET FOREIGN_KEY_CHECKS = 1;
