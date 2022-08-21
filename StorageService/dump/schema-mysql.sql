CREATE TABLE IF NOT EXISTS `storagedata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `storagetype` varchar(245) DEFAULT NULL,
  `bucket` varchar(245) DEFAULT NULL,
  `path` varchar(245) DEFAULT NULL,
  `length` varchar(245) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `resource_id` varchar(45) DEFAULT NULL,
  `filename` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8mb3
