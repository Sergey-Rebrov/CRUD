CREATE TABLE `test`.`user` (
  `id` INT(8) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(25) NOT NULL,
  `age` INT NOT NULL,
  `isAdmin` BIT(2) NOT NULL,
  `createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `test`.`user` (`name`, `age`, `isAdmin`) VALUES
('Petr', '45', 1),
('Ivan', '28', 0),
('Nick', '32', 0),
('Katy', '19', 0),
('John', '26', 0),
('Sergey', '51', 0),
('Egor', '24', 0),
('Anton', '29', 0),
('Arnold', '35', 0),
('Ivan', '22', 0),
('Ivar', '18', 1),
('Stas', '19', 0),
('Natalya', '21', 0),
('Karolina', '22', 0),
('Tatiana', '23', 0),
('Petra', '24', 0),
('Ekaterina', '25', 0),
('Leonid', '26', 0),
('Evgeniy', '27', 1),
('Kruger', '28', 1),
('Ivan', '29', 0),
('Anna', '30', 0),
('Dmitriy', '31', 0),
('Alex', '32', 0),
('Alexey', '33', 0),
('Rosana', '34', 0),
('Kirk', '35', 1),
('Keith', '36', 0),
('Kris', '37', 0),
('Tomas', '38', 1),
('Jessica', '39', 0),
('Josh', '40', 1);