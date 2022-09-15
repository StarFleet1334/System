SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Phones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Phones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `age` INT UNSIGNED NOT NULL,
  `phones_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Users_Phones_idx` (`phones_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_Phones`
    FOREIGN KEY (`phones_id`)
    REFERENCES `mydb`.`Phones` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Specs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Specs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `operating_system` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `memory` INT NOT NULL,
  `system_manufacturer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Technologies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Technologies` (
  `id_technologies` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pc` TINYINT NULL,
  `leptop` TINYINT NULL,
  `specs` INT NOT NULL,
  PRIMARY KEY (`id_technologies`),
  INDEX `fk_Technologies_Specs1_idx` (`specs` ASC) VISIBLE,
  CONSTRAINT `fk_Technologies_Specs1`
    FOREIGN KEY (`specs`)
    REFERENCES `mydb`.`Specs` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Owns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Owns` (
  `user_id` INT NOT NULL,
  `technology_id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  INDEX `fk_Owns_Users1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_Owns_Technologies1_idx` (`technology_id` ASC) VISIBLE,
  PRIMARY KEY (`user_id`, `technology_id`),
  CONSTRAINT `fk_Owns_Users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Owns_Technologies1`
    FOREIGN KEY (`technology_id`)
    REFERENCES `mydb`.`Technologies` (`id_technologies`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CodeSalaries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CodeSalaries` (
  `id_code` INT NOT NULL AUTO_INCREMENT,
  `salary` DOUBLE UNSIGNED NOT NULL,
  PRIMARY KEY (`id_code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jobs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Jobs` (
  `id_jobs` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `code` INT NOT NULL,
  PRIMARY KEY (`id_jobs`),
  INDEX `fk_Jobs_CodeSalaries1_idx` (`code` ASC) VISIBLE,
  CONSTRAINT `fk_Jobs_CodeSalaries1`
    FOREIGN KEY (`code`)
    REFERENCES `mydb`.`CodeSalaries` (`id_code`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Works`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Works` (
  `users_id` INT NOT NULL,
  `jobs_id` INT NOT NULL,
  `start_date` TIMESTAMP(2) NOT NULL,
  INDEX `fk_Works_Users1_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_Works_Jobs1_idx` (`Jobs_id_jobs` ASC) VISIBLE,
  PRIMARY KEY (`users_id`, `Jobs_id_jobs`),
  CONSTRAINT `fk_Works_Users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Works_Jobs1`
    FOREIGN KEY (`Jobs_id_jobs`)
    REFERENCES `mydb`.`Jobs` (`id_jobs`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EmailsStorage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EmailsStorage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email_from_user` INT NOT NULL,
  `email_to_user` INT NOT NULL,
  `text` VARCHAR(45) NULL,
  `time` TIMESTAMP(2) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_EmailsStorage_Users1_idx` (`email_from_user` ASC) VISIBLE,
  INDEX `fk_EmailsStorage_Users2_idx` (`email_to_user` ASC) VISIBLE,
  CONSTRAINT `fk_EmailsStorage_Users1`
    FOREIGN KEY (`email_from_user`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_EmailsStorage_Users2`
    FOREIGN KEY (`email_to_user`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`CallsStorage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`CallsStorage` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `from_user` INT NOT NULL,
  `to_user` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_CallsStorage_idx` (`from_user` ASC) VISIBLE,
  INDEX `fk_CallsStorage_idx1` (`to_user` ASC) VISIBLE,
  CONSTRAINT `fk_CallsStorage1`
    FOREIGN KEY (`from_user`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_CallsStorage2`
    FOREIGN KEY (`to_user`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Calls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Calls` (
  `user_id` INT NOT NULL,
  `calls_storage_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `calls_storage_id`),
  INDEX `fk_Users_has_CallsStorage_CallsStorage1_idx` (`calls_storage_id` ASC) VISIBLE,
  INDEX `fk_Users_has_CallsStorage_Users1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_CallsStorage_Users1`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Users_has_CallsStorage_CallsStorage1`
    FOREIGN KEY (`calls_storage_id`)
    REFERENCES `mydb`.`CallsStorage` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Emails`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Emails` (
  `users_id` INT NOT NULL,
  `emails_storage_id` INT NOT NULL,
  PRIMARY KEY (`Users_id`, `EmailsStorage_id`),
  INDEX `fk_Users_has_EmailsStorage_EmailsStorage1_idx` (`EmailsStorage_id` ASC) VISIBLE,
  INDEX `fk_Users_has_EmailsStorage_Users1_idx` (`Users_id` ASC) VISIBLE,
  CONSTRAINT `fk_Users_has_EmailsStorage_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `mydb`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Users_has_EmailsStorage_EmailsStorage1`
    FOREIGN KEY (`EmailsStorage_id`)
    REFERENCES `mydb`.`EmailsStorage` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;