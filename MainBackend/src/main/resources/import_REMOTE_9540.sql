INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Marko','Juric','admin1@gmail.com','admin111','M.Maric');
INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Aleksandra','Grujic','admin2@gmail.com','admin222','Detelinara');
INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Damjan','Nicic','admin3@gmail.com','admin333','Z.Stanica');
INSERT INTO `xmlback`.`role` (`roleid`,`role`) VALUES ('1','USER');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`) VALUES ('Dragan','Dulic',1,0,'dulke@gmail.com');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`) VALUES ('Nikola','Nikolic',1,0,'nikola@gmail.com');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`) VALUES ('Jovana','Jovanic',1,0,'jovana@gmail.com');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`) VALUES ('Milos','Petrovic',1,0,'milos@gmail.com');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`) VALUES ('Jelena','Antic',1,0,'jelena@gmail.com');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`) VALUES ('Stefan','Ivanovic',1,0,'stefan@gmail.com');
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
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('01/07/2018','07/07/2018','Kod sajma',1,'Master','2.1','1','1');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Jevrejska 1','Novi Sad','Srbija');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('16/06/2018','20/06/2018','Centar',1,'Centar','4','1','2');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Bul. Kralja Petra 4','Beograd','Srbija');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('20/06/2018','27/06/2018','Dobar sa bazenom',0,'Novi Sad','3','1','3');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Bul. Evrope 34','Novi Sad','Srbija');
INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('23/06/2018','27/06/2018','Odlicna usluga',1,'Putnik','5','1','4');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Fruskogorska 54','Novi Sad','Srbija');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`) VALUES ('100','dulke@gmail.com',1,2,'1');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`) VALUES ('200','dulke@gmail.com',1,2,'1');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`) VALUES ('300','dulke@gmail.com',1,2,'1');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`) VALUES ('400','nikola@gmail.com',1,2,'2');



INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('01/07/2018','07/07/2018','Kod sajma',1,'Putnikk','2.1','1','5');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Jevrejska 1','Subotica','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','5');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','5');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('hotel','5');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','5');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('2','5');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','5','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000');

INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('01/07/2018','07/07/2018','Kod sajma',1,'Masterr','3.1','1','6');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Jevrejska 1','Subotica','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','6');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','6');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('apartment','6');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','6');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('5','6');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','6','2000','2000','2000','2000','2000','2000','2000','2000','2000','2000','2000','2000');

INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('01/07/2018','07/07/2018','Kod sajma',1,'Moskvaa','4.1','1','7');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Jevrejska 1','Subotica','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','7');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','7');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('parking','7');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('bed&breakfast','7');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','7');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('1','7');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','7','3000','3000','3000','3000','3000','3000','3000','3000','3000','3000','3000','3000');

INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`) VALUES ('01/07/2018','07/07/2018','Kod sajma',1,'AquaLux','5.0','1','8');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Jevrejska 1','Subotica','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','8');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','8');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('parking','8');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('bed&breakfast','8');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','8');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('3','8');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','8','4000','4000','4000','4000','4000','4000','4000','4000','4000','4000','4000','4000');



