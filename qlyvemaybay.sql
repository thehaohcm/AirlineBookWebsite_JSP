-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: qlvemaybay
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `chuyenbay`
--

DROP TABLE IF EXISTS `chuyenbay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chuyenbay` (
  `MaCB` varchar(45) NOT NULL,
  `Hang` varchar(45) DEFAULT NULL,
  `NgayDi` varchar(45) DEFAULT NULL,
  `GioDi` varchar(45) DEFAULT NULL,
  `NgayDen` varchar(45) DEFAULT NULL,
  `GioDen` varchar(45) DEFAULT NULL,
  `DiaDiem_Di` int(11) DEFAULT NULL,
  `DiaDiem_Den` int(11) DEFAULT NULL,
  `GiaVe` int(11) DEFAULT NULL,
  `SLHKHT` int(11) DEFAULT '0',
  `SLHKTD` int(11) DEFAULT '300',
  PRIMARY KEY (`MaCB`),
  KEY `Fk_CB_DD_DDi_idx` (`DiaDiem_Di`),
  KEY `Fk_CB_DD_DDen_idx` (`DiaDiem_Den`),
  CONSTRAINT `Fk_CB_DD_DDen` FOREIGN KEY (`DiaDiem_Den`) REFERENCES `diadiem` (`MaDD`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `Fk_CB_DD_DDi` FOREIGN KEY (`DiaDiem_Di`) REFERENCES `diadiem` (`MaDD`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chuyenbay`
--

LOCK TABLES `chuyenbay` WRITE;
/*!40000 ALTER TABLE `chuyenbay` DISABLE KEYS */;
INSERT INTO `chuyenbay` VALUES ('0001','VietNam Airline','02-04-2016','18:00','02-04-2016','19:00',2,3,1000000,24,300),('0002','VietJet Air','03-04-2016','14:00','03-04-2016','15:00',1,2,300000,0,300),('0004','JetStar Airways','06-04-2016','16:00','06-04-2016','19:00',3,1,400000,3,400),('0008','VietJet Air','04-05-2016','5:00','04-05-2016','8:00',1,3,400,2,300),('kae','VietNam AirlIne   ','12-05-2017','15:00','29-05-2016','18:00',3,1,453,0,5);
/*!40000 ALTER TABLE `chuyenbay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diadiem`
--

DROP TABLE IF EXISTS `diadiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diadiem` (
  `MaDD` int(11) NOT NULL AUTO_INCREMENT,
  `TenDD` varchar(45) DEFAULT NULL,
  `TenSB` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaDD`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diadiem`
--

LOCK TABLES `diadiem` WRITE;
/*!40000 ALTER TABLE `diadiem` DISABLE KEYS */;
INSERT INTO `diadiem` VALUES (1,'Hà Nội','Nội Bài'),(2,'Hải Phòng','Cát Bi'),(3,'Tp. Hồ Chí Minh','Tân Sơn Nhất'),(4,'Đà Nẵng','Quốc tế Đà Nẵng'),(5,'fae','fa');
/*!40000 ALTER TABLE `diadiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hanhkhach`
--

DROP TABLE IF EXISTS `hanhkhach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hanhkhach` (
  `MaHK` int(11) NOT NULL AUTO_INCREMENT,
  `HoTen` varchar(45) DEFAULT NULL,
  `CMND` varchar(45) DEFAULT NULL,
  `SoDT` varchar(45) DEFAULT NULL,
  `DChi` varchar(45) DEFAULT NULL,
  `HanhLy` float DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaHK`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hanhkhach`
--

LOCK TABLES `hanhkhach` WRITE;
/*!40000 ALTER TABLE `hanhkhach` DISABLE KEYS */;
INSERT INTO `hanhkhach` VALUES (2,'Nguyễn Văn B','28382048','1938394329','25 Đinh Tiên Hoàng, Phường 4, Quận Bình Thạnh',3.5,'akeb@kaie.com'),(3,'Lê Hoàng C','92930329','4924929108','43 Lý Thường Kiệt phường 10, Quận Tân Phú',10,'fake@fake.org'),(31,'Trần Văn A','025025025','0909099509','TPHCM',12,'mxkxl@cks.com'),(32,'vcgfdf','124567892111','0900000069','92 Hàm Tử',4,'thehaohcm@yahoo.com.vn'),(33,'xcxcvvc','124567892111','0900000069','92 Hàm Tử',2,'thehaohcm@yahoo.com.vn'),(37,'srdfsdf','124567892111','0900000069','92 Hàm Tử',4,'thehaohcm@yahoo.com.vn');
/*!40000 ALTER TABLE `hanhkhach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taikhoan` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('admin','admin'),('root','root');
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ve`
--

DROP TABLE IF EXISTS `ve`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ve` (
  `MaCB` varchar(45) NOT NULL,
  `MaHK` int(11) NOT NULL,
  `GiaVe` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaCB`,`MaHK`),
  KEY `Fk_MaHK_idx` (`MaHK`),
  CONSTRAINT `Fk_MaCB` FOREIGN KEY (`MaCB`) REFERENCES `chuyenbay` (`MaCB`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_MaHK` FOREIGN KEY (`MaHK`) REFERENCES `hanhkhach` (`MaHK`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ve`
--

LOCK TABLES `ve` WRITE;
/*!40000 ALTER TABLE `ve` DISABLE KEYS */;
INSERT INTO `ve` VALUES ('0001',3,NULL),('0001',31,1000000),('0001',32,1000000),('0001',33,1000000),('0002',2,NULL),('0008',37,400);
/*!40000 ALTER TABLE `ve` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-18 13:14:12
