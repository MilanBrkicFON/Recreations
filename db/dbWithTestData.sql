/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.6.17 : Database - pssunce
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`pssunce` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `pssunce`;

/*Table structure for table `clan` */

DROP TABLE IF EXISTS `clan`;

CREATE TABLE `clan` (
  `clanID` int(11) NOT NULL AUTO_INCREMENT,
  `imeRoditelja` varchar(50) DEFAULT NULL,
  `godinaUpisa` int(4) DEFAULT NULL,
  `idOsoba` int(11) DEFAULT NULL,
  KEY `idOsoba` (`idOsoba`),
  KEY `clanID` (`clanID`),
  CONSTRAINT `clan_ibfk_1` FOREIGN KEY (`idOsoba`) REFERENCES `osoba` (`idOsoba`)
) ENGINE=InnoDB AUTO_INCREMENT=1100 DEFAULT CHARSET=latin1;

/*Data for the table `clan` */

insert  into `clan`(`clanID`,`imeRoditelja`,`godinaUpisa`,`idOsoba`) values 
(1003,'Zdravko',2017,1050),
(1004,'Tomislav',2017,NULL),
(1005,'Dragan',2017,1002),
(1006,'Dragan',2017,1001),
(1028,'Zorica',2014,1005),
(1029,'Zorica',2017,1007),
(1030,'Marija',2016,1006),
(1031,'Bane',2015,1003),
(1033,'Dragan',2016,1004),
(1035,'Marko',2016,NULL),
(1049,'Mirko',2015,1055),
(1050,NULL,0,1056),
(1051,NULL,0,1057),
(1052,NULL,0,1058),
(1053,NULL,0,1059),
(1054,NULL,0,1060),
(1055,NULL,0,1061),
(1056,NULL,0,1062),
(1057,NULL,0,1063),
(1058,NULL,0,1064),
(1059,NULL,0,1065),
(1060,NULL,0,1066),
(1061,NULL,0,1067),
(1062,NULL,0,1068),
(1063,NULL,0,1069),
(1064,NULL,0,1070),
(1065,NULL,0,1071),
(1066,NULL,0,1072),
(1067,NULL,0,1073),
(1068,NULL,0,1074),
(1069,NULL,0,1075),
(1070,NULL,0,1076),
(1071,NULL,0,1077),
(1072,NULL,0,1078),
(1073,NULL,0,1079),
(1074,NULL,0,1080),
(1075,NULL,0,1081),
(1076,NULL,0,1082),
(1077,NULL,0,1083),
(1078,NULL,0,1084),
(1079,NULL,0,1085),
(1080,NULL,0,1086),
(1081,NULL,0,1087),
(1082,NULL,0,1088),
(1083,NULL,0,1089),
(1084,NULL,0,1090),
(1085,NULL,0,1091),
(1086,NULL,0,1092),
(1087,NULL,0,1093),
(1088,NULL,0,1094),
(1089,NULL,0,1095),
(1090,NULL,0,1096),
(1091,NULL,0,1097),
(1092,NULL,0,1098),
(1093,NULL,0,1099),
(1094,NULL,0,1100),
(1095,NULL,0,1101),
(1096,NULL,0,1102),
(1097,NULL,0,1103),
(1098,NULL,0,1104),
(1099,NULL,0,1105);

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `osoba` int(11) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `osoba` (`osoba`),
  CONSTRAINT `korisnik_ibfk_1` FOREIGN KEY (`osoba`) REFERENCES `osoba` (`idOsoba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `korisnik` */

insert  into `korisnik`(`username`,`password`,`osoba`) values 
('1111','63ed116de8eebf05ad5705daed353781daa51224aa8f36e02acfac76c6cdd444',1001),
('2222','ec4e5c7c0a1a3895674b3f9f65923437cd28a6b8a9b63d8444da0152801eaa18',1),
('k1','66f2cbf2c8f3188ae85ccc3d6bdac1fd05bc7f03f2bf066325e6211d20d6bd5b',1057),
('k10','7dc5964952f32de0be2bbaf366d5dbef0b6de89e19c4954e95dd5b2a13c9c21a',1066),
('k11','842073b32a63d96ae2d84f97e66ff9da4ba9150140525c9b7bbd5f33b2579213',1067),
('k12','500ffb51b2b028ef76042516e60f466217be8df90c154344dceb7ebc48c2aedb',1068),
('k13','d025da28c1e3b8c42b4173e428ae4c5242e26cbfd775986524d920dcfc38b902',1069),
('k14','2cba06b274a576c6aefc1e6b26aa7da43aba1585fb879fa934c2433862e1625f',1070),
('k15','48377d6ab8e708a49eb60139e713b22e31676e28b7135923c8027acfc14bdf33',1071),
('k16','457b05c7eb237de213139836c07a43c55ecb15b323958dbc825f2a989fceffcb',1072),
('k17','ebdd87093905c3d2ce3afe92225fd814b7bc2391d62df77ab32a7cc2a7f6c18f',1073),
('k18','a5fb0b6b6a0b23d2a686707e2d704188f6c0111b19c0fa8ecb98188e59415f41',1074),
('k19','46e94af901787a454bbf5d3fee62ef6955f68572c431745f181445611868de1d',1075),
('k2','cd9edc37c3187e1f7c23987bd35616d7c068f4a60c4abddc2d0b84fe8ab3de89',1058),
('k20','f9c2e816c27e8c8253e4f23e39b6d99b95093979ad9c92e7458115b3d45fb9ad',1076),
('k21','ebb7e3cbca342ee3506ea53e7eb0a23bc9004da391c7b612a861d2279eaa8bd1',1077),
('k22','9e7993494f75a0654826a07aa4c25d8209fda490a6df2b8a487df0ed8c3cbb5b',1078),
('k23','4d4297f0418f044fcf299b6796b5f9b4eed3b9d1cb90d82e9c241e8004ada460',1079),
('k24','34de41f7584f908d337ef1bad96f47a31179f776d1634cd7e648c7f2353d5171',1080),
('k25','4e1d9de6cb61720859d2c1948e5be7de1313cd96542bf9e02e99ea009f53ec54',1081),
('k26','3d321a7634d168e2f752cbe97347ecc7f9599d339f2a35567df2b95f47066bd3',1082),
('k27','bba33c048b02bda89bf1d8fc783e61dd1bf59eedf62b4f6969a8f7c1ef4943cf',1083),
('k28','cd7fca0160aa2b42afd0f2df242f8cb1dfb83f5f0a9cea4ea8d08db6ea67437a',1084),
('k29','76c26bed49d0d4a4d7590a468b7909179622c63482611dccf88ac746dc8723df',1085),
('k3','d9db0a2dcd0274da38d43ed96caa8d33d8dc93b95647ce6a8a3f0a4c2575e55b',1059),
('k30','8eb361d40b2cea862c572949139284bb53bf9863adc131bcfc9cce4c049355d1',1086),
('k31','9120f5ebe66bbe2ad2b2a497fabe67d8604cc4b358cb757f8591a41f7900808c',1087),
('k32','8adf7a6044c89a4dd88d63c1537d2b025d2b873e3aeb3c5bca2e74487f39e0bd',1088),
('k33','6f7cf4f0e0268954e9ffc7e022a504c3e57d949f983735f3271293c1548bfa33',1089),
('k34','03a5a80b12c19a14e6b2be89603da83de0ebe790560bf030a7ade8b0ad92b63a',1090),
('k35','20cc6bce8166d971682fb3d7e002ac5a3685839007721b61b74edd6f50cb4597',1091),
('k36','7e9f3edfcfa08b8457f6522d4fd8d0b433720d76bd228dc504608e39dafa2f23',1092),
('k37','b628d9c9b7387e3a6c3023688cb2fd495ceda69d71a307d25351b0923318d4a7',1093),
('k38','d4f5d02b593aed38a019fc9de9a155df173596f8c21513fa256a8a219f74b0e7',1094),
('k39','a30d1f30d82217daeb3c217fbc722e1490dc3b1d4179c76f74d223f0c6661f13',1095),
('k4','e08425b9625b5af44d508f81f4aaddd8d3e19435967abcc6b2f3d9fd63d76363',1060),
('k40','f1c076e41938851f1291db064d908e2fa2017374d78ddc41ac40b7f53a2707a9',1096),
('k41','d759382038ca791445955c78cc304db37cffda4bf28af740ca5f3400c502a9e9',1097),
('k42','49f9d7471cf04e009b402eb439ac73b67d1abaa78f2999d3671975d8fdaea2a2',1098),
('k43','bf636e489f0f027e6e242a3ff71e774d614decc1c50d23dd9777e95eb7f6f01a',1099),
('k44','d1e89008a5b57cd0671d65676be28ec6c0f5969e4c77ceb6bf7a89b44a28bae5',1100),
('k45','3bbff4128f6751b9a3f1ea9dffbf6417c9e412c570d1d2bd59bd165f1067b7e1',1101),
('k46','bda15920d2756e093d8501a3bff8af19d1900f882c384eae6c4ce1ccffd96320',1102),
('k47','8521d9b4915eb2782463b93458dba9378175533c8a04b1fd4412955e0d619699',1103),
('k48','ffdbaac298e48ce6991fc60de4da190d8a2228929e072ce01b67366c1ab74551',1104),
('k49','f9699600d80c6ee47279e86756ca6b812fd068d02a1ba0450738d80a154ac76c',1105),
('k5','159ec864fe3d92c144d4e6f5fe7304f3a50f244ff8550a6d1a37ea5d3c052145',1061),
('k6','cae0fd8b045f86d64bc31b7f776e8a87fd03444c7417b02fec0375ec867219ea',1062),
('k7','00acccb0fae58af9d020f4cc212581b3debb723f109d65052cb0fb72438d1a94',1063),
('k8','ad92f08ef4556eaafaf89532bd4d6a3acc394f388981f2ccaf40b8884166022a',1064),
('k9','9bc26f746f0ff27e02818af270c4bd69bfeb26d67ef9f3bb9425cb9611bddd50',1065),
('milan@yahoo.com','eeb9bb390f1a97e53f21be06110582faa6925a04fc33cfa7c15d8dd37a3d82d7',1050);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `ptt` int(6) NOT NULL,
  `nazivMesta` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ptt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mesto` */

insert  into `mesto`(`ptt`,`nazivMesta`) values 
(11000,'Beograd'),
(11070,'Novi Beograd'),
(11080,'Zemun'),
(11271,'Surcin'),
(16000,'Leskovac'),
(17500,'Vranje'),
(21000,'Novi Sad'),
(37000,'Krusevac');

/*Table structure for table `osoba` */

DROP TABLE IF EXISTS `osoba`;

CREATE TABLE `osoba` (
  `tip` char(5) DEFAULT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `datumRodjenja` date DEFAULT NULL,
  `pol` char(1) DEFAULT NULL,
  `idOsoba` int(11) NOT NULL AUTO_INCREMENT,
  `mesto` int(11) DEFAULT NULL,
  PRIMARY KEY (`idOsoba`),
  KEY `mesto` (`mesto`)
) ENGINE=InnoDB AUTO_INCREMENT=1106 DEFAULT CHARSET=latin1;

/*Data for the table `osoba` */

insert  into `osoba`(`tip`,`ime`,`prezime`,`datumRodjenja`,`pol`,`idOsoba`,`mesto`) values 
('T','Zarko','Koprivica','1985-02-25','M',1,21000),
('T','Marina','Jovanovic','1981-06-22','Z',2,37000),
('T','Dusan','Savic','1978-09-12','M',3,37000),
('T','Jelisaveta','Krstic','1991-01-15','Z',4,11080),
('N/A','Milan','Brkic',NULL,'\0',5,11070),
('C','Milena','Brkic','1994-08-07','Z',1001,11070),
('C','Nina','Stevic','1994-05-19','Z',1002,11070),
('C','Marko','Banduka','1994-07-27','M',1003,11070),
('C','Stefan ','Krstic','1993-08-25','M',1004,11070),
('C','Marko ','Arandjelovic','1994-02-01','M',1005,11271),
('C','Nemanja','Slavic','1994-09-28','M',1006,11271),
('C','Nikola','Dimic','1993-09-15','M',1007,17500),
('C','Milan','Milan','2010-02-17','M',1050,11000),
('C','ime1','M','0000-00-00','1',1052,0),
('C','ime2','prezime2','1994-05-21','M',1055,11000),
('C','clan_ime0','clan_prezime0','1984-06-13','M',1056,11000),
('C','clan_ime1','clan_prezime1','1995-06-07','M',1057,11000),
('C','clan_ime2','clan_prezime2','1989-02-28','M',1058,11000),
('C','clan_ime3','clan_prezime3','2013-08-11','M',1059,11000),
('C','clan_ime4','clan_prezime4','1982-11-18','M',1060,11000),
('C','clan_ime5','clan_prezime5','1972-05-16','M',1061,11000),
('C','clan_ime6','clan_prezime6','1997-01-09','M',1062,11000),
('C','clan_ime7','clan_prezime7','1978-11-16','M',1063,11000),
('C','clan_ime8','clan_prezime8','1992-03-14','M',1064,11000),
('C','clan_ime9','clan_prezime9','1972-06-25','M',1065,11000),
('C','clan_ime10','clan_prezime10','2013-04-16','M',1066,11000),
('C','clan_ime11','clan_prezime11','1990-12-05','M',1067,11000),
('C','clan_ime12','clan_prezime12','2013-02-06','M',1068,11000),
('C','clan_ime13','clan_prezime13','1971-03-09','M',1069,11000),
('C','clan_ime14','clan_prezime14','2001-04-01','M',1070,11000),
('C','clan_ime15','clan_prezime15','1984-05-25','M',1071,11000),
('C','clan_ime16','clan_prezime16','1988-09-28','M',1072,11000),
('C','clan_ime17','clan_prezime17','1975-11-21','M',1073,11000),
('C','clan_ime18','clan_prezime18','2000-12-29','M',1074,11000),
('C','clan_ime19','clan_prezime19','1974-12-04','M',1075,11000),
('C','clan_ime20','clan_prezime20','1973-12-13','M',1076,11000),
('C','clan_ime21','clan_prezime21','1986-05-21','M',1077,11000),
('C','clan_ime22','clan_prezime22','2006-01-17','M',1078,11000),
('C','clan_ime23','clan_prezime23','1993-09-14','M',1079,11000),
('C','clan_ime24','clan_prezime24','1994-01-27','M',1080,11000),
('C','clan_ime25','clan_prezime25','1970-05-19','M',1081,11000),
('C','clan_ime26','clan_prezime26','2008-02-29','M',1082,11000),
('C','clan_ime27','clan_prezime27','1990-04-03','M',1083,11000),
('C','clan_ime28','clan_prezime28','1973-02-22','M',1084,11000),
('C','clan_ime29','clan_prezime29','1991-05-04','M',1085,11000),
('C','clan_ime30','clan_prezime30','2008-07-29','M',1086,11000),
('C','clan_ime31','clan_prezime31','2013-02-02','M',1087,11000),
('C','clan_ime32','clan_prezime32','2000-08-11','M',1088,11000),
('C','clan_ime33','clan_prezime33','1994-05-27','M',1089,11000),
('C','clan_ime34','clan_prezime34','1976-12-16','M',1090,11000),
('C','clan_ime35','clan_prezime35','2003-01-16','M',1091,11000),
('C','clan_ime36','clan_prezime36','1993-01-17','M',1092,11000),
('C','clan_ime37','clan_prezime37','1991-03-24','M',1093,11000),
('C','clan_ime38','clan_prezime38','2002-10-08','M',1094,11000),
('C','clan_ime39','clan_prezime39','2000-09-22','M',1095,11000),
('C','clan_ime40','clan_prezime40','1994-04-10','M',1096,11000),
('C','clan_ime41','clan_prezime41','1972-03-13','M',1097,11000),
('C','clan_ime42','clan_prezime42','1996-11-26','M',1098,11000),
('C','clan_ime43','clan_prezime43','2013-11-19','M',1099,11000),
('C','clan_ime44','clan_prezime44','1972-09-01','M',1100,11000),
('C','clan_ime45','clan_prezime45','1996-04-03','M',1101,11000),
('C','clan_ime46','clan_prezime46','2004-01-12','M',1102,11000),
('C','clan_ime47','clan_prezime47','2006-05-05','M',1103,11000),
('C','clan_ime48','clan_prezime48','1984-11-11','M',1104,11000),
('C','clan_ime49','clan_prezime49','2004-09-19','M',1105,11000);

/*Table structure for table `relationship` */

DROP TABLE IF EXISTS `relationship`;

CREATE TABLE `relationship` (
  `osoba_1_id` int(11) NOT NULL,
  `osoba_2_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL,
  `akcija_osoba_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`osoba_1_id`,`osoba_2_id`),
  KEY `osoba_2_id` (`osoba_2_id`),
  KEY `akcija_osoba_id` (`akcija_osoba_id`),
  CONSTRAINT `relationship_ibfk_1` FOREIGN KEY (`osoba_1_id`) REFERENCES `osoba` (`idOsoba`),
  CONSTRAINT `relationship_ibfk_2` FOREIGN KEY (`osoba_2_id`) REFERENCES `osoba` (`idOsoba`),
  CONSTRAINT `relationship_ibfk_3` FOREIGN KEY (`akcija_osoba_id`) REFERENCES `osoba` (`idOsoba`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `relationship` */

insert  into `relationship`(`osoba_1_id`,`osoba_2_id`,`status`,`akcija_osoba_id`) values 
(1001,1002,1,NULL),
(1001,1003,1,NULL);

/*Table structure for table `sport` */

DROP TABLE IF EXISTS `sport`;

CREATE TABLE `sport` (
  `sportID` int(11) NOT NULL,
  `nazivSporta` varchar(20) DEFAULT NULL,
  `maxBrClanova` int(11) DEFAULT NULL,
  PRIMARY KEY (`sportID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sport` */

insert  into `sport`(`sportID`,`nazivSporta`,`maxBrClanova`) values 
(1,'Kosarka',20),
(2,'Mali fudbal',25),
(3,'Odbojka',22),
(4,'Rukomet',30),
(5,'Fudbal',40),
(6,'Stoni tenis',4);

/*Table structure for table `tclan` */

DROP TABLE IF EXISTS `tclan`;

CREATE TABLE `tclan` (
  `clanId` int(11) NOT NULL,
  `treningId` int(11) NOT NULL,
  PRIMARY KEY (`clanId`,`treningId`),
  KEY `tclan_ibfk_3` (`treningId`),
  CONSTRAINT `tclan_ibfk_4` FOREIGN KEY (`clanId`) REFERENCES `clan` (`idOsoba`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tclan_ibfk_3` FOREIGN KEY (`treningId`) REFERENCES `trening` (`treningId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tclan` */

insert  into `tclan`(`clanId`,`treningId`) values 
(1006,1),
(1001,4),
(1003,4),
(1004,4),
(1006,4),
(1001,5),
(1002,7);

/*Table structure for table `trener` */

DROP TABLE IF EXISTS `trener`;

CREATE TABLE `trener` (
  `idOsoba` int(11) DEFAULT NULL,
  `trenerID` int(11) DEFAULT NULL,
  `godineRada` int(11) DEFAULT NULL,
  `kratakCV` varchar(1000) DEFAULT NULL,
  `sportID` int(11) DEFAULT NULL,
  KEY `sportID` (`sportID`),
  KEY `idOsoba` (`idOsoba`),
  CONSTRAINT `trener_ibfk_2` FOREIGN KEY (`idOsoba`) REFERENCES `osoba` (`idOsoba`),
  CONSTRAINT `trener_ibfk_1` FOREIGN KEY (`sportID`) REFERENCES `sport` (`sportID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `trener` */

insert  into `trener`(`idOsoba`,`trenerID`,`godineRada`,`kratakCV`,`sportID`) values 
(1,201,4,'Zavrsio dif sa prosecnom ocenom 9. Radio 2 godine u Italiji za klub OKS.',3),
(2,202,5,'Isla sam u Francusku....',1),
(3,204,8,'Zavrsio DIF u Beogradu sa prosecnom ocenom 8,9. Tokom studiranja radio sam kao pomocni trener u FK Borcanac i tako stekao dosta iskustva. Nakon zavrsetka fakulteta radio sam kao trener poletarcima u osnovnoj skoli Branko Radicevic.\n',1),
(4,205,4,'Zavrsio DIF u Beogradu sa prosecnom ocenom 8,9. Tokom studiranja radio sam kao pomocni trener u FK Borcanac i tako stekao dosta iskustva. Nakon zavrsetka fakulteta radio sam kao trener poletarcima u osnovnoj skoli Branko Radicevic.\n',3);

/*Table structure for table `trening` */

DROP TABLE IF EXISTS `trening`;

CREATE TABLE `trening` (
  `treningId` int(11) NOT NULL AUTO_INCREMENT,
  `vremeOd` time NOT NULL,
  `vremeDo` time NOT NULL,
  `datum` date NOT NULL,
  `sport` int(11) DEFAULT NULL,
  PRIMARY KEY (`treningId`),
  KEY `sport` (`sport`),
  CONSTRAINT `trening_ibfk_1` FOREIGN KEY (`sport`) REFERENCES `sport` (`sportID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `trening` */

insert  into `trening`(`treningId`,`vremeOd`,`vremeDo`,`datum`,`sport`) values 
(1,'11:00:00','12:00:00','2017-06-26',3),
(2,'15:00:00','16:30:00','2017-06-26',3),
(3,'11:30:00','13:00:00','2017-06-27',2),
(4,'14:00:00','15:00:00','2017-06-27',5),
(5,'20:00:00','21:00:00','2017-06-27',1),
(7,'10:00:00','11:00:00','2017-06-28',1);

/*Table structure for table `tt` */

DROP TABLE IF EXISTS `tt`;

CREATE TABLE `tt` (
  `trenerId` int(11) NOT NULL,
  `treningId` int(11) NOT NULL,
  PRIMARY KEY (`trenerId`,`treningId`),
  KEY `tt_ibfk_4` (`treningId`),
  CONSTRAINT `tt_ibfk_3` FOREIGN KEY (`trenerId`) REFERENCES `trener` (`idOsoba`) ON DELETE CASCADE,
  CONSTRAINT `tt_ibfk_4` FOREIGN KEY (`treningId`) REFERENCES `trening` (`treningId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tt` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `mobile` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `address1` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`first_name`,`last_name`,`email`,`password`,`mobile`,`address1`) values 
(1,'Aleksandar','Devic','vicde@gmail.com','e10adc3949ba59abbe56e057f20f883e','0644560426','Cara Dusana 17'),
(2,'Aleksandar','Devic','email@gmail.com','827ccb0eea8a706c4c34a16891f84e7b','1234567890','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
