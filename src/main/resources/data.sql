INSERT INTO `company` (`cid`, `companyName`, `fee`, `created`, `updated`) VALUES (1, '동네방네', 0.05, '2023-05-24 18:44:09', '2023-05-24 18:44:11');
INSERT INTO `company` (`cid`, `companyName`, `fee`, `created`, `updated`) VALUES (2, '아디다스', 0.02, '2023-05-24 23:13:58', '2023-05-24 23:13:59');


INSERT INTO `product` (`pid`, `proName`, `proDesc`, `cid`, `created`, `updated`) VALUES (1, '에어조단', '에어조단 시리즈', 1, '2023-02-24 22:07:40', '2023-02-24 22:07:40');
INSERT INTO `product` (`pid`, `proName`, `proDesc`, `cid`, `created`, `updated`) VALUES (2, '라운드티', '남녀 노소 누구나입을수 있는 티셔츠!', 1, '2023-03-25 22:13:17', '2023-03-25 22:13:17');
INSERT INTO `product` (`pid`, `proName`, `proDesc`, `cid`, `created`, `updated`) VALUES (3, '나이키슬리퍼', '남성용 슬리퍼입니다', 1, '2023-04-26 22:20:16', '2023-04-26 22:20:16');
INSERT INTO `product` (`pid`, `proName`, `proDesc`, `cid`, `created`, `updated`) VALUES (8, '아디다스 런닝화', '런닝화 입니다', 2, '2023-05-20 00:07:08', '2023-05-20 00:07:08');

INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (31, 1, '240', 20, 50000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (32, 1, '250', 40, 50000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (33, 1, '260', 50, 50000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (34, 1, '270', 50, 55000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (35, 1, '280', 50, 55000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (36, 2, 'S', 70, 12000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (37, 2, 'L', 80, 12000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (38, 2, 'XL', 50, 13000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (42, 3, '260', 70, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (43, 3, '270', 60, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (44, 3, '275', 50, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (45, 3, '280', 50, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (46, 8, '260', 70, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (47, 8, '270', 60, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (48, 8, '275', 50, 33000);
INSERT INTO `product_option` (`oid`, `pid`, `size`, `qty`, `price`) VALUES (49, 8, '280', 50, 33000);
