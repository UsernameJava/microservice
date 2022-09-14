CREATE TABLE IF NOT EXISTS `song_metadata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(245) DEFAULT NULL,
  `artist` varchar(245) DEFAULT NULL,
  `album` varchar(245) DEFAULT NULL,
  `length` varchar(245) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `resource_id` varchar(45) DEFAULT NULL,
  `filename` varchar(245) DEFAULT NULL,
  `traceid` varchar(245) DEFAULT NULL,
  `status` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8mb3
