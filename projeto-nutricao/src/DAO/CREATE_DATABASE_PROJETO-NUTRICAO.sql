-- MySQL Script generated by MySQL Workbench
-- 10/25/17 08:10:23
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TAB_ALIMENTO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TAB_ALIMENTO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TAB_ALIMENTO` (
  `ID` INT NOT NULL,
  `NOME` VARCHAR(45) NULL,
  `DESCRICAO` VARCHAR(45) NULL,
  `TIPO` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TAB_NUTRIENTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TAB_NUTRIENTE` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TAB_NUTRIENTE` (
  `ID` INT NOT NULL,
  `NOME` VARCHAR(45) NULL,
  `QTD` FLOAT NULL,
  `TAB_ALIMENTO_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `TAB_ALIMENTO_ID`),
  INDEX `fk_TAB_NUTRIENTE_TAB_ALIMENTO_idx` (`TAB_ALIMENTO_ID` ASC),
  CONSTRAINT `fk_TAB_NUTRIENTE_TAB_ALIMENTO`
    FOREIGN KEY (`TAB_ALIMENTO_ID`)
    REFERENCES `mydb`.`TAB_ALIMENTO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TAB_REFEICAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TAB_REFEICAO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TAB_REFEICAO` (
  `ID` INT NOT NULL,
  `NOME` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TAB_PESSOA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TAB_PESSOA` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TAB_PESSOA` (
  `ID` INT NOT NULL,
  `NOME` VARCHAR(45) NULL,
  `IDADE` INT NULL,
  `EMAIL` VARCHAR(100) NULL,
  `LOGIN` VARCHAR(45) NULL,
  `SENHA` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TAB_ALIMENTO_has_TAB_REFEICAO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TAB_ALIMENTO_has_TAB_REFEICAO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TAB_ALIMENTO_has_TAB_REFEICAO` (
  `TAB_ALIMENTO_ID` INT NOT NULL,
  `TAB_REFEICAO_ID` INT NOT NULL,
  `QTD_ALIMENTO` FLOAT,
  PRIMARY KEY (`TAB_ALIMENTO_ID`, `TAB_REFEICAO_ID`),
  INDEX `fk_TAB_ALIMENTO_has_TAB_REFEICAO_TAB_REFEICAO1_idx` (`TAB_REFEICAO_ID` ASC),
  INDEX `fk_TAB_ALIMENTO_has_TAB_REFEICAO_TAB_ALIMENTO1_idx` (`TAB_ALIMENTO_ID` ASC),
  CONSTRAINT `fk_TAB_ALIMENTO_has_TAB_REFEICAO_TAB_ALIMENTO1`
    FOREIGN KEY (`TAB_ALIMENTO_ID`)
    REFERENCES `mydb`.`TAB_ALIMENTO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TAB_ALIMENTO_has_TAB_REFEICAO_TAB_REFEICAO1`
    FOREIGN KEY (`TAB_REFEICAO_ID`)
    REFERENCES `mydb`.`TAB_REFEICAO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TAB_REFEICAO_has_TAB_PESSOA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`TAB_REFEICAO_has_TAB_PESSOA` ;

CREATE TABLE IF NOT EXISTS `mydb`.`TAB_REFEICAO_has_TAB_PESSOA` (
  `TAB_REFEICAO_ID` INT NOT NULL,
  `TAB_PESSOA_ID` INT NOT NULL,
  `HORARIO` DATETIME NULL,
  `PRECO` FLOAT NULL,
  PRIMARY KEY (`TAB_REFEICAO_ID`, `TAB_PESSOA_ID`),
  INDEX `fk_TAB_REFEICAO_has_TAB_PESSOA_TAB_PESSOA1_idx` (`TAB_PESSOA_ID` ASC),
  INDEX `fk_TAB_REFEICAO_has_TAB_PESSOA_TAB_REFEICAO1_idx` (`TAB_REFEICAO_ID` ASC),
  CONSTRAINT `fk_TAB_REFEICAO_has_TAB_PESSOA_TAB_REFEICAO1`
    FOREIGN KEY (`TAB_REFEICAO_ID`)
    REFERENCES `mydb`.`TAB_REFEICAO` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TAB_REFEICAO_has_TAB_PESSOA_TAB_PESSOA1`
    FOREIGN KEY (`TAB_PESSOA_ID`)
    REFERENCES `mydb`.`TAB_PESSOA` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;