-- MySQL Workbench Synchronization
-- Generated: 2015-02-11 18:57
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Bruno

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

ALTER TABLE `s2aei_beta_db`.`project` 
DROP FOREIGN KEY `student_member`;

ALTER TABLE `s2aei_beta_db`.`project` 
DROP COLUMN `student_member`,
DROP INDEX `student_member_idx` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
