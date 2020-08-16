-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 16, 2020 at 02:46 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.2.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `progProj`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookBorrowing`
--

CREATE TABLE `bookBorrowing` (
  `bb_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `b_title` varchar(50) NOT NULL,
  `date_b` varchar(10) NOT NULL,
  `date_r` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookBorrowing`
--

INSERT INTO `bookBorrowing` (`bb_id`, `u_id`, `b_title`, `date_b`, `date_r`) VALUES
(12, 15, 'book1', '5/5/5', '10/5/5'),
(13, 15, 'book2', '5/5/5', '10/5/5'),
(14, 16, 'book3', '5/5/5', '5/5/5'),
(15, 16, 'book4', '5/5/5', '5/5/5'),
(16, 17, 'book5', '6/6/6', '6/6/6'),
(17, 17, 'book1', '5/5/5', '5/5/5'),
(18, 18, 'book7', '5\\5\\2020', '10\\5\\2020'),
(19, 18, 'book6', '5\\5\\2020', '10\\5\\2020'),
(20, 18, 'book2', '5/5/2020', '10/5/2020'),
(21, 18, 'book3', '5/5/2020', '5/5/2020'),
(22, 1, 'book4', '12/2/2019', '15/2/2019'),
(24, 19, 'peter pan', '2/4/2019', '4/4/2019'),
(25, 1, 'super hero', '5/5/2019', '5/5/2019'),
(26, 20, 'go with me', '5/5/2020', '5/5/2020'),
(27, 21, 'book2', '5/5/2020', '10/5/2020'),
(28, 22, 'run away', '2/2/2019', '5/2/2019'),
(29, 1, 'book8', '12/12/2019', '15/12/2019');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `b_id` int(11) NOT NULL,
  `b_title` varchar(50) NOT NULL,
  `auther` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `genre` varchar(50) NOT NULL,
  `status` varchar(11) NOT NULL DEFAULT 'available',
  `uid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`b_id`, `b_title`, `auther`, `description`, `genre`, `status`, `uid`) VALUES
(45, 'book1', 'book1', 'book1', 'Drama', 'Unavailable', 14),
(47, 'book2', 'book2', 'book2', 'adventure', 'Unavailable', 14),
(49, 'book3', 'book3', 'book3', 'adventure', 'Unavailable', 15),
(50, 'book4', 'book4', 'book4', 'Fantasy', 'Unavailable', 15),
(51, 'book5', 'book5', 'book5', 'Drama', 'Unavailable', 16),
(52, 'book6', 'book6', 'book6', 'Horror', 'Available', 17),
(54, 'book7', 'book7', 'book7', 'adventure', 'Unavailable', 17),
(55, 'book8', 'book8', 'book8', 'Fantasy', 'Unavailable', 18),
(57, 'book9', 'book9', 'book9', 'Drama', 'Available', 18),
(58, 'run away', 'willam', 'run from the truth', 'Action', 'Unavailable', 1),
(59, 'peter pan', 'willam', 'neverland', 'Fantasy', 'Unavailable', 1),
(60, 'magic shop', 'bangtan', 'The book follows a group of', 'Drama', 'Available', 1),
(61, 'super hero', 'JK', 'hero', 'Action', 'Unavailable', 19),
(62, 'go with me', 'sara D', 'go naw', 'adventure', 'Unavailable', 19),
(63, 'book10', 'book10', 'book10', 'Comic book', 'Available', 20),
(64, 'book11', 'book10', 'book10', 'Romance', 'Available', 20),
(65, 'book12', 'book12', 'book12', 'Horror', 'Available', 21),
(66, 'book20', 'book2222', 'book20', 'adventure', 'Available', 22),
(69, 'The Great Gatsby', 'f', 'f', 'Drama', 'Available', 1),
(71, 'The Great Getsby', 'F. Scott Fitzgerald', 'Follows a cast of characters living in the fictional towns of West Egg and East Egg on prosperous Long Island in the summer of 1922.', 'Drama', 'Available', 23),
(72, 'Rebecca', 'Daphne du Maurier', 'concerns an unnamed young woman who impetuously marries a wealthy widower, only to discover that he and his household are haunted by the memory of his late first wife', 'Mystery', 'Available', 23),
(73, 'Macbeth', '.', '.', 'Drama', 'Available', 23);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `u_id` int(11) NOT NULL,
  `f_name` varchar(20) NOT NULL,
  `l_name` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`u_id`, `f_name`, `l_name`, `password`, `email`) VALUES
(1, 'mary', 'abdulaziz', '123', 'm@g.com'),
(14, 'reem', 'reem', '123', 'r@g.com'),
(15, 'test2', 'test2', '123', 'test2@g.com'),
(16, 'test1', 'test1', '123', 'test1@g.com'),
(17, 'test3', 'test3', '123', 'test3@g.com'),
(18, 'test4', 'test4', '123', 'test4@g.com'),
(19, 'lana', 'do', '123', 'lana@gmail.com'),
(20, 'test5', 'test5', '123', 'test5@g.com'),
(21, 'test6', 'test6', '123', 'test6@g.com'),
(22, 'test7', 'test7', '123', 'test7@g.com'),
(23, 'reem', 's', '1', 'r');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookBorrowing`
--
ALTER TABLE `bookBorrowing`
  ADD PRIMARY KEY (`bb_id`),
  ADD KEY `fk_uid` (`u_id`),
  ADD KEY `fk_btitle` (`b_title`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`b_id`),
  ADD UNIQUE KEY `b_title` (`b_title`),
  ADD KEY `fk_u_id` (`uid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`u_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookBorrowing`
--
ALTER TABLE `bookBorrowing`
  MODIFY `bb_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `b_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookBorrowing`
--
ALTER TABLE `bookBorrowing`
  ADD CONSTRAINT `fk_btitle` FOREIGN KEY (`b_title`) REFERENCES `books` (`b_title`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_uid` FOREIGN KEY (`u_id`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `books`
--
ALTER TABLE `books`
  ADD CONSTRAINT `fk_u_id` FOREIGN KEY (`uid`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
