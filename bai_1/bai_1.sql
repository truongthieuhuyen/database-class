#CREATE SCHEMA `student_cms_plusplus` DEFAULT CHARACTER SET utf8mb4 ;

CREATE TABLE `student_cms_plusplus`.`class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(250) DEFAULT NULL,
  `major` varchar(250) DEFAULT NULL,
  `total_student` int DEFAULT NULL,
  `teacher_name` varchar(250) DEFAULT NULL,
  `teacher_phone` int DEFAULT NULL,
  `created` timestamp(6) NULL DEFAULT NULL,
  `last_updated` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`class_id`)
);
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) DEFAULT NULL,
  `mssv` varchar(12) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `address` varchar(250) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `email` varchar(250) DEFAULT NULL,
  `created` timestamp(6) NULL DEFAULT NULL,
  `last_updated` timestamp(6) NULL DEFAULT NULL,
  PRIMARY KEY (`student_id`)
);
CREATE TABLE `student_class` (
    `student_id` INT DEFAULT NULL,
    `class_id` INT DEFAULT NULL
)
