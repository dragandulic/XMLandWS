INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Marko','Juric','admin1@gmail.com','admin111','M.Maric');
INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Aleksandra','Grujic','admin2@gmail.com','admin222','Detelinara');
INSERT INTO `xmlback`.`admin` (`name`, `surname`,`email`, `password`,`address`) VALUES ('Damjan','Nicic','admin3@gmail.com','admin333','Z.Stanica');
INSERT INTO `xmlback`.`role` (`roleid`,`role`) VALUES ('1','USER');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`,`password`) VALUES ('Dragan','Dulic',1,0,'dragan.dulic1@gmail','123');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`,`password`) VALUES ('Nikola','Nikolic',1,0,'nikola@gmail.com','123');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`,`password`) VALUES ('Jovana','Jovanic',1,0,'jovana@gmail.com','123');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`,`password`) VALUES ('Milos','Petrovic',1,0,'milos@gmail.com','123');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`,`password`) VALUES ('Jelena','Antic',1,0,'jelena@gmail.com','123');
INSERT INTO `xmlback`.`reg_user` (`name`, `surname`,`active`,`blocked`,`email`,`password`) VALUES ('Stefan','Ivanovic',1,0,'stefan@gmail.com','123');
INSERT INTO `xmlback`.`agent` (`name`, `surname`,`email`,`password`,`address`,`businessregnum`,`approved`) VALUES ('Mino','Raiola','dragan.dulic1@gmail','123','Bul.Oslobodjenja','455',0);
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

INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`,`accepted`,`deleted`,`startdate`,`enddate`) VALUES ('100','dulke@gmail.com',1,2,'1',0,0,'01/07/2018','05/07/2018');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`,`accepted`,`deleted`,`startdate`,`enddate`) VALUES ('200','dulke@gmail.com',1,2,'1',0,0,'02/07/2018','04/07/2018');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`,`accepted`,`deleted`,`startdate`,`enddate`) VALUES ('300','dulke@gmail.com',2,2,'1',0,0,'04/07/2018','08/07/2018');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`,`accepted`,`deleted`,`startdate`,`enddate`) VALUES ('400','nikola@gmail.com',3,2,'2',0,0,'05/07/2018','09/07/2018');
INSERT INTO `xmlback`.`reservation`(`price`,`email`,`accommodation_id`,`roomtype`,`reg_user_id`,`accepted`,`deleted`,`startdate`,`enddate`) VALUES ('443','dulke@gmail.com',3,2,'1',0,0,'06/07/2018','09/07/2018');



INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`,`picture`) VALUES ('01/07/2018','07/07/2018','Pansion sa uslugom doručka se nalazi na 4 km od centra Novog Sada. Objekat poseduje restoran i bar sa terasom. Bežični internet se može besplatno koristiti.',1,'Meridiana','2.1','1','1','https://lh4.googleusercontent.com/0WgGnINAhN9ZBFTJce-wE-MT9TI26q82umgBMyvO7rHRYMPFowD30tkGkXm_SSQ9wN64vcaHY6_nhROLkUJP=w1920-h948');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Stojana Novakovića 2,','Novi Sad','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','1');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','1');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('hotel','1');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','1');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('2','1');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','1','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000','1000');




INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`,`picture`) VALUES ('08/07/2018','10/07/2018','Luksuzni hotel Prezident smešten je na idealnoj lokaciji, nedaleko od centra Novog Sada. Udaljen je 5 minuta hoda od Novosadskog sajma, a u ponudi ima bezbedan parking i uslugu prevoza.',1,'Master','3.1','1','2','https://lh6.googleusercontent.com/8Spgc3-xCrcL45_NfZepQav5KSk-3Tk5saYZ2YhEKOIWPZF__q19wWHH2L022D30wFmLVgiIAAzh6g7_25PA=w1920-h948');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Futoška 109','Novi Sad','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','2');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','2');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('apartment','2');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','2');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('5','2');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','2','2000','2000','2000','2000','2000','2000','2000','2000','2000','2000','2000','2000');



INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`,`picture`) VALUES ('12/07/2018','18/07/2018','Apartmani Pia nalaze se u centru Subotice, na 41 km od Segedina. Morahalom je udaljen 22 km. Besplatan bežični internet dostupan je u celom objektu.',1,'Pia','4.1','2','3','https://lh3.googleusercontent.com/qOrLTyWRozW-RCa0yVU7zqFLsENQQsuvd4IP5Tx6OuWR76ACGoX_wyg27ScSTPvUgKpwohPFIjpm3p2c-_Sz=w1920-h948-rw');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Brace Radic 6','Subotica','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','3');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','3');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('parking','3');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('bed&breakfast','3');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','3');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('1','3');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','3','3000','3000','3000','3000','3000','3000','3000','3000','3000','3000','3000','3000');



INSERT INTO `xmlback`.`accommodation` (`datefrom`,`dateto`,`description`,`free`,`name`,`rating`,`agent_id`,`location_id`,`picture`) VALUES ('15/07/2018','18/07/2018','Objekat Sun Apartman se nalazi u Subotici i nudi klimatizovane smeštajne jedinice sa besplatnim bežičnim internetom i flat-screen televizorom.',1,'Sun','5.0','1','4','https://lh3.googleusercontent.com/HcFnkPVIeZ2RTxDFRUQX4WeQBNGb-l4dMvoL7L02Vyp6Z9QfLyPQC8o5HV01AguxhwF5fhN9mgAaqiYUA0SS=w1920-h948-rw');
INSERT INTO `xmlback`.`location` (`address`,`city`,`country`) VALUES ('Milosa Obilitya 31,','Subotica','Srbija');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('wifi','4');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('tv','4');
INSERT INTO `xmlback`.`additional_services` (`servicename`,`accommodation_id`) VALUES ('parking','4');
INSERT INTO `xmlback`.`accommodation_type` (`typename`,`accomm`) VALUES ('bed&breakfast','4');
INSERT INTO `xmlback`.`room` (`free`,`number_of_bed`,`accommodation_id`) VALUES (1,'5','4');
INSERT INTO `xmlback`.`category` (`categoryname`,`accommodation_id`) VALUES ('3','4');
INSERT INTO `xmlback`.`price_plan` (`roomtype`,`accommodation_id`,`january`,`february`,`march`,`april`,`may`,`june`,`july`,`august`,`september`,`october`,`november`,`december`) VALUES ('2','4','4000','4000','4000','4000','4000','4000','4000','4000','4000','4000','4000','4000');


INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Dobar smestaj.Doci cemo opet!',0);
INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Kuhinja mi se nije svidela,ostalo okej!',0);
INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Smestaj ima sve sto je potrebno!',0);
INSERT INTO `xmlback`.`comment` (`content`,`approved`) VALUES ('Solidan smestaj.Zadovoljan sam!',0);

INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('10','1','1','1');
INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('9','1','4','1');
INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('9','2','2','2');
INSERT INTO `xmlback`.`review` (`rating`, `reg_user_id`,`comment_id`, `accommodation`) VALUES ('8','3','3','3');
