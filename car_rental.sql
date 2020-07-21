-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 04, 2020 at 12:46 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `car`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `licid` varchar(100) NOT NULL,
  `carid` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`licid`, `carid`) VALUES
('dl100', 'mini1002'),
('dl1234', 'mini1001');

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `carid` varchar(11) NOT NULL,
  `cartype` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `available` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`carid`, `cartype`, `name`, `available`) VALUES
('micro1001', 'micro', 'santro', 'yes'),
('micro1002', 'micro', 'kwid', 'yes'),
('micro1003', 'micro', 'santro', 'yes'),
('mini1001', 'mini', 'era', 'no'),
('mini1002', 'mini', 'wagonR', 'no'),
('mini1003', 'mini', 'eon', 'yes'),
('mini1004', 'mini', 'eon', 'yes'),
('mini1007', 'mini', 'send', 'yes'),
('sedan1001', 'sedan', 'honda city', 'yes'),
('sedan1002', 'sedan', 'amaze', 'yes'),
('sedan1003', 'sedan', 'amaze', 'yes'),
('suv1001', 'suv', 'safari', 'yes'),
('suv1002', 'suv', 'fortuner', 'yes'),
('suv1003', 'suv', 'safari', 'yes');

-- --------------------------------------------------------

--
-- Table structure for table `newuser`
--

CREATE TABLE `newuser` (
  `Name` varchar(50) NOT NULL,
  `licid` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(70) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `City` varchar(70) NOT NULL,
  `Contact` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `newuser`
--

INSERT INTO `newuser` (`Name`, `licid`, `Password`, `Email`, `Address`, `City`, `Contact`) VALUES
('anant verma', 'dl100', 'anant', 'anantverma@gmail.com', 'c-21 mayur vihar', 'new delhi', 7976655166),
('rahul', 'dl1008', 'rahul', 'rahul@gmail.com', 'delhi', 'delhi', 9890000456),
('karan', 'dl1234', 'karan', 'karan@gmail.com', 'delhi', 'delhi', 8930075543),
('sunil', 'dl1235', 'sunil', 'sunil@gmail.com', 'tapti hostel', 'delhi', 7210250769),
('hemraj', 'dl2412', 'hemraj', 'hkumawat077@gmail.com', 'mahi hostel', 'new delhi', 7976655166);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `licid` varchar(50) NOT NULL,
  `carid` varchar(50) NOT NULL,
  `amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`licid`, `carid`, `amount`) VALUES
('dl100', 'mini1002', 600),
('dl1234', 'mini1001', 610);

-- --------------------------------------------------------

--
-- Table structure for table `receive`
--

CREATE TABLE `receive` (
  `licid` varchar(100) NOT NULL,
  `carid` varchar(100) NOT NULL,
  `finalReading` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `userbook`
--

CREATE TABLE `userbook` (
  `licence` varchar(50) NOT NULL,
  `cartype` varchar(30) NOT NULL,
  `start` varchar(100) NOT NULL,
  `dest` varchar(100) NOT NULL,
  `sdate` varchar(20) NOT NULL,
  `till` varchar(20) NOT NULL,
  `km` int(11) NOT NULL,
  `contact` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userbook`
--

INSERT INTO `userbook` (`licence`, `cartype`, `start`, `dest`, `sdate`, `till`, `km`, `contact`) VALUES
('dl100', 'mini', 'jnu', 'new delhi', '06\\01\\2020', '04\\01\\2020', 15, 9715432675),
('dl1234', 'mini', 'jnu', 'new delhi', '06\\01\\2020', '04\\01\\2020', 16, 7568943215);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`carid`);

--
-- Indexes for table `newuser`
--
ALTER TABLE `newuser`
  ADD PRIMARY KEY (`licid`),
  ADD UNIQUE KEY `licid` (`licid`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`licid`,`carid`);

--
-- Indexes for table `receive`
--
ALTER TABLE `receive`
  ADD PRIMARY KEY (`licid`);

--
-- Indexes for table `userbook`
--
ALTER TABLE `userbook`
  ADD PRIMARY KEY (`licence`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
