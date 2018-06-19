INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Marko','Juric','admin1@gmail.com','admin111','M.Maric');
INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Aleksandra','Grujic','admin2@gmail.com','admin222','Detelinara');
INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Damjan','Nicic','admin3@gmail.com','admin333','Z.Stanica');
INSERT INTO `xmlback`.`role` (`roleid`,`role`) VALUES ('1','USER');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`role_roleid`) VALUES ('Dragan','Dulic',1,0,'1');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`) VALUES ('Nikola','Nikolic',1,0);
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`) VALUES ('Jovana','Jovanic',1,0);
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`) VALUES ('Milos','Petrovic',1,0);
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`) VALUES ('Jelena','Antic',1,0);
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`) VALUES ('Stefan','Ivanovic',1,0);
INSERT INTO `xmlback`.`agent` (`name`, `surname`,`email`,`password`,`address`,`businessregnum`,`approved`) VALUES ('Mino','Raiola','mino@gmail.com','123','Bul.Oslobodjenja','455',0);
INSERT INTO `xmlback`.`agent` (`name`, `surname`,`email`,`password`,`address`,`businessregnum`,`approved`) VALUES ('Jovan','Mijic','jmijic@gmail.com','122','P.Pavla','453',0);
INSERT INTO `xmlback`.`agent` (`name`, `surname`,`email`,`password`,`address`,`businessregnum`,`approved`) VALUES ('Ivana','Savic','isavic@gmail.com','133','Z.Jovina','355',0);
INSERT INTO `xmlback`.`agent` (`name`, `surname`,`email`,`password`,`address`,`businessregnum`,`approved`) VALUES ('Milos','Simic','msimic@gmail.com','323','K.Milosa','445',0);
INSERT INTO `xmlback`.`additional_services` (`servicename`) VALUES ('wifi');
INSERT INTO `xmlback`.`additional_services` (`servicename`) VALUES ('tv');
INSERT INTO `xmlback`.`additional_services` (`servicename`) VALUES ('parking');
INSERT INTO `xmlback`.`additional_services` (`servicename`) VALUES ('halfBoard');
INSERT INTO `xmlback`.`additional_services` (`servicename`) VALUES ('fullBoard');
INSERT INTO `xmlback`.`accommodation_type` (`typename`) VALUES ('hotel');
INSERT INTO `xmlback`.`accommodation_type` (`typename`) VALUES ('apartment');
INSERT INTO `xmlback`.`accommodation_type` (`typename`) VALUES ('bed&breakfast');
INSERT INTO `xmlback`.`category` (`categoryname`) VALUES ('1');
INSERT INTO `xmlback`.`category` (`categoryname`) VALUES ('2');
INSERT INTO `xmlback`.`category` (`categoryname`) VALUES ('3');
INSERT INTO `xmlback`.`category` (`categoryname`) VALUES ('4');
INSERT INTO `xmlback`.`category` (`categoryname`) VALUES ('5');
INSERT INTO `xmlback`.`category` (`categoryname`) VALUES ('Uncathegorized');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('01/07/2018','07/07/2018','Kod sajma',1,'Master','2','1','1');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Jevrejska 1','Novi Sad','Srbija');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('16/06/2018','20/06/2018','Centar',1,'Centar','4','1','2');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Bul. Kralja Petra 4','Beograd','Srbija');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('20/06/2018','27/06/2018','Dobar sa bazenom',0,'Novi Sad','3','1','3');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Bul. Evrope 34','Novi Sad','Srbija');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('23/06/2018','27/06/2018','Odlicna usluga',1,'Putnik','5','1','4');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Fruskogorska 54','Novi Sad','Srbija');
INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Dobar smestaj.Doci cemo opet!',0);
INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Kuhinja mi se nije svidela,ostalo okej!',0);
INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Smestaj ima sve sto je potrebno!',0);
INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('10','1','1','1');
INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('9','2','2','2');
INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('8','3','3','3');







