INSERT INTO `template_pattern_db`.`role` (`ID`, `NAME`) VALUES ('1', 'ADMIN');
INSERT INTO `template_pattern_db`.`role` (`ID`, `NAME`) VALUES ('2', 'MODERATOR');
INSERT INTO `template_pattern_db`.`role` (`ID`, `NAME`) VALUES ('3', 'USER');

INSERT INTO `template_pattern_db`.`users` (`ID`, `LOGIN`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `AGE`, `ROLE_ID`)
VALUES ('1', 'admin', 'admin', 'Lester  ', 'Crawford', '20', '1');
INSERT INTO `template_pattern_db`.`users` (`ID`, `LOGIN`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `AGE`, `ROLE_ID`)
VALUES ('2', 'moderator', 'moderator', 'Michael', 'Greer', '25', '2');
INSERT INTO `template_pattern_db`.`users` (`ID`, `LOGIN`, `PASSWORD`, `FIRST_NAME`, `LAST_NAME`, `AGE`, `ROLE_ID`)
VALUES ('3', 'user', 'user', 'Elfreda', 'Owens', '30', '3');
