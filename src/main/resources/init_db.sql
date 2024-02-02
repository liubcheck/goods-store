CREATE SCHEMA IF NOT EXISTS `goods_store` DEFAULT CHARACTER SET utf8;
USE `goods_store`;
SET NAMES utf8mb4;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products`  (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(255) NOT NULL,
    `description` varchar(255),
    `price` decimal(20,2),
    `quantity` int,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_general_ci;
