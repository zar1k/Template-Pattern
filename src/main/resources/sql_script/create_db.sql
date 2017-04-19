-- -----------------------------------------------------
-- Schema template_pattern_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `template_pattern_db`
  DEFAULT CHARACTER SET utf8;
USE `template_pattern_db`;

-- -----------------------------------------------------
-- Table `template_pattern_db`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `template_pattern_db`.`role` (
  `ID`   INT         NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `template_pattern_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `template_pattern_db`.`users` (
  `ID`         INT         NOT NULL AUTO_INCREMENT,
  `LOGIN`      VARCHAR(45) NOT NULL,
  `PASSWORD`   VARCHAR(45) NOT NULL,
  `FIRST_NAME` VARCHAR(45) NOT NULL,
  `LAST_NAME`  VARCHAR(45) NOT NULL,
  `AGE`        INT         NOT NULL,
  `ROLE_ID`    INT         NOT NULL,
  PRIMARY KEY (`ID`, `ROLE_ID`),
  UNIQUE INDEX `LOGIN_UNIQUE` (`LOGIN` ASC),
  INDEX `fk_users_role_idx` (`ROLE_ID` ASC),
  CONSTRAINT `fk_users_role`
  FOREIGN KEY (`ROLE_ID`)
  REFERENCES `template_pattern_db`.`role` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
