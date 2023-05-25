CREATE TABLE `company` (
       `cid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '업체 코드',
       `companyName` VARCHAR(30) NULL DEFAULT NULL COMMENT '상호',
       `fee` DECIMAL(10,2) NULL DEFAULT NULL COMMENT '수수료율',
       `created` DATETIME NULL DEFAULT NULL COMMENT '등록일시',
       `updated` DATETIME NULL DEFAULT NULL COMMENT '수정일시',
       PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product` (
       `pid` INT(11) NOT NULL AUTO_INCREMENT COMMENT '상품번호',
       `proName` VARCHAR(100) NULL DEFAULT NULL COMMENT '상품명',
       `proDesc` TEXT NULL DEFAULT NULL COMMENT '상품설명',
       `cid` INT(11) NULL DEFAULT NULL COMMENT '업체 코드',
       `created` DATETIME NULL DEFAULT NULL COMMENT '등록일자',
       `updated` DATETIME NULL DEFAULT NULL COMMENT '수정일자',
       PRIMARY KEY (`pid`),
       INDEX `FK_product_company` (`cid`),
       CONSTRAINT `FK_product_company` FOREIGN KEY (`cid`) REFERENCES `company` (`cid`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `product_option` (
      `oid` INT(11) NOT NULL AUTO_INCREMENT,
      `pid` INT(11) NOT NULL DEFAULT 0,
      `size` VARCHAR(10) NULL DEFAULT '' COMMENT '사이즈',
      `qty` INT(11) NULL DEFAULT 0 COMMENT '재고',
      `price` INT(11) NULL DEFAULT 0 COMMENT '가격',
      PRIMARY KEY (`oid`),
      INDEX `FK_product_option_product` (`pid`),
      CONSTRAINT `FK_product_option_product` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
