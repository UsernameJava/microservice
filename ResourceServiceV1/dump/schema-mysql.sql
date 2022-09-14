CREATE TABLE `resource_service_song_metadata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `album` varchar(45) DEFAULT NULL,
  `artist` varchar(45) DEFAULT NULL,
  `length` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `year` varchar(45) DEFAULT NULL,
  `filename` varchar(245) DEFAULT NULL,
  `traceid` varchar(245) DEFAULT NULL,
  `status` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci