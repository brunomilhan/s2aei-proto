-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema s2aei_beta_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema s2aei_beta_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `s2aei_beta_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `s2aei_beta_db` ;

-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`student` (
  `idstudent` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cad_date` DATE NULL,
  `last_mod` DATE NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  `student_number` INT NOT NULL,
  `course` VARCHAR(45) NULL,
  `period` INT NULL,
  `projects` INT NULL,
  `project_leader` INT NULL,
  PRIMARY KEY (`idstudent`),
  UNIQUE INDEX `idstudent_UNIQUE` (`idstudent` ASC),
  INDEX `project_leader_idx` (`project_leader` ASC),
  CONSTRAINT `project_leader`
    FOREIGN KEY (`project_leader`)
    REFERENCES `s2aei_beta_db`.`project` (`idproject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`student_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`student_project` (
  `idstudent_project` INT NOT NULL AUTO_INCREMENT,
  `student` INT NULL,
  `project` INT NULL,
  PRIMARY KEY (`idstudent_project`),
  UNIQUE INDEX `idstudent_project_UNIQUE` (`idstudent_project` ASC),
  INDEX `student_idx` (`student` ASC),
  INDEX `project_student_idx` (`project` ASC),
  CONSTRAINT `student_project`
    FOREIGN KEY (`student`)
    REFERENCES `s2aei_beta_db`.`student` (`idstudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_student`
    FOREIGN KEY (`project`)
    REFERENCES `s2aei_beta_db`.`project` (`idproject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`knowledge_area`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`knowledge_area` (
  `idknowledge_area` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`idknowledge_area`),
  UNIQUE INDEX `idknowledge_area_UNIQUE` (`idknowledge_area` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`teacher` (
  `idteacher` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cad_date` DATE NULL,
  `last_mod` DATE NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  `department` VARCHAR(45) NULL,
  `main_disc` VARCHAR(45) NULL,
  `project_guides` INT NULL,
  PRIMARY KEY (`idteacher`),
  UNIQUE INDEX `idteacher_UNIQUE` (`idteacher` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`project` (
  `idproject` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `leader` INT NULL,
  `creation_date` DATE NULL,
  `last_mod` DATE NULL,
  `status` VARCHAR(45) NULL,
  `student_member` INT NULL,
  `knowledge_area` INT NULL,
  `teacher_ad` INT NULL,
  `text_xml` VARCHAR(45) NULL,
  `answers` VARCHAR(45) NULL,
  PRIMARY KEY (`idproject`),
  UNIQUE INDEX `idproject_UNIQUE` (`idproject` ASC),
  INDEX `student_member_idx` (`student_member` ASC),
  INDEX `leader_idx` (`leader` ASC),
  INDEX `know_area_idx` (`knowledge_area` ASC),
  INDEX `teacher_ad_idx` (`teacher_ad` ASC),
  CONSTRAINT `student_member`
    FOREIGN KEY (`student_member`)
    REFERENCES `s2aei_beta_db`.`student_project` (`idstudent_project`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `leader`
    FOREIGN KEY (`leader`)
    REFERENCES `s2aei_beta_db`.`student` (`idstudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `know_area`
    FOREIGN KEY (`knowledge_area`)
    REFERENCES `s2aei_beta_db`.`knowledge_area` (`idknowledge_area`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `teacher_ad`
    FOREIGN KEY (`teacher_ad`)
    REFERENCES `s2aei_beta_db`.`teacher` (`idteacher`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`admin` (
  `idadmin` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cad_date` DATE NULL,
  `last_mod` DATE NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  PRIMARY KEY (`idadmin`),
  UNIQUE INDEX `idadmin_UNIQUE` (`idadmin` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`reviewer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`reviewer` (
  `idreviewer` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `cad_date` DATE NULL,
  `last_mod` DATE NULL,
  `status` VARCHAR(45) NOT NULL DEFAULT 'active',
  `know_area` INT NULL,
  `degree` VARCHAR(45) NULL,
  PRIMARY KEY (`idreviewer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `s2aei_beta_db`.`projects_reviewer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `s2aei_beta_db`.`projects_reviewer` (
  `idprojects_reviewer` INT NOT NULL AUTO_INCREMENT,
  `reviewer` INT NULL,
  `project` INT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idprojects_reviewer`),
  INDEX `reviewer_idx` (`reviewer` ASC),
  INDEX `project_idx` (`project` ASC),
  UNIQUE INDEX `idprojects_revised_UNIQUE` (`idprojects_reviewer` ASC),
  CONSTRAINT `reviewer_id`
    FOREIGN KEY (`reviewer`)
    REFERENCES `s2aei_beta_db`.`reviewer` (`idreviewer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `project_id`
    FOREIGN KEY (`project`)
    REFERENCES `s2aei_beta_db`.`project` (`idproject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
