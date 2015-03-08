CREATE TABLE `contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
INSERT INTO `contact` (`name`, `phone_number`) VALUES ('lance', '4438373837');
INSERT INTO `contact` (`name`, `phone_number`) VALUES ('bill', '3837636371');
INSERT INTO `contact` (`name`, `phone_number`) VALUES ('tony', '9383736373');
INSERT INTO `contact` (`name`, `phone_number`) VALUES ('harry', '3383736353');