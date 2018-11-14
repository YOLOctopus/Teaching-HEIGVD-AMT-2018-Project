-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Nov 14, 2018 at 08:20 AM
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

--
-- Dumping data for table `APPLICATION`
--

INSERT INTO `APPLICATION` (`ID`, `APIKEY`, `APISECRET`, `DESCRIPTION`, `NAME`, `USER_ID`) VALUES
(1, 'asf8q9898ew7g68w', 'avev0978v8w7evw85v8we58w5ve8w5', 'A fabulous hunt for a lost treasure of the sea.', 'Treasure hunters', 2),
(2, 'io32o26o7moi3joih346oi', 'u3v6u3zv64u1z4vi36bi14b6i346i', 'Riders all around app for the latest news in extreme sports on wheels', 'Bike and Ride', 1),
(3, '26ih6i34u7o23h5i', '3bic23u26u745ig54u52kjb4636', 'An application that helps you with your tough decisions.', 'Decisio', 1),
(73, '0', '0', 'Test description0', 'The test0', 1),
(74, '1', '1', 'Test description1', 'The test1', 1),
(75, '2', '2', 'Test description2', 'The test2', 1),
(76, '3', '3', 'Test description3', 'The test3', 1),
(77, '4', '4', 'Test description4', 'The test4', 1),
(78, '5', '5', 'Test description5', 'The test5', 1),
(79, '6', '6', 'Test description6', 'The test6', 1),
(80, '7', '7', 'Test description7', 'The test7', 1),
(81, '8', '8', 'Test description8', 'The test8', 1),
(82, '9', '9', 'Test description9', 'The test9', 1),
(83, '10', '10', 'Test description10', 'The test10', 1),
(84, '11', '11', 'Test description11', 'The test11', 1),
(85, '12', '12', 'Test description12', 'The test12', 1),
(86, '13', '13', 'Test description13', 'The test13', 1),
(87, '14', '14', 'Test description14', 'The test14', 1),
(88, '15', '15', 'Test description15', 'The test15', 1),
(89, '16', '16', 'Test description16', 'The test16', 1),
(90, '17', '17', 'Test description17', 'The test17', 1),
(91, '18', '18', 'Test description18', 'The test18', 1),
(92, '19', '19', 'Test description19', 'The test19', 1),
(93, '20', '20', 'Test description20', 'The test20', 1),
(94, '21', '21', 'Test description21', 'The test21', 1),
(95, '22', '22', 'Test description22', 'The test22', 1),
(96, '23', '23', 'Test description23', 'The test23', 1),
(97, '24', '24', 'Test description24', 'The test24', 1),
(98, '25', '25', 'Test description25', 'The test25', 1),
(99, '26', '26', 'Test description26', 'The test26', 1),
(100, '27', '27', 'Test description27', 'The test27', 1),
(101, '28', '28', 'Test description28', 'The test28', 1),
(102, '29', '29', 'Test description29', 'The test29', 1),
(103, '30', '30', 'Test description30', 'The test30', 1),
(104, '31', '31', 'Test description31', 'The test31', 1),
(105, '32', '32', 'Test description32', 'The test32', 1),
(106, '33', '33', 'Test description33', 'The test33', 1),
(107, '34', '34', 'Test description34', 'The test34', 1),
(108, '35', '35', 'Test description35', 'The test35', 1),
(109, '36', '36', 'Test description36', 'The test36', 1),
(110, '37', '37', 'Test description37', 'The test37', 1),
(111, '38', '38', 'Test description38', 'The test38', 1),
(112, '39', '39', 'Test description39', 'The test39', 1),
(113, '40', '40', 'Test description40', 'The test40', 1),
(114, '41', '41', 'Test description41', 'The test41', 1),
(115, '42', '42', 'Test description42', 'The test42', 1),
(116, '43', '43', 'Test description43', 'The test43', 1),
(117, '44', '44', 'Test description44', 'The test44', 1),
(118, '45', '45', 'Test description45', 'The test45', 1),
(119, '46', '46', 'Test description46', 'The test46', 1),
(120, '47', '47', 'Test description47', 'The test47', 1),
(121, '48', '48', 'Test description48', 'The test48', 1),
(122, '49', '49', 'Test description49', 'The test49', 1),
(123, '50', '50', 'Test description50', 'The test50', 1),
(124, '51', '51', 'Test description51', 'The test51', 1),
(125, '52', '52', 'Test description52', 'The test52', 1),
(126, '53', '53', 'Test description53', 'The test53', 1),
(127, '54', '54', 'Test description54', 'The test54', 1),
(128, '55', '55', 'Test description55', 'The test55', 1),
(129, '56', '56', 'Test description56', 'The test56', 1),
(130, '57', '57', 'Test description57', 'The test57', 1),
(131, '58', '58', 'Test description58', 'The test58', 1),
(132, '59', '59', 'Test description59', 'The test59', 1),
(170989, '170916', '170916', 'Test description170916', 'The test170916', 1),
(171023, 'b5104239-281f-40c5-9a2c-aaa7cb867f91', '7b8bf7c2-27ad-4d17-be96-e6450f27b2e2', 'You can browse moving images in a multi colored theme', '90d02eb6-630d-45fe-bd26-cfba9337c3c9', 1),
(171024, '7f93f8fa-dd66-44b2-aa7e-ae81c9e77db1', '13328e4b-4d30-4066-bf84-24387c576643', 'You can browse moving images in a multi colored theme', 'c04f367b-6af7-47d9-a206-6e5b06f64e2c', 1),
(171025, '20aa669d-ec93-4256-856d-2d2742b6cd71', '91a88793-d8e2-4aa4-8ce1-7b416fe4e471', 'You can browse moving images in a multi colored theme', '136f4b2b-9a91-48ae-988d-054710d8c9db', 1);
INSERT INTO `APPLICATION` (`ID`, `APIKEY`, `APISECRET`, `DESCRIPTION`, `NAME`, `USER_ID`) VALUES
(171026, '7d17c9c8-ff06-4357-88da-d591b159fa18', '1a61f1ab-5009-4ab2-ad8e-44f53a99106b', 'You can browse moving images in a multi colored theme', '7554df2c-e40f-49ee-b5d6-f5af374574df', 1),
(171027, 'a34075e1-564c-4875-a346-aa7f60e1eebb', 'dedcd426-5523-40fc-90c2-7a2ad4660514', 'You can browse moving images in a multi colored theme', '49031423-dbb3-48df-a642-a5cf279a0641', 1),
(171028, '7bdf7b87-63fc-4060-a3d9-198b78b8e6c2', '7c84a657-e4c8-45a7-8de6-72394569ab5e', 'You can browse moving images in a multi colored theme', 'd68fd58d-b8fc-474d-a7b8-97e4685ba9d1', 1),
(171029, '21c722c2-5843-49ad-b716-9d041746775c', '246a5c9e-c079-4688-9c55-3420140b6f8e', 'You can browse moving images in a multi colored theme', 'bbda36b4-a2c5-43c3-b048-e7b7f0d0a44a', 1),
(171030, '5d08a9f1-82b7-402e-b39c-e7b0bd06a2d1', '0df973cb-1a38-40c5-9025-6480133b2645', 'You can browse moving images in a multi colored theme', '920665fd-0744-438b-95cb-33413e925d57', 1),
(171031, '27e796d2-1d08-4419-97c1-f4942dc244e9', '0930b6ac-48b3-4eb5-b560-ee9562184b49', 'You can browse moving images in a multi colored theme', 'eccbaa6e-32d0-4691-b1cb-d5fb07893a1e', 1),
(171032, '806d4d63-799d-40d6-bd3f-695dbeb3a2d5', '7fa2e3f8-e163-43c6-857e-1df0b2199f6d', 'You can browse moving images in a multi colored theme', '9dd410c5-fa5e-4892-a905-8446bbb1e94a', 1),
(171033, '7ed9f206-f885-446c-96b2-db9a3bfd6b20', 'c70e036e-5b92-4085-8d39-861e936b6344', 'You can browse moving images in a multi colored theme', 'dba377ad-0ad5-44d7-ab87-5831be932cd3', 1),
(171034, '9068e2e7-1550-4574-8fb9-fa3fe15d2907', '7e29f124-cd36-4a0f-ac53-10529f671180', 'You can browse moving images in a multi colored theme', '872016ec-60e9-4eea-b890-c56c2656acc1', 1);

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
  `MUSTRESETPASSWORD` tinyint(1) NOT NULL DEFAULT '0',
  `PASSWORD` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USER`
--

INSERT INTO `USER` (`ID`, `ACTIVE`, `ADMIN`, `EMAIL`, `FIRSTNAME`, `LASTNAME`, `MUSTRESETPASSWORD`, `PASSWORD`) VALUES
(1, 1, 0, 'l.vanthillo@gmail.com', 'Lorenz', 'Vanthillo', 0, '1234'),
(2, 1, 0, 'l.darant@gmail.com', 'Lucien', 'Darant', 0, '1234'),
(3, 1, 1, 'sam@gmail.com', 'Samuel', 'Mayor', 0, '1234'),
(4, 1, 0, '1test@gmail.com', 'Test', 'Man', 0, '1234'),
(5, 1, 0, '21test@gmail.com', 'Test', 'Man', 0, '1234'),
(6, 1, 0, '31test@gmail.com', 'Test', 'Man', 0, '1234'),
(7, 1, 0, '41test@gmail.com', 'Test', 'Man', 0, '1234'),
(8, 1, 0, '51test@gmail.com', 'Test', 'Man', 0, '1234'),
(9, 1, 0, '61test@gmail.com', 'Test', 'Man', 0, '1234'),
(10, 1, 0, '71test@gmail.com', 'Test', 'Man', 0, '1234'),
(11, 1, 0, '81test@gmail.com', 'Test', 'Man', 0, '1234'),
(12, 1, 0, '91test@gmail.com', 'Test', 'Man', 0, '1234'),
(13, 1, 0, '101test@gmail.com', 'Test', 'Man', 0, '1234'),
(14, 1, 0, '111test@gmail.com', 'Test', 'Man', 0, '1234'),
(15, 1, 0, '121test@gmail.com', 'Test', 'Man', 0, '1234'),
(16, 1, 0, '131test@gmail.com', 'Test', 'Man', 0, '1234'),
(17, 1, 0, '141test@gmail.com', 'Test', 'Man', 0, '1234'),
(18, 1, 0, '151test@gmail.com', 'Test', 'Man', 0, '1234'),
(19, 1, 0, '161test@gmail.com', 'Test', 'Man', 0, '1234'),
(20, 1, 0, '171test@gmail.com', 'Test', 'Man', 0, '1234'),
(21, 1, 0, '181test@gmail.com', 'Test', 'Man', 0, '1234'),
(22, 1, 0, '191test@gmail.com', 'Test', 'Man', 0, '1234'),
(23, 1, 0, '201test@gmail.com', 'Test', 'Man', 0, '1234'),
(24, 1, 0, '211test@gmail.com', 'Test', 'Man', 0, '1234'),
(25, 1, 0, 'samuelmayorweb@gmail.com', 'Samuel', 'Mayor', 0, '1234567'),
(26, 0, 0, 'abc@aol.fr', 'salut', 'c\'est cool', 0, 'aaaaaaa'),
(61, 1, 0, 'a', 'Louis', 'Lepreux', 0, '1234'),
(62, 1, 0, 'b', 'Alain', 'Garno', 0, '1234'),
(63, 1, 0, 'c', 'Louis', 'Lepreux', 0, '1234'),
(64, 1, 0, 'd', 'Alain', 'Garno', 0, '1234');

-- --------------------------------------------------------

--
-- Table structure for table `USERTOKEN`
--

CREATE TABLE `USERTOKEN` (
  `ID` bigint(20) NOT NULL,
  `TOKEN` varchar(255) NOT NULL,
  `USER_ID` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USERTOKEN`
--

INSERT INTO `USERTOKEN` (`ID`, `TOKEN`, `USER_ID`) VALUES
(1, 'ec216005-d9f0-4841-b62d-17bcb2508a37', 25),
(2, '1e029bd7-ef62-44ec-9040-e756af5c36a9', 26);

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
-- Indexes for table `USERTOKEN`
--
ALTER TABLE `USERTOKEN`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_USERTOKEN_USER_ID` (`USER_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `APPLICATION`
--
ALTER TABLE `APPLICATION`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=171035;

--
-- AUTO_INCREMENT for table `USER`
--
ALTER TABLE `USER`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `USERTOKEN`
--
ALTER TABLE `USERTOKEN`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `APPLICATION`
--
ALTER TABLE `APPLICATION`
  ADD CONSTRAINT `FK_APPLICATION_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`ID`);

--
-- Constraints for table `USERTOKEN`
--
ALTER TABLE `USERTOKEN`
  ADD CONSTRAINT `FK_USERTOKEN_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `USER` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
