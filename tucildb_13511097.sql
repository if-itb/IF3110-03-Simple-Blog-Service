-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2014 at 06:54 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tucildb_13511097`
--

-- --------------------------------------------------------

--
-- Table structure for table `listpost`
--

CREATE TABLE IF NOT EXISTS `listpost` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `post` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `listpost`
--

INSERT INTO `listpost` (`id`, `title`, `date`, `post`) VALUES
(0, 'Coba coba c', '2014-10-04', 'adfadfadfasjovpwe\r\nasj;ljdvowiejflfovioqepfjkld;vj;lsdngaoiefw0oevnowiegnwoietnoehnapsdvhnaospienghtwohngdbnvsnvsakdvn,vc.v.c\r\nfl;asdjfowejv?d\r\noasdjfaosdphgoebowgngnwlgndoodinviocvnw'),
(1, 'Post baru', '2014-09-05', 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa'),
(2, 'tes', '2014-10-10', 'sdfadsfasdfasdf'),
(3, 'Raja Temporasi rangga', '2015-03-10', 'chkfhmvghkf');

-- --------------------------------------------------------

--
-- Table structure for table `post-komen`
--

CREATE TABLE IF NOT EXISTS `post-komen` (
  `myID` int(11) NOT NULL,
  `id_post` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tanggal` datetime NOT NULL,
  `isi` text NOT NULL,
  PRIMARY KEY (`myID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post-komen`
--

INSERT INTO `post-komen` (`myID`, `id_post`, `nama`, `email`, `tanggal`, `isi`) VALUES
(0, 0, 'Anu', 'anggapardana.geraldi@gmail.coma', '2014-10-14 12:41:28', 'tes'),
(1, 0, 'geraldi', 'anggapardana.geraldi@gmail.co', '2014-10-14 12:41:48', 'tes lagi'),
(2, 0, 'asdfasdf', 'anggapardana.geraldi@gmail.co', '2014-10-14 13:43:59', 'coba'),
(3, 3, 'geraldi', 'anggapardana.geraldi@gmail.coma', '2014-10-14 02:20:00', 'huaahahahaha'),
(4, 3, 'geraldi', 'anggapardana.geraldi@gmail.coms', '2014-10-14 14:20:34', 'lhooo?????????'),
(5, 3, 'akbar', 'ajs.ffh@gmail.hc', '2014-10-15 08:52:56', 'fghfghfg');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(0, 'geraldi', '123', 'owner'),
(1, 'fawwaz', '123', 'admin'),
(2, 'Koji', '123', 'Editor');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
