CREATE DATABASE elearning;
USE elearning;

DROP TABLE IF EXISTS TEACHERINFO;
DROP TABLE IF EXISTS STUDENTINFO;
DROP TABLE IF EXISTS COURSEINFO;
DROP TABLE IF EXISTS QUESTIONINFO;
DROP TABLE IF EXISTS ANSWERINFO;

CREATE TABLE TEACHERINFO (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  PASSWORD VARCHAR(255) NOT NULL,
  FIRSTNAME VARCHAR(255) NOT NULL,
  MIDDLENAME VARCHAR(255) DEFAULT NULL,
  LASTNAME VARCHAR(255) DEFAULT NULL,
  DOB DATE DEFAULT NULL,
  EMAILID VARCHAR(255) UNIQUE NOT NULL,
  INSTNAME VARCHAR(255) NOT NULL,
  CONTACTNUMBER VARCHAR(100) NOT NULL,
  ADDRESSLINE1 TEXT NOT NULL,
  ADDRESSLINE2 TEXT DEFAULT NULL,
  CITY VARCHAR(255) NOT NULL,
  STATE VARCHAR(255) NOT NULL,
  COUNTRY VARCHAR(255) NOT NULL,
  ZIPCODE VARCHAR(25) NOT NULL,
  STATUS VARCHAR(25) DEFAULT NULL,
  CREATEDDATE DATE DEFAULT NULL,
  UPDATEDDATE DATE DEFAULT NULL
);

CREATE TABLE STUDENTINFO (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  PASSWORD VARCHAR(255) NOT NULL,
  FIRSTNAME VARCHAR(255) NOT NULL,
  MIDDLENAME VARCHAR(255) DEFAULT NULL,
  LASTNAME VARCHAR(255) DEFAULT NULL,
  DOB DATE DEFAULT NULL,
  EMAILID VARCHAR(255) UNIQUE NOT NULL,
  INSTNAME VARCHAR(255) NOT NULL,
  CONTACTNUMBER VARCHAR(100) NOT NULL,
  ADDRESSLINE1 TEXT NOT NULL,
  ADDRESSLINE2 TEXT DEFAULT NULL,
  CITY VARCHAR(255) NOT NULL,
  STATE VARCHAR(255) NOT NULL,
  COUNTRY VARCHAR(255) NOT NULL,
  ZIPCODE VARCHAR(25) NOT NULL,
  STATUS VARCHAR(25) DEFAULT NULL,
  CREATEDDATE DATE DEFAULT NULL,
  UPDATEDDATE DATE DEFAULT NULL
);

CREATE TABLE COURSEINFO (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  NAME TEXT NOT NULL,
  DESCRIPTION TEXT DEFAULT NULL,
  TEACHERID INT NOT NULL,
  SUBSCRIPTIONFEE FLOAT DEFAULT NULL,
  STATUS VARCHAR(25) DEFAULT NULL,
  CREATEDDATE DATE DEFAULT NULL,
  UPDATEDDATE DATE DEFAULT NULL
);

CREATE TABLE QUESTIONINFO (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  QUESTIONTEXT TEXT NOT NULL,
  QUESTIONIMAGE BLOB DEFAULT NULL,
  OPT1 TEXT NOT NULL,
  OPT2 TEXT NOT NULL,
  OPT3 TEXT DEFAULT NULL,
  OPT4 TEXT DEFAULT NULL,
  OPT5 TEXT DEFAULT NULL,
  ANSWER VARCHAR(50) NOT NULL,
  TEACHERID INT NOT NULL,
  COURSEID INT NOT NULL,
  STATUS VARCHAR(25) DEFAULT NULL,
  CREATEDDATE DATE DEFAULT NULL,
  UPDATEDDATE DATE DEFAULT NULL
);

CREATE TABLE ANSWERINFO (
  ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  STUDENTID INT NOT NULL,
  COURSEID INT NOT NULL,
  ANSWERDATA BLOB NOT NULL,
  TOTQUESTIONS INT NOT NULL,
  TOTRIGHTANSWERS INT NOT NULL,
  TOTWRONGANSWERS INT NOT NULL,  
  RESULT VARCHAR(255) NOT NULL,
  CREATEDDATE DATE DEFAULT NULL
);