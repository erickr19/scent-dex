-- MySQL dump 10.13  Distrib 8.0.32, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: ScentdexTest
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fragrance_notes`
--

DROP TABLE IF EXISTS `fragrance_notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fragrance_notes` (
  `fragrance_id` int NOT NULL,
  `note_id` int NOT NULL,
  PRIMARY KEY (`fragrance_id`,`note_id`),
  KEY `note` (`note_id`),
  CONSTRAINT `fragrance_notes_ibfk_1` FOREIGN KEY (`fragrance_id`) REFERENCES `fragrances` (`fragranceId`),
  CONSTRAINT `fragrance_notes_ibfk_2` FOREIGN KEY (`note_id`) REFERENCES `notes` (`noteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fragrance_notes`
--

LOCK TABLES `fragrance_notes` WRITE;
INSERT INTO `fragrance_notes` (`fragrance_id`, `note_id`) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(2,15),(2,16),(2,17),(2,18),(2,19),(2,20);
UNLOCK TABLES;

--
-- Table structure for table `fragrances`
--

DROP TABLE IF EXISTS `fragrances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fragrances` (
  `fragranceId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `designer` varchar(200) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `pricing` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fragranceId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fragrances`
--

LOCK TABLES `fragrances` WRITE;
INSERT INTO `fragrances` (`fragranceId`, `name`, `designer`, `description`, `pricing`) VALUES (1,'Eros Flame','Versace','In a fiery red bottle, Eros Flame is the fragrance of love and passion, deeply masculine and intense. In the words of Donatella Versace, \"The spark of true love is the dream that each of us pursues. True love captures the soul, body and mind, and never lets you go. It takes your breath away because without your beloved, you no longer feel complete. True love consumes everything in an eternal flame of passion.\" ','$107'),(2,'Luna Rossa','Prada','Evolved from the pursuit of excellence—dynamic, sportive, and energetic—Luna Rossa by Prada is a scent with a reverence for the natural world and a passion for innovation. The strength and freshness of the elements is evoked by the interpretation of classic notes in novel forms. A wave of aromatic freshness crashes through Luna Rossa, conveying strength and dynamic energy, while its signature is noble and sensual. ','$95');
UNLOCK TABLES;

--
-- Table structure for table `notes`
--

DROP TABLE IF EXISTS `notes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notes` (
  `noteId` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`noteId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notes`
--

LOCK TABLES `notes` WRITE;
INSERT INTO `notes` (`noteId`, `name`) VALUES (1,'Black pepper'),(2,'Chinotto'),(3,'Mandarin'),(4,'Lemon'),(5,'Rosemary'),(6,'Pepper'),(7,'Geranium'),(8,'Rose'),(9,'Vanilla'),(10,'Tonka bean'),(11,'Texas cedar'),(12,'Sandalwood'),(13,'Patchouli'),(14,'Oakmoss'),(15,'Orange Essence'),(16,'Lavender Absolue'),(17,'Clary Sage'),(18,'Spearmint Nanah'),(19,'Ambroxan'),(20,'Ambrette Absolue');
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reviews` (
  `reviewId` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `fragrance_id` int NOT NULL,
  `addedTime` date NOT NULL DEFAULT (curdate()),
  `review` varchar(1000) DEFAULT NULL,
  `rating` tinyint NOT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `user` (`user_id`),
  KEY `fragrance` (`fragrance_id`),
  CONSTRAINT `reviews_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reviews_ibfk_2` FOREIGN KEY (`fragrance_id`) REFERENCES `fragrances` (`fragranceId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reviews_chk_1` CHECK (((`rating` >= 0) and (`rating` <= 5)))
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
INSERT INTO `reviews` (`reviewId`, `user_id`, `fragrance_id`, `addedTime`, `review`, `rating`) VALUES (1,1,1,'2023-03-06','I personally have this scent in my collection and I love it!!',5);
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userId` int NOT NULL AUTO_INCREMENT,
  `createDate` date NOT NULL DEFAULT (curdate()),
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(20) NOT NULL,
  `wishlist_id` int DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
INSERT INTO `users` (`userId`, `createDate`, `email`, `password`, `username`, `wishlist_id`) VALUES (1,'2023-03-06','ereyes3@madisoncollege.edu','hello','erickrey',NULL),(3,'2023-03-09','vinny123@example.com','marshall35','vinnyvine',NULL);
UNLOCK TABLES;

--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `wishlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wishlist` (
  `wishlistId` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `fragrance_id` int NOT NULL,
  `addedTime` timestamp NOT NULL DEFAULT (curdate()),
  PRIMARY KEY (`wishlistId`),
  KEY `user` (`user_id`),
  KEY `fragrance` (`fragrance_id`),
  CONSTRAINT `wishlist_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `wishlist_ibfk_2` FOREIGN KEY (`fragrance_id`) REFERENCES `fragrances` (`fragranceId`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishlist`
--

LOCK TABLES `wishlist` WRITE;
INSERT INTO `wishlist` (`wishlistId`, `user_id`, `fragrance_id`, `addedTime`) VALUES (1,1,1,'2023-03-06 06:00:00');
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-09 21:41:49
