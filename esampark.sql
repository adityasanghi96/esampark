-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.37-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema suvidha
--

CREATE DATABASE IF NOT EXISTS suvidha;
USE suvidha;

--
-- Definition of table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`id`,`username`,`password`,`name`) VALUES 
 (1,'admin','1234567','');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


--
-- Definition of table `chlaan`
--

DROP TABLE IF EXISTS `chlaan`;
CREATE TABLE `chlaan` (
  `c_id` int(10) unsigned NOT NULL auto_increment,
  `vehicle` varchar(45) NOT NULL,
  `chlaan_type` varchar(45) NOT NULL,
  `fine` varchar(45) NOT NULL,
  `fine_paid` varchar(45) NOT NULL default '0',
  `balance` varchar(45) NOT NULL default '0',
  `status` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chlaan`
--

/*!40000 ALTER TABLE `chlaan` DISABLE KEYS */;
INSERT INTO `chlaan` (`c_id`,`vehicle`,`chlaan_type`,`fine`,`fine_paid`,`balance`,`status`) VALUES 
 (1,'PB-07-2234','Helmet','500','0','0',0),
 (2,'PB-07-1234','License','1000','0','0',0);
/*!40000 ALTER TABLE `chlaan` ENABLE KEYS */;


--
-- Definition of table `electricity_bill`
--

DROP TABLE IF EXISTS `electricity_bill`;
CREATE TABLE `electricity_bill` (
  `e_id` int(10) unsigned NOT NULL auto_increment,
  `meter_no` varchar(45) NOT NULL,
  `unit_consumed` varchar(45) NOT NULL,
  `bill` varchar(45) NOT NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electricity_bill`
--

/*!40000 ALTER TABLE `electricity_bill` DISABLE KEYS */;
INSERT INTO `electricity_bill` (`e_id`,`meter_no`,`unit_consumed`,`bill`) VALUES 
 (1,'571','100','100'),
 (2,'572','300','1804'),
 (3,'573','400','2400');
/*!40000 ALTER TABLE `electricity_bill` ENABLE KEYS */;


--
-- Definition of table `electricitysum`
--

DROP TABLE IF EXISTS `electricitysum`;
CREATE TABLE `electricitysum` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `meter` varchar(45) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `num` varchar(45) NOT NULL,
  `app` varchar(45) NOT NULL,
  `bank` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `electricitysum`
--

/*!40000 ALTER TABLE `electricitysum` DISABLE KEYS */;
INSERT INTO `electricitysum` (`id`,`meter`,`amount`,`date`,`type`,`num`,`app`,`bank`) VALUES 
 (1,'571','500','27/03/2017','Cash','','','');
/*!40000 ALTER TABLE `electricitysum` ENABLE KEYS */;


--
-- Definition of table `employee_register`
--

DROP TABLE IF EXISTS `employee_register`;
CREATE TABLE `employee_register` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `userid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `joining` varchar(45) NOT NULL,
  `shift` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `street` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee_register`
--

/*!40000 ALTER TABLE `employee_register` DISABLE KEYS */;
INSERT INTO `employee_register` (`id`,`name`,`userid`,`password`,`gender`,`joining`,`shift`,`phone`,`state`,`city`,`street`,`email`) VALUES 
 (9,'Puneet','Ee2ot8','1234567','Male','123456789','Water Bill','2fghjhggg','fghjklhgjkl.','ertyuio','wertyui','fghjklhgjkl.'),
 (10,'Manish','E7xpqb','E7xpqb','Male','18/06/2013','Electricity Bill','96754776','dfghjk','fghjkl','dfghjk','manish.mahindru@hotmail.com'),
 (11,'Rohit','E0w2es','E0w2es','Male','18/06/2013','Water Bill','1234567890','dfghjkl','dfghjk','qwertyujkl','rohit.dhoni@hotmail.com');
/*!40000 ALTER TABLE `employee_register` ENABLE KEYS */;


--
-- Definition of table `water_bill`
--

DROP TABLE IF EXISTS `water_bill`;
CREATE TABLE `water_bill` (
  `m_id` int(10) unsigned NOT NULL auto_increment,
  `meter_no` varchar(45) NOT NULL,
  `unit_consumed` varchar(45) NOT NULL,
  `bill` varchar(45) NOT NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `water_bill`
--

/*!40000 ALTER TABLE `water_bill` DISABLE KEYS */;
INSERT INTO `water_bill` (`m_id`,`meter_no`,`unit_consumed`,`bill`) VALUES 
 (1,'571','100','-3803'),
 (2,'572','120','720'),
 (3,'573','200','1200'),
 (4,'574','50','300'),
 (5,'123','90','540');
/*!40000 ALTER TABLE `water_bill` ENABLE KEYS */;


--
-- Definition of table `watersum`
--

DROP TABLE IF EXISTS `watersum`;
CREATE TABLE `watersum` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `meter` varchar(45) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `num` varchar(45) NOT NULL,
  `app` varchar(45) NOT NULL,
  `bank` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `watersum`
--

/*!40000 ALTER TABLE `watersum` DISABLE KEYS */;
INSERT INTO `watersum` (`id`,`meter`,`amount`,`date`,`type`,`num`,`app`,`bank`) VALUES 
 (1,'571','677','27/03/2017','Cash','','','');
/*!40000 ALTER TABLE `watersum` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
