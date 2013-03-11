ALTER TABLE `playermanager`.`players` ADD COLUMN `allergies` VARCHAR(45) AFTER `club`,
 ADD COLUMN `notes` VARCHAR(256) AFTER `allergies`;
 

ALTER TABLE `playermanager`.`players` 
ADD UNIQUE INDEX `name` (`name` ASC, `club` ASC) ;

ALTER TABLE `playermanager`.`players` DROP FOREIGN KEY `fk_players_clubs` ;
ALTER TABLE `playermanager`.`players` DROP COLUMN `club` 
, DROP INDEX `name` 
, ADD UNIQUE INDEX `name` (`name` ASC) 
, DROP INDEX `fk_players_clubs` ;
