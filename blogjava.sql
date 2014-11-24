-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2014 at 07:31 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `blogjava`
--

-- --------------------------------------------------------

--
-- Table structure for table `blogpost`
--

CREATE TABLE IF NOT EXISTS `blogpost` (
  `pid` int(5) NOT NULL AUTO_INCREMENT,
  `posttitle` varchar(100) NOT NULL,
  `postcontent` text NOT NULL,
  `postdate` date NOT NULL,
  `published` tinyint(1) NOT NULL DEFAULT '0',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `komentar`
--

CREATE TABLE IF NOT EXISTS `komentar` (
  `cid` int(3) NOT NULL AUTO_INCREMENT,
  `pid` int(3) NOT NULL,
  `komentator` varchar(20) NOT NULL,
  `komen` text NOT NULL,
  `email` varchar(30) NOT NULL,
  `commentdate` date NOT NULL,
  PRIMARY KEY (`cid`),
  KEY `fk.pid` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(3) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`uid`, `username`, `password`, `role`, `email`) VALUES
(1, 'ucup', 'ucup', 'owner', 'ucup@gmail.com'),
(2, 'nisa', 'nisa', 'editor', 'nisa@gmail.com'),
(3, 'hayyu', 'hayyu', 'admin', 'hayyu@gmail.com'),
(4, 'guest', 'guest', 'guest', 'guest@gmail.com');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `komentar`
--
ALTER TABLE `komentar`
  ADD CONSTRAINT `fk.pid` FOREIGN KEY (`pid`) REFERENCES `blogpost` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
