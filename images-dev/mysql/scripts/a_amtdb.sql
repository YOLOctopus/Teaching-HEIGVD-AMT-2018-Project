-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Nov 08, 2018 at 12:34 PM
-- Server version: 5.7.23
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `amtdb`
--
CREATE DATABASE IF NOT EXISTS `amtdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `amtdb`;
-- --------------------------------------------------------

--
-- Table structure for table `APPLICATION`
--

CREATE TABLE `APPLICATION` (
  `ID` bigint(20) NOT NULL,
  `APIKEY` varchar(255) NOT NULL,
  `APISECRET` varchar(255) NOT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `USER`
--

CREATE TABLE `USER` (
  `ID` bigint(20) NOT NULL,
  `ACTIVE` tinyint(1) NOT NULL DEFAULT '0',
  `ADMIN` tinyint(1) NOT NULL DEFAULT '0',
  `EMAIL` varchar(255) NOT NULL,
  `FIRSTNAME` varchar(255) NOT NULL,
  `LASTNAME` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`ID`, `ACTIVE`, `ADMIN`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `PASSWORD`) VALUES
(1, 1, 1, 'sam@may.com', 'sdfsdv', 'fbdfbd', 'aaaaaaa');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `APPLICATION`
--
ALTER TABLE `APPLICATION`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `APIKEY` (`APIKEY`),
  ADD UNIQUE KEY `APISECRET` (`APISECRET`),
  ADD UNIQUE KEY `NAME` (`NAME`),
  ADD KEY `FK_APPLICATION_USER_ID` (`USER_ID`);

--
-- Indexes for table `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `APPLICATION`
--
ALTER TABLE `APPLICATION`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `USER`
--
ALTER TABLE `USER`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `APPLICATION`
--
ALTER TABLE `APPLICATION`
  ADD CONSTRAINT `FK_APPLICATION_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
