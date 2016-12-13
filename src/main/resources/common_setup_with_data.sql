/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

DROP DATABASE IF EXISTS `final_project_db`;
CREATE DATABASE IF NOT EXISTS `final_project_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `final_project_db`;

DROP TABLE IF EXISTS `flight`;
CREATE TABLE IF NOT EXISTS `flight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flight_number` varchar(50) DEFAULT NULL,
  `plane_id` bigint(20) DEFAULT NULL,
  `departure_id` bigint(20) DEFAULT NULL,
  `arrival_id` bigint(20) DEFAULT NULL,
  `departure_date` datetime DEFAULT NULL,
  `arrival_date` datetime DEFAULT NULL,
  `price_casual` double DEFAULT NULL,
  `price_business` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FK_flight_location` (`departure_id`),
  KEY `FK_flight_location_2` (`arrival_id`),
  KEY `FK_flight_plane` (`plane_id`),
  CONSTRAINT `FK_flight_location` FOREIGN KEY (`departure_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK_flight_location_2` FOREIGN KEY (`arrival_id`) REFERENCES `location` (`id`),
  CONSTRAINT `FK_flight_plane` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `flight`;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` (`id`, `flight_number`, `plane_id`, `departure_id`, `arrival_id`, `departure_date`, `arrival_date`, `price_casual`, `price_business`) VALUES
	(1, 'E27', 7, 1, 2, '2016-11-19 17:50:19', '2016-11-19 17:50:21', 200, 350);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `Latitude` double DEFAULT NULL,
  `Longitute` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `location`;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `country`, `city`, `Latitude`, `Longitute`) VALUES
	(1, 'Ukraine', 'Dnipro', 21.1, 42.1),
	(2, 'Ukraine', 'Lviv', 21.1, 42.1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(128) NOT NULL,
  `last_name` varchar(128) NOT NULL,
  `age` int(11) NOT NULL,
  `passport` varchar(50) NOT NULL,
  `email` varchar(150) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `first_name`, `last_name`, `age`, `passport`, `email`) VALUES
	(1, 'Test Name', 'Ivanov', 20, 'AA123456', 'deneg.tet@dergites.tut'),
	(2, 'Roman', 'Kurilko', 27, 'AA999888777', 'zero0202@mail.ru'),
	(3, 'Roman', 'Kurilko', 27, 'AA999888777', '123@mail.ru');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

DROP TABLE IF EXISTS `plane`;
CREATE TABLE IF NOT EXISTS `plane` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `model` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

DELETE FROM `plane`;
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
INSERT INTO `plane` (`id`, `model`) VALUES
	(1, 'Boeing 747'),
	(2, 'АН'),
	(3, 'ТУ'),
	(4, 'Airbus'),
	(5, 'Tu-134'),
	(6, 'Tu-134_updated'),
	(7, 'Tu-134_updated2');
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;

DROP TABLE IF EXISTS `seat`;
CREATE TABLE IF NOT EXISTS `seat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` int(11) DEFAULT NULL,
  `business` bit(1) DEFAULT NULL,
  `plane_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FK_place_plane` (`plane_id`),
  CONSTRAINT `FK_place_plane` FOREIGN KEY (`plane_id`) REFERENCES `plane` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

DELETE FROM `seat`;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` (`id`, `number`, `business`, `plane_id`) VALUES
	(1, 1, b'1', 1),
	(2, 2, b'1', 1),
	(3, 3, b'1', 1),
	(4, 4, b'0', 1),
	(5, 1, b'0', 5),
	(6, 2, b'0', 5),
	(7, 3, b'0', 5),
	(8, 4, b'0', 5),
	(9, 5, b'0', 5),
	(10, 6, b'0', 5),
	(11, 7, b'0', 5),
	(12, 8, b'0', 5),
	(13, 9, b'0', 5),
	(14, 10, b'0', 5),
	(15, 11, b'0', 5),
	(16, 12, b'0', 5),
	(17, 13, b'0', 5),
	(18, 14, b'0', 5),
	(19, 15, b'0', 5),
	(20, 16, b'0', 5),
	(21, 17, b'0', 5),
	(22, 18, b'0', 5),
	(23, 19, b'0', 5),
	(24, 20, b'0', 5),
	(25, 21, b'0', 5),
	(26, 22, b'0', 5),
	(27, 23, b'0', 5),
	(28, 24, b'0', 5),
	(29, 25, b'0', 5),
	(30, 26, b'0', 5),
	(31, 27, b'0', 5),
	(32, 28, b'0', 5),
	(33, 29, b'0', 5),
	(34, 30, b'0', 5),
	(35, 31, b'0', 5),
	(36, 32, b'0', 5),
	(37, 33, b'0', 5),
	(38, 34, b'0', 5),
	(39, 35, b'0', 5),
	(40, 36, b'0', 5),
	(41, 37, b'0', 5),
	(42, 38, b'0', 5),
	(43, 39, b'0', 5),
	(44, 40, b'0', 5),
	(45, 1, b'0', 6),
	(46, 2, b'0', 6),
	(47, 3, b'0', 6),
	(48, 4, b'0', 6),
	(49, 5, b'0', 6),
	(50, 6, b'0', 6),
	(51, 7, b'0', 6),
	(52, 8, b'0', 6),
	(53, 9, b'0', 6),
	(54, 10, b'0', 6),
	(55, 11, b'0', 6),
	(56, 12, b'0', 6),
	(57, 13, b'0', 6),
	(58, 14, b'0', 6),
	(59, 15, b'0', 6),
	(60, 16, b'0', 6),
	(61, 17, b'0', 6),
	(62, 18, b'0', 6),
	(63, 19, b'0', 6),
	(64, 20, b'0', 6),
	(65, 21, b'0', 6),
	(66, 22, b'0', 6),
	(67, 23, b'0', 6),
	(68, 24, b'0', 6),
	(69, 25, b'0', 6),
	(70, 26, b'0', 6),
	(71, 27, b'0', 6),
	(72, 28, b'0', 6),
	(73, 29, b'0', 6),
	(74, 30, b'0', 6),
	(75, 31, b'0', 6),
	(76, 32, b'0', 6),
	(77, 33, b'0', 6),
	(78, 34, b'0', 6),
	(79, 35, b'0', 6),
	(80, 36, b'0', 6),
	(81, 37, b'0', 6),
	(82, 38, b'0', 6),
	(83, 39, b'0', 6),
	(84, 40, b'0', 6),
	(85, 1, b'1', 7),
	(86, 2, b'1', 7),
	(87, 3, b'1', 7),
	(88, 4, b'1', 7),
	(89, 5, b'1', 7),
	(90, 6, b'1', 7),
	(91, 7, b'1', 7),
	(92, 8, b'1', 7),
	(93, 9, b'1', 7),
	(94, 10, b'1', 7),
	(95, 11, b'0', 7),
	(96, 12, b'0', 7),
	(97, 13, b'0', 7),
	(98, 14, b'0', 7),
	(99, 15, b'0', 7),
	(100, 16, b'0', 7),
	(101, 17, b'0', 7),
	(102, 18, b'0', 7),
	(103, 19, b'0', 7),
	(104, 20, b'0', 7),
	(105, 21, b'0', 7),
	(106, 22, b'0', 7),
	(107, 23, b'0', 7),
	(108, 24, b'0', 7),
	(109, 25, b'0', 7),
	(110, 26, b'0', 7),
	(111, 27, b'0', 7),
	(112, 28, b'0', 7),
	(113, 29, b'0', 7),
	(114, 30, b'0', 7),
	(115, 31, b'0', 7),
	(116, 32, b'0', 7),
	(117, 33, b'0', 7),
	(118, 34, b'0', 7),
	(119, 35, b'0', 7),
	(120, 36, b'0', 7),
	(121, 37, b'0', 7),
	(122, 38, b'0', 7),
	(123, 39, b'0', 7),
	(124, 40, b'0', 7);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `seat_id` bigint(20) DEFAULT NULL,
  `luggage` bigint(20) DEFAULT NULL,
  `flight_id` bigint(20) DEFAULT NULL,
  `state` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`),
  KEY `FK_ticket_place` (`seat_id`),
  KEY `FK_ticket_flight` (`flight_id`),
  KEY `FK_ticket_person` (`person_id`),
  CONSTRAINT `FK_ticket_flight` FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`),
  CONSTRAINT `FK_ticket_person` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `FK_ticket_place` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `ticket`;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` (`id`, `seat_id`, `luggage`, `flight_id`, `state`, `person_id`) VALUES
	(1, 85, 1, 1, 1, 1);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
