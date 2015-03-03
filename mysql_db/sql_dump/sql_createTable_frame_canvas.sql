CREATE TABLE `s2aei_beta_db`.`frame_canvas` (
  `idframe_canvas` INT NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(45) NULL,
  `note` INT NULL,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`idframe_canvas`),
  UNIQUE INDEX `idframe_canvas_UNIQUE` (`idframe_canvas` ASC));