-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2022 at 11:43 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `survey`
--

-- --------------------------------------------------------

--
-- Table structure for table `organiser`
--

CREATE TABLE `organiser` (
  `Organiser_id` char(9) COLLATE utf8_turkish_ci NOT NULL,
  `Email` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `Password` varchar(25) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `organiser`
--

INSERT INTO `organiser` (`Organiser_id`, `Email`, `Password`) VALUES
('1', 'organiser1@mail.com', '1234'),
('2', 'organiser2@mail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `Description` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Question_num` varchar(15) COLLATE utf8_turkish_ci NOT NULL,
  `Question_id` char(9) COLLATE utf8_turkish_ci NOT NULL,
  `Question_type` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Survey_id` char(9) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`Description`, `Question_num`, `Question_id`, `Question_type`, `Survey_id`) VALUES
('Was anything disappointing about this product?\r\n', '1', '1', 'open ended', '1'),
('Which actors or actresses would play this brand in a movie?', '5', '10', 'open ended', '2'),
('What do you like most about this product?\r\n', '2', '2', 'open ended', '1'),
('If someone asked you about our product, what would you say to them?', '3', '3', 'open ended', '1'),
('Which celebrities do you think would use this product?', '4', '4', 'open ended', '1'),
('If this product was an animal, what kind would it be?', '5', '5', 'open ended', '1'),
('Would you buy this brand? Why or why not?', '1', '6', 'open ended', '2'),
('What words would you use to describe this brand’s personality?', '2', '7', 'open ended', '2'),
('How do you think people would react if you used/wore this brand?', '3', '8', 'open ended', '2'),
('What kind of music does this brand listen to?', '4', '9', 'open ended', '2');

-- --------------------------------------------------------

--
-- Table structure for table `responses`
--

CREATE TABLE `responses` (
  `Responses_id` char(9) COLLATE utf8_turkish_ci NOT NULL,
  `Answer` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Question_id` char(9) COLLATE utf8_turkish_ci NOT NULL,
  `SSN` char(9) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `responses`
--

INSERT INTO `responses` (`Responses_id`, `Answer`, `Question_id`, `SSN`) VALUES
('1', 'no, this is indeed an excellent product', '1', '1'),
('10', 'i think dicaprio would play this brand', '10', '2'),
('12', 'hello', '6', '50'),
('121', 'hsgf', '4', '56'),
('1223', 'fkdls', '5', '56'),
('123', 'ofpr', '3', '56'),
('13', 'hi', '7', '50'),
('14', 'hy', '8', '50'),
('15', 'hgh', '9', '50'),
('16', 'ghgh', '10', '50'),
('2', 'The thing I like most about the product is that it is quite stylish.', '2', '1'),
('213', 'unfor', '1', '56'),
('233', 'forun', '2', '56'),
('3', 'I am very pleased with my purchase of the product.', '3', '1'),
('4', 'I think the product can be very useful for actors.', '4', '1'),
('5', 'it would definitely be a feline', '5', '1'),
('6', 'I would definitely buy this brand because I think it is solid.', '6', '2'),
('7', 'solid,innovative,stylish', '7', '2'),
('8', 'I think I will get good reactions from people.', '8', '2'),
('9', 'i think jazz', '9', '2');

-- --------------------------------------------------------

--
-- Table structure for table `surveyy`
--

CREATE TABLE `surveyy` (
  `Survey_id` char(9) COLLATE utf8_turkish_ci NOT NULL,
  `Survey_name` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Survey_des` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `Organiser_id` char(9) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `surveyy`
--

INSERT INTO `surveyy` (`Survey_id`, `Survey_name`, `Survey_des`, `Organiser_id`) VALUES
('1', 'product', 'questions about product', '1'),
('2', 'brand', 'branding survey', '2');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `SSN` char(9) COLLATE utf8_turkish_ci NOT NULL,
  `Phone_num` int(25) NOT NULL,
  `Fname` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `Minit` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `Lname` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `Email` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `Adress` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `Gender` varchar(15) COLLATE utf8_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`SSN`, `Phone_num`, `Fname`, `Minit`, `Lname`, `Email`, `Adress`, `Gender`) VALUES
('1', 123123, 'kemal', 'yağız', 'özcan', 'kyo@mail.com', 'eskisehir bağlar ', 'erkek'),
('2', 321321, 'ismail', 'asasd', 'bölükbaşı', 'ib@mail.com', 'eskisehir yenibaglar', 'erkek'),
('23123', 244212, 'asdasd', 'asdasd', 'sdfdf', 'sdafasdf', 'sdfasdf', 'asdas'),
('50', 31234124, 'asdasd', 'asdasd', 'asdasd', 'asdasd', 'asdas', 'asdasd'),
('54', 23424, 'asds', 'asdasd', 'asdas', 'asdad', 'asdasd', 'asdasd'),
('55', 45235, 'ali', 'asdasd', 'asdasd', 'asdasd', 'asd', 'asdas'),
('56', 3421, 'ali', 'asdasd', 'veli', 'email', 'eski', 'asdasd'),
('asdasd', 12312, 'asdasd21', 'asdasd', 'asdasd', 'asdasd', 'asdasd', 'asdasd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `organiser`
--
ALTER TABLE `organiser`
  ADD PRIMARY KEY (`Organiser_id`);

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`Question_id`),
  ADD KEY `Survey_id` (`Survey_id`);

--
-- Indexes for table `responses`
--
ALTER TABLE `responses`
  ADD PRIMARY KEY (`Responses_id`),
  ADD KEY `SSN` (`SSN`),
  ADD KEY `Question_id` (`Question_id`);

--
-- Indexes for table `surveyy`
--
ALTER TABLE `surveyy`
  ADD PRIMARY KEY (`Survey_id`),
  ADD UNIQUE KEY `Survey_name` (`Survey_name`),
  ADD KEY `Organise_id` (`Organiser_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`SSN`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `questions`
--
ALTER TABLE `questions`
  ADD CONSTRAINT `Survey_id` FOREIGN KEY (`Survey_id`) REFERENCES `surveyy` (`Survey_id`);

--
-- Constraints for table `responses`
--
ALTER TABLE `responses`
  ADD CONSTRAINT `Question_id` FOREIGN KEY (`Question_id`) REFERENCES `questions` (`Question_id`),
  ADD CONSTRAINT `SSN` FOREIGN KEY (`SSN`) REFERENCES `user` (`SSN`);

--
-- Constraints for table `surveyy`
--
ALTER TABLE `surveyy`
  ADD CONSTRAINT `Organise_id` FOREIGN KEY (`Organiser_id`) REFERENCES `organiser` (`Organiser_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
