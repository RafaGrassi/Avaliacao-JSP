-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema blog
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema blog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `blog` DEFAULT CHARACTER SET utf8 ;
USE `blog` ;

-- -----------------------------------------------------
-- Table `blog`.`artigo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog`.`artigo` (
  `idartigo` INT NOT NULL AUTO_INCREMENT,
  `tituloartigo` VARCHAR(200) NULL,
  `conteudoartigo` TEXT(60000) NULL,
  PRIMARY KEY (`idartigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog`.`comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog`.`comentario` (
  `idcomentario` INT NOT NULL AUTO_INCREMENT,
  `conteudocomentario` TEXT(2000) NULL,
  `aceito` INT NULL DEFAULT 0,
  `idartigo` INT NULL,
  PRIMARY KEY (`idcomentario`),
  INDEX `idartigo_idx` (`idartigo` ASC) VISIBLE,
  CONSTRAINT `idartigo`
    FOREIGN KEY (`idartigo`)
    REFERENCES `blog`.`artigo` (`idartigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog`.`usuario` (
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `tipo` INT NULL DEFAULT 0,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
COMMENT = '	';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
