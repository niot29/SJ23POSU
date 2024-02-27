SHOW DATABASES;
create database Topswe;
USE Topswe;

CREATE TABLE  IF NOT EXISTS `topimport` (
  `ID` int NOT NULL  AUTO_INCREMENT,
  `weeks` varchar(10) DEFAULT NULL,
  `placement` int DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ;
 
CREATE TABLE  IF NOT EXISTS `artist` (
  `artist_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(100) DEFAULT NULL
) ;

CREATE TABLE  IF NOT EXISTS `title` (
  `title_id` int NOT NULL  AUTO_INCREMENT PRIMARY KEY,
  `title` varchar(100) DEFAULT NULL,
  `artist_id` int NOT NULL,
  INDEX `idx_artist` (artist_id),
  constraint `FK_title_artist`
  foreign key (artist_id)
  references artist(artist_id) on update cascade on delete restrict
) ;

CREATE TABLE  IF NOT EXISTS `place_and_point` (
	place_and_point_id int NOT NULL  AUTO_INCREMENT PRIMARY KEY,
	weeks varchar(10) DEFAULT NULL,
	placement int DEFAULT NULL,
    place_point int DEFAULT NULL,
	title_id int NOT NULL,
    artist_id int NOT NULL,
  INDEX `idx_title` (title_id),
  constraint `FK_place_and_point_title`
  foreign key (title_id)
  references title(title_id) on update cascade on delete restrict
) ;

