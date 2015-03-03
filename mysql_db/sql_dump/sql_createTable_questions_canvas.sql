CREATE TABLE `s2aei_beta_db`.`questions_canvas` (
  `idquestions_canvas` INT NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(300) NULL,
  `description` VARCHAR(500) NULL,
  `response` VARCHAR(300) NULL,
  `status` VARCHAR(45) NULL,
  `note` INT NULL,
  `project` INT NULL,
  `frame_canvas` INT NULL,
  PRIMARY KEY (`idquestions_canvas`),
  UNIQUE INDEX `idquestions_canvas_UNIQUE` (`idquestions_canvas` ASC),
  INDEX `project_fk_idx` (`project` ASC),
  INDEX `frame_fk_idx` (`frame_canvas` ASC),
  CONSTRAINT `project_fk`
    FOREIGN KEY (`project`)
    REFERENCES `s2aei_beta_db`.`project` (`idproject`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `frame_fk`
    FOREIGN KEY (`frame_canvas`)
    REFERENCES `s2aei_beta_db`.`frame_canvas` (`idframe_canvas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
