-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Inang: 127.0.0.1
-- Waktu pembuatan: 25 Nov 2014 pada 20.44
-- Versi Server: 5.5.32
-- Versi PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Basis data: `tubes_wbd`
--
CREATE DATABASE IF NOT EXISTS `tubes_wbd` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `tubes_wbd`;

-- --------------------------------------------------------

--
-- Struktur dari tabel `comment`
--

CREATE TABLE IF NOT EXISTS `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `post_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`comment_id`,`user_id`,`post_id`),
  KEY `user_id` (`user_id`),
  KEY `post_id` (`post_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data untuk tabel `comment`
--

INSERT INTO `comment` (`comment_id`, `user_id`, `post_id`, `content`, `date`) VALUES
(7, 'guest', 3, 'dascaca', '2014-11-26 01:28:00'),
(8, 'Daniar', 3, 'dascaca', '2014-11-26 01:33:24'),
(9, 'Daniar Heri', 3, 'cdslcnlsdcnlsdncs', '2014-11-26 01:34:31'),
(10, 'Husein', 3, 'ncsdlcnsdlcnlsdcm', '2014-11-26 01:39:05'),
(11, 'Danodws', 4, 'mlcnmlsdknls', '2014-11-26 01:39:34'),
(12, 'ewdawf', 3, 'fewaf', '2014-11-26 02:08:55');

-- --------------------------------------------------------

--
-- Struktur dari tabel `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `date` datetime NOT NULL,
  `published` tinyint(1) NOT NULL,
  `deleted` tinyint(1) NOT NULL,
  PRIMARY KEY (`post_id`,`user_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `post`
--

INSERT INTO `post` (`post_id`, `user_id`, `title`, `content`, `date`, `published`, `deleted`) VALUES
(3, 'admin', 'wowowowowoowwo', 'lorem ipsum dvdvfvdvdvdffvvdfvolor sir amet cdscsdcsdc dscscsdc', '7715-02-11 00:00:00', 1, 0),
(4, 'admin', 'new post', 'sadasdsafasfasfsa cdscs', '5815-02-12 00:00:00', 1, 0),
(5, 'owner', 'edit wahahahaha', 'dfdsfsdvsdvfbreg', '5814-12-09 00:00:00', 0, 0),
(6, 'guest', 'dcscsca', 'csvsvdsv', '3914-12-11 00:00:00', 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `password`, `role`) VALUES
('admin', 'admin', 3),
('editor', 'editor', 2),
('gilang', 'wohoho', 1),
('guest', '', 4),
('owner', 'owner', 1);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
