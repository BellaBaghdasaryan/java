SET SQL_SAFE_UPDATES=0;

delete from `brs`.`reserve`;

delete from `brs`.`bus`;
ALTER TABLE `brs`.`bus` AUTO_INCREMENT = 200;

delete from `brs`.`route`;
ALTER TABLE `brs`.`route` AUTO_INCREMENT = 10;

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Vanadzor','Yerevan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Yerevan','Gyumri');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Gyumri','Vanadzor');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Yerevan','Vanadzor');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Gyumri','Yerevan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Abovyan','Yerevan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Yerevan','Abovyan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Hrazdan','Yerevan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Yerevan','Hrazdan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Dilijan','Yerevan');

INSERT INTO `brs`.`route` (origin,destination) VALUES ('Yerevan','Dilijan');


INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (10,1,1600,'20:00','09:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (10,0,1700,'20:00','06:30');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (10,1,2000,'21:00','07:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (11,0,1500,'18:00','05:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (12,0,1200,'20:00','09:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (12,1,2100,'20:00','18:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,0,1700,'21:30','19:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,0,800,'14:00','09:30');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,1,700,'20:00','19:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (14,0,300,'20:00','09:00');

INSERT INTO `brs`.`bus` (routeid,ac,fare,departuretime,arrivaltime) VALUES (13,1,1800,'19:10','17:00');
