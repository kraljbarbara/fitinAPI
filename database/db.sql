-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.37-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

create database mydb;
use mydb;

--
-- Table structure for table `routine`
--

DROP TABLE IF EXISTS `routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `routine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `duration` time NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_routine_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  UNIQUE KEY `description_UNIQUE` (`description`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine`
--

LOCK TABLES `routine` WRITE;
/*!40000 ALTER TABLE `routine` DISABLE KEYS */;
INSERT INTO `routine` VALUES (1,'outdoor activities','01:00:00',NULL,NULL);
/*!40000 ALTER TABLE `routine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routine_has_user`
--

DROP TABLE IF EXISTS `routine_has_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `routine_has_user` (
  `routine_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_routine_has_user_user1_idx` (`user_id`),
  KEY `fk_routine_has_user_routine1_idx` (`routine_id`),
  CONSTRAINT `fk_routine_has_user_routine1` FOREIGN KEY (`routine_id`) REFERENCES `routine` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_routine_has_user_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routine_has_user`
--

LOCK TABLES `routine_has_user` WRITE;
/*!40000 ALTER TABLE `routine_has_user` DISABLE KEYS */;
INSERT INTO `routine_has_user` VALUES (1,1,1);
/*!40000 ALTER TABLE `routine_has_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `vip` bit(1) NOT NULL DEFAULT b'0',
  `bank_account` varchar(45) DEFAULT NULL,
  `starting_weight` decimal(3,2) DEFAULT NULL,
  `goal_weight` decimal(3,2) DEFAULT NULL,
  `current_weight` decimal(3,2) DEFAULT NULL,
  `equipment1` varchar(45) DEFAULT NULL,
  `equipment2` varchar(45) DEFAULT NULL,
  `equipment3` varchar(45) DEFAULT NULL,
  `equipment4` varchar(45) DEFAULT NULL,
  `equipment5` varchar(45) DEFAULT NULL,
  `equipment6` varchar(45) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_user_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','admin@admin.com','Admin',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,''),(2,'Barbara','krneki','Barbara Kralj',_binary '',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'geslo123'),(3,'Tanja','krneki@gmail.com','Tanja Kralj',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'smth'),(4,'Alenka','krnekia@gmail.com','Tanja Kralj',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'smth'),(5,'bb','krnbbbekia@gmail.com','Tanja Kralj',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'smth'),(6,'bbn','krnbbb@gmail.com','Tanja Kralj',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'56963dd5cdbc8011393e85a0ca2f8875'),(7,'apiAdmin','apiAdmin@gmail.com','Barbara Kralj',_binary '\0',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'211340d1aab430caaadba78431c3e810');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout`
--

DROP TABLE IF EXISTS `workout`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `workout` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `duration` time NOT NULL,
  `location` varchar(45) NOT NULL,
  `equipment` varchar(45) DEFAULT NULL,
  `category` varchar(45) NOT NULL,
  `motivational_message` varchar(300) NOT NULL,
  `k` decimal(3,3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_workout_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout`
--

LOCK TABLES `workout` WRITE;
/*!40000 ALTER TABLE `workout` DISABLE KEYS */;
INSERT INTO `workout` VALUES (1,'aerobics - low intensity','00:10:00','inside','mat','endurance','Improves cardiovascular health; Lowers blood pressure; Helps regulate blood sugar; Reduces asthma symptoms; Reduces chronic pain; Aids sleep; Regulates weight; Strengthens immune system; Improves brain power; Boosts mood; Reduces risk of falls; ',0.099),(2,'aerobics - medium intensity','00:10:00','inside','mat','endurance','Improves cardiovascular health; Lowers blood pressure; Helps regulate blood sugar; Reduces asthma symptoms; Reduces chronic pain; Aids sleep; Regulates weight; Strengthens immune system; Improves brain power; Boosts mood; Reduces risk of falls; ',0.103),(3,'aerobics - high intensity','00:10:00','inside','mat','endurance','Improves cardiovascular health; Lowers blood pressure; Helps regulate blood sugar; Reduces asthma symptoms; Reduces chronic pain; Aids sleep; Regulates weight; Strengthens immune system; Improves brain power; Boosts mood; Reduces risk of falls; ',0.135),(4,'climbing','01:00:00','outdoor','climbing equipment','strength','Strengthens and tones muscles; Increases flexibility; Improves mental strength; Reduces stress; Burns calories; Prevents chronic disease; Conquers fears',0.159),(5,'badminton','00:10:00','outdoor','racquets','endurance','Helps to stay fit and lose weight; Helps in maintaining physique and muscle toning; Improves metabolic rate; Increases concentration and reflex action; Improves heart functioning; Improves muscle strength and flexibility; Increases bone density; Decreases the risk of diabetes; Cures hypertension;',0.097),(6,'ballet','00:30:00','inside','pointed shoes','flexibility','Better posture; Improves flexibility; Builds muscle and agility; Improves sensorimotor performance; Sharpens cognitive function; Relieves stress;',0.080),(7,'baseball','00:30:00','outdoor','bat','endurance','Cardiovascular training; Hand-eye coordination; Stress relief; Sharpen the mind; Strong arms and legs;',0.083),(8,'box','00:10:00','inside','boxing gloves','strength','Healthy Heart; Increase In Body Strength; Improved Cognitive Skills; Decreased Anxiety;',0.100),(9,'ice skating','00:30:00','outdoor','ice skates','endurance','Better balance; Improves joint flexibility;',0.117),(10,'gymnastics','00:10:00','inside','gymnastic equipment','flexibility','Flexibility; Strong and healthy bones; Disease prevention; Boosted self-esteem; Increased cognitive functioning; Enhanced coordination; Improves muscle strength;',0.066),(11,'golf','00:30:00','outdoor','clubs','balance','Brain stimulation; Heart health; Reduces stress; Improves sleep;',0.085),(12,'hiking','01:00:00','outdoor','hiking shoes','endurance','Lower stress levels; Improves mood; A reduced risk for heart disease; Lower blood pressure; Lower cholesterol levels; Lower body fat; Improved bone density; Improved osteoarthritis outcomes;',0.121),(13,'Mountain running','00:30:00','outdoor','hiking shoes','endurance','Improved Practical Endurance; Increase Leg; Strength; Injury Prevention; High-Quality Air; Increase Speed; Burn More Calories; Improve Your Balance;',0.170),(14,'walking - 4 km/h','01:00:00','outdoor','shoes','endurance','Improves Heart Health; Regulates Blood Pressure; Improves Circulation; Reduces Risk Of Diabetes; Strengthens Bones; Improves Digestion; Boosts Immune Function; Increases Lung Capacity; Delays Aging; Reduces Stress; ',0.064),(15,'hockey','01:00:00','outdoor','hockey stick','endurance','Metabolism boosting; Enhanced muscular strength; Develops hand-eye coordination; Improved body coordination and balance; Brain boost;',0.134),(16,'horse riding','00:30:00','outdoor','horse','balance','Develops core strength; Improves coordination; Increases muscle tone and strength; Increases muscle tone and strength;',0.067),(17,'yoga','00:10:00','inside','mat','flexibility','Improve flexibility, strength, and posture; Increase your energy; Reduce stress; Better breathing; Improves concentration;',0.062),(18,'judo','00:30:00','inside','','strength','A full-body workout; Improves cardiovascular fitness and endurance; Self-defense skills; Relaxation and meditation exercise to help manage stress; Focus on discipline, respect, and self-confidence;',0.195);
/*!40000 ALTER TABLE `workout` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_has_routine`
--

DROP TABLE IF EXISTS `workout_has_routine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `workout_has_routine` (
  `workout_id` int(11) NOT NULL,
  `routine_id` int(11) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_workout_has_routine_routine1_idx` (`routine_id`),
  KEY `fk_workout_has_routine_workout_idx` (`workout_id`),
  CONSTRAINT `fk_workout_has_routine_routine1` FOREIGN KEY (`routine_id`) REFERENCES `routine` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_workout_has_routine_workout` FOREIGN KEY (`workout_id`) REFERENCES `workout` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_has_routine`
--

LOCK TABLES `workout_has_routine` WRITE;
/*!40000 ALTER TABLE `workout_has_routine` DISABLE KEYS */;
INSERT INTO `workout_has_routine` VALUES (13,1,1),(14,1,2);
/*!40000 ALTER TABLE `workout_has_routine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-02 18:17:55
