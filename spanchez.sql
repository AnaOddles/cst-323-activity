CREATE DATABASE `spanchez` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `users` (
  `user_Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

CREATE TABLE `games` (
  `game_Id` int(11) NOT NULL AUTO_INCREMENT,
  `user_Id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `publisher` varchar(50) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `rating` varchar(50) NOT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `image` varchar(150) NOT NULL,
  `description` longtext NOT NULL,
  `platform` varchar(40) NOT NULL,
  PRIMARY KEY (`game_Id`),
  KEY `games_id_users_if_FK` (`user_Id`),
  CONSTRAINT `games_id_users_if_FK` FOREIGN KEY (`user_Id`) REFERENCES `users` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `profiles` (
  `profile_Id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(20) NOT NULL,
  `lastName` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `user_Id` int(11) NOT NULL,
  PRIMARY KEY (`profile_Id`),
  KEY `profiles_id_users_id_FK` (`user_Id`),
  CONSTRAINT `profiles_id_users_id_FK` FOREIGN KEY (`user_Id`) REFERENCES `users` (`user_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;