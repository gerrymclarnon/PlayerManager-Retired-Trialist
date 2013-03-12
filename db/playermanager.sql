-- MySQL dump 10.13  Distrib 5.5.29, for osx10.6 (i386)
--
-- Host: localhost    Database: playermanager
-- ------------------------------------------------------
-- Server version	5.5.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acl_class`
--

DROP TABLE IF EXISTS `acl_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acl_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_2` (`class`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_class`
--

LOCK TABLES `acl_class` WRITE;
/*!40000 ALTER TABLE `acl_class` DISABLE KEYS */;
INSERT INTO `acl_class` VALUES (1,'net.playermanager.games.model.Club'),(2,'net.playermanager.games.model.Player');
/*!40000 ALTER TABLE `acl_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_entry`
--

DROP TABLE IF EXISTS `acl_entry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acl_entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `acl_object_identity` bigint(20) NOT NULL,
  `ace_order` int(11) NOT NULL,
  `sid` bigint(20) NOT NULL,
  `mask` int(11) NOT NULL,
  `granting` tinyint(1) NOT NULL,
  `audit_success` tinyint(1) NOT NULL,
  `audit_failure` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_4` (`acl_object_identity`,`ace_order`),
  KEY `foreign_fk_5` (`sid`),
  CONSTRAINT `foreign_fk_4` FOREIGN KEY (`acl_object_identity`) REFERENCES `acl_object_identity` (`id`),
  CONSTRAINT `foreign_fk_5` FOREIGN KEY (`sid`) REFERENCES `acl_sid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_entry`
--

LOCK TABLES `acl_entry` WRITE;
/*!40000 ALTER TABLE `acl_entry` DISABLE KEYS */;
INSERT INTO `acl_entry` VALUES (1,1,1,1,1,1,1,1),(2,2,2,2,1,1,1,1),(3,2,3,3,1,1,1,1),(4,1,4,4,1,1,1,1),(5,3,1,1,2,1,1,1),(43,11,0,6,2,1,0,0),(44,12,0,1,2,1,0,0),(45,13,0,1,2,1,0,0),(46,14,0,1,2,1,0,0),(47,15,0,1,2,1,0,0),(48,16,0,1,2,1,0,0),(49,17,0,1,2,1,0,0),(50,18,0,1,2,1,0,0),(51,19,0,1,2,1,0,0),(52,20,0,1,2,1,0,0),(53,21,0,1,2,1,0,0),(54,22,0,1,2,1,0,0),(55,23,0,1,2,1,0,0),(56,24,0,1,2,1,0,0),(57,25,0,1,2,1,0,0),(58,26,0,1,2,1,0,0),(59,27,0,1,2,1,0,0),(60,28,0,1,2,1,0,0),(61,29,0,1,2,1,0,0),(62,30,0,1,2,1,0,0),(63,31,0,1,2,1,0,0),(64,32,0,1,2,1,0,0),(65,33,0,1,2,1,0,0),(66,34,0,1,2,1,0,0),(67,35,0,1,2,1,0,0),(68,36,0,1,2,1,0,0),(69,37,0,1,2,1,0,0),(70,38,0,1,2,1,0,0),(71,39,0,1,2,1,0,0);
/*!40000 ALTER TABLE `acl_entry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_object_identity`
--

DROP TABLE IF EXISTS `acl_object_identity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acl_object_identity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `object_id_class` bigint(20) NOT NULL,
  `object_id_identity` bigint(20) NOT NULL,
  `parent_object` bigint(20) DEFAULT NULL,
  `owner_sid` bigint(20) DEFAULT NULL,
  `entries_inheriting` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_3` (`object_id_class`,`object_id_identity`),
  KEY `foreign_fk_1` (`parent_object`),
  KEY `foreign_fk_3` (`owner_sid`),
  CONSTRAINT `foreign_fk_1` FOREIGN KEY (`parent_object`) REFERENCES `acl_object_identity` (`id`),
  CONSTRAINT `foreign_fk_2` FOREIGN KEY (`object_id_class`) REFERENCES `acl_class` (`id`),
  CONSTRAINT `foreign_fk_3` FOREIGN KEY (`owner_sid`) REFERENCES `acl_sid` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_object_identity`
--

LOCK TABLES `acl_object_identity` WRITE;
/*!40000 ALTER TABLE `acl_object_identity` DISABLE KEYS */;
INSERT INTO `acl_object_identity` VALUES (1,1,1,NULL,1,0),(2,1,2,NULL,2,0),(3,2,3,NULL,1,0),(11,2,7,NULL,1,1),(12,2,9,NULL,1,1),(13,2,10,NULL,1,1),(14,2,11,NULL,1,1),(15,2,12,NULL,1,1),(16,2,13,NULL,1,1),(17,2,14,NULL,1,1),(18,2,15,NULL,1,1),(19,2,16,NULL,1,1),(20,2,17,NULL,1,1),(21,2,18,NULL,1,1),(22,2,19,NULL,1,1),(23,2,20,NULL,1,1),(24,2,21,NULL,1,1),(25,2,22,NULL,1,1),(26,2,23,NULL,1,1),(27,2,24,NULL,1,1),(28,2,25,NULL,1,1),(29,2,26,NULL,1,1),(30,2,27,NULL,1,1),(31,2,28,NULL,1,1),(32,2,29,NULL,1,1),(33,2,30,NULL,1,1),(34,2,31,NULL,1,1),(35,2,32,NULL,1,1),(36,2,33,NULL,1,1),(37,2,34,NULL,1,1),(38,2,35,NULL,1,1),(39,2,36,NULL,1,1);
/*!40000 ALTER TABLE `acl_object_identity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `acl_sid`
--

DROP TABLE IF EXISTS `acl_sid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acl_sid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` tinyint(1) NOT NULL,
  `sid` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_uk_1` (`sid`,`principal`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acl_sid`
--

LOCK TABLES `acl_sid` WRITE;
/*!40000 ALTER TABLE `acl_sid` DISABLE KEYS */;
INSERT INTO `acl_sid` VALUES (2,1,'andrea'),(6,1,'archie'),(1,1,'gerry'),(3,1,'lucy'),(4,1,'mattie');
/*!40000 ALTER TABLE `acl_sid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('andrea','guardian'),('gerry','guardian'),('gerry','manager'),('gerry','player'),('lucy','player'),('mattie','player'),('rod','manager');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_PLAYER'),(2,'ROLE_MANAGER'),(3,'ROLE_GUARDIAN');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clubs`
--

DROP TABLE IF EXISTS `clubs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clubs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL DEFAULT '""',
  `owner` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_clubs_users` (`owner`),
  CONSTRAINT `fk_clubs_users` FOREIGN KEY (`owner`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clubs`
--

LOCK TABLES `clubs` WRITE;
/*!40000 ALTER TABLE `clubs` DISABLE KEYS */;
INSERT INTO `clubs` VALUES (1,'Monday Night Football','gerry'),(2,'Ladeez Football','andrea');
/*!40000 ALTER TABLE `clubs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `squadNumber` varchar(2) NOT NULL DEFAULT '""',
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `manager` tinyint(1) NOT NULL DEFAULT '0',
  `email` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `adult` tinyint(1) NOT NULL DEFAULT '1',
  `idSquad` int(11) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  `club` int(11) DEFAULT NULL,
  `allergies` varchar(45) DEFAULT NULL,
  `notes` varchar(256) DEFAULT NULL,
  `uri` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_players_clubs` (`club`),
  CONSTRAINT `fk_players_clubs` FOREIGN KEY (`club`) REFERENCES `clubs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (14,'2','Tatiana','Ticklikov',0,NULL,'09999 999999',NULL,1,NULL,1,NULL,'Cake','Good left foot','Tatiana_Ticklikov'),(15,'3','Ivan','Itchikov',0,NULL,'0123456789',NULL,1,NULL,1,NULL,'Beer','Good right foot','Ivan_Itchikov'),(16,'4','Ivan','Nastikov',0,NULL,'00924765552',NULL,1,NULL,1,NULL,NULL,'Good with both feet','Ivan_Nastikov'),(17,'5','Petr','Persistentkov',0,NULL,'079862386284',NULL,1,NULL,1,NULL,NULL,'Good in the air','Petr_Persistentkov'),(18,'7','Ivan','Annoyingkov',0,NULL,'074247948742',NULL,1,NULL,1,NULL,NULL,'Flying wing back','Ivan_Annoyingkov'),(19,'6','Ivan','Chestikov',0,NULL,'089764962486',NULL,1,NULL,1,NULL,NULL,'Midfield general','Ivan_Chestikov'),(20,'8','David','Drikov',0,NULL,'07879874974',NULL,1,NULL,1,NULL,NULL,'Left back home','David_Drikov'),(21,'9','Hristo','Hackinkov',0,NULL,'02094820948',NULL,1,NULL,1,NULL,NULL,'Old fashioned centre forward','Hristo_Hackinkov'),(22,'10','Petr','Phlegmikov',0,NULL,'08798798797',NULL,1,NULL,1,NULL,NULL,'Super sub','Petr_Phlegmikov'),(23,'1','Petr','Noisikov',0,NULL,'08798797977',NULL,1,NULL,1,NULL,NULL,'Safest hands in soccer','Petr_Noisikov'),(24,'11','Lashka','Loudkov',0,NULL,'0979887612322',NULL,1,NULL,1,NULL,NULL,'Journeyman','Lashka_Loudkov'),(25,'12','Petr','Quietkov',0,'gerry@mclarnonworld.com','07808 771940',NULL,1,NULL,1,NULL,'Passing','Good engine','Petr_Quietkov'),(26,'13','Ivan','Normalkov',0,NULL,'07979854333',NULL,1,NULL,1,NULL,NULL,'Man of many clubs','Ivan_Slowkov'),(27,'14','Petr','Produktivkov',0,NULL,'078768756544',NULL,1,NULL,1,NULL,NULL,'Luxury player','Petr_Produktivkov'),(28,'15','Kevin','Kovkov',0,NULL,'09798631688',NULL,1,NULL,1,NULL,NULL,'Hopeless case','Kevin_Kovkov'),(29,'16','Ivan','Whoopingkov',0,NULL,'097875414221',NULL,1,NULL,1,NULL,NULL,'Reiable at the back','Ivan_Whoopingkov'),(30,'17','Petr','Croupkov',0,NULL,'0857646543543',NULL,1,NULL,1,NULL,NULL,'Target man','Petr_Croupkov'),(31,'18','Sasha','Seallkekov',0,NULL,'08676452323',NULL,1,NULL,1,NULL,NULL,'Tanner ba\' player','Sasha_Seallkekov'),(32,'19','Barry','Barkinkov',0,NULL,'035678799765',NULL,1,NULL,1,NULL,NULL,'Midfield maestro','Barry_Barkinkov'),(33,'20','Waldemar','Wetkov',0,NULL,'08765412345',NULL,1,NULL,1,NULL,NULL,'Super striker','Waldemar_Wetkov'),(34,'21','Petr','Normalkov',0,NULL,'087132457687',NULL,1,NULL,1,NULL,NULL,'Robust defender','Petr_Normalkov'),(35,'22','Ivan','Oddkov',0,NULL,'098756541135',NULL,1,NULL,1,NULL,NULL,'Deep sea diver','Ivan_Oddkov'),(36,'23','Ivan','Nervouskov',0,NULL,'087856543342',NULL,1,NULL,1,NULL,NULL,'Lightweight','Ivan_Nervouskov');
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_club`
--

DROP TABLE IF EXISTS `user_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_club` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `club_id` int(11) NOT NULL,
  `authority_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_club_user` (`username`),
  KEY `fk_user_club_club` (`club_id`),
  KEY `fk_user_club_authority` (`authority_id`),
  CONSTRAINT `fk_user_club_authority` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_club_club` FOREIGN KEY (`club_id`) REFERENCES `clubs` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_club_user` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_club`
--

LOCK TABLES `user_club` WRITE;
/*!40000 ALTER TABLE `user_club` DISABLE KEYS */;
INSERT INTO `user_club` VALUES (1,'andrea',2,2),(2,'gerry',1,1),(3,'gerry',1,2),(5,'lucy',2,1),(6,'mattie',1,1),(7,'archie',2,1);
/*!40000 ALTER TABLE `user_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('andrea','5f4dcc3b5aa765d61d8327deb882cf99',1),('archie','5f4dcc3b5aa765d61d8327deb882cf99',1),('gerry','5f4dcc3b5aa765d61d8327deb882cf99',1),('lucy','5f4dcc3b5aa765d61d8327deb882cf99',1),('mattie','5f4dcc3b5aa765d61d8327deb882cf99',1),('rod','5f4dcc3b5aa765d61d8327deb882cf99',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-03-12 22:46:57
