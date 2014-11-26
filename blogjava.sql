-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3307
-- Generation Time: 26 Nov 2014 pada 13.20
-- Versi Server: 5.6.16
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
-- Struktur dari tabel `blogpost`
--

CREATE TABLE IF NOT EXISTS `blogpost` (
  `pid` int(5) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `posttitle` varchar(100) NOT NULL,
  `postcontent` text NOT NULL,
  `postdate` date NOT NULL,
  `published` tinyint(1) NOT NULL DEFAULT '0',
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pid`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data untuk tabel `blogpost`
--

INSERT INTO `blogpost` (`pid`, `uid`, `posttitle`, `postcontent`, `postdate`, `published`, `deleted`) VALUES
(7, 1, 'Post Pertamaku', 'ieu post pertama kuring', '2014-11-25', 1, 0),
(8, 1, 'Post Keduaku', 'ieu post Kedua kuring', '2014-11-25', 1, 0),
(9, 1, 'Post ketigaku', 'isi Post ketiga', '2014-11-25', 0, 0),
(10, 2, 'post pertama nisa', 'nisa dian lalala', '2014-11-26', 1, 0),
(11, 2, 'dadada', 'lalala', '2014-11-29', 0, 0),
(12, 2, 'dadada', 'lalala', '2014-12-29', 0, 0),
(13, 2, 'dadada2', 'lalala2', '2014-10-26', 0, 0),
(14, 2, 'dadada2', 'lalala2', '2014-11-01', 0, 0),
(15, 3, 'lala hayyu', 'hayuuu hayyu', '2014-11-26', 0, 0),
(16, 2, 'dadada2', 'lalala2', '2014-12-01', 0, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `komentar`
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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `uid` int(3) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(32) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`uid`, `fullname`, `username`, `password`, `role`, `email`) VALUES
(1, 'Yusuf Rahmatullah', 'ucup', 'ucup', 'owner', 'ucup@gmail.com'),
(2, 'Nisa Dian Rachmadi', 'nisa', 'nisa', 'editor', 'nisa@gmail.com'),
(3, 'Hayyu Luthfi Hanifah', 'hayyu', 'hayyu', 'admin', 'hayyu@gmail.com');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `blogpost`
--
ALTER TABLE `blogpost`
  ADD CONSTRAINT `fk.uid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `komentar`
--
ALTER TABLE `komentar`
  ADD CONSTRAINT `fk.pid` FOREIGN KEY (`pid`) REFERENCES `blogpost` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
