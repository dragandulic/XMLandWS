INSERT INTO `xmlback`.`admin` (`name`, `surname`) VALUES ('Marko','Juric');
INSERT INTO `xmlback`.`admin` (`name`, `surname`) VALUES ('Aleksandra','Grujic');
INSERT INTO `xmlback`.`admin` (`name`, `surname`) VALUES ('Damjan','Nicic');
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








