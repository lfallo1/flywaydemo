ALTER TABLE `contact` 
ADD COLUMN `email` VARCHAR(45) NULL AFTER `phone_number`;

update `contact` set email = 'f@gmail.com' where name = 'lance';
update `contact` set email = 'b@yahoo.com' where name = 'bill';
update `contact` set email = 't@hotmail.com' where name = 'tony';
update `contact` set email = 'harry@gmail.com' where name = 'harry';