CREATE DATABASE elearning;
USE elearning;

CREATE TABLE `answerinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answerdata` longblob,
  `courseid` int(11) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `result` varchar(255) DEFAULT NULL,
  `studentid` int(11) DEFAULT NULL,
  `totquestions` int(11) DEFAULT NULL,
  `totrightanswers` int(11) DEFAULT NULL,
  `totwronganswers` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `courseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createddate` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `subscriptionfee` varchar(255) DEFAULT NULL,
  `teacherid` varchar(255) DEFAULT NULL,
  `updateddate` date DEFAULT NULL,
  `active` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `coursename` varchar(255) DEFAULT NULL,
  `difficultylevel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

CREATE TABLE `questioninfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(255) DEFAULT NULL,
  `courseid` int(11) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `opt1` varchar(255) DEFAULT NULL,
  `opt2` varchar(255) DEFAULT NULL,
  `opt3` varchar(255) DEFAULT NULL,
  `opt4` varchar(255) DEFAULT NULL,
  `questionimage` longblob,
  `questiontext` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  `updateddate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

CREATE TABLE `studentinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addressline1` varchar(255) DEFAULT NULL,
  `addressline2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contactnumber` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `emailid` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `instname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `middlename` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updateddate` date DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

CREATE TABLE `teacherinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addressline1` varchar(255) DEFAULT NULL,
  `addressline2` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `contactnumber` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `createddate` date DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `emailid` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `instname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `middlename` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `updateddate` date DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



