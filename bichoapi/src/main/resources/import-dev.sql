insert into app_user (id, username, password, email, account_non_expired, account_non_locked, credentials_non_expired, enabled, last_password_change_at , password_expirate_at ) values ('80d768ef-831a-4cfe-94e6-fda1eb4452a6', 'krobert151', '{bcrypt}$2a$12$DqkAg6PV3vOSBt63BfsUWupnsAGh/SESJfNGKOGaGneZAiqcGCaDW', 'robertorebolledo151@gmail.com', true, true, true, true, '2023-12-17 17:22:00', '2023-12-17 17:24:00');
insert into user_roles (roles, user_id) values (2,'80d768ef-831a-4cfe-94e6-fda1eb4452a6');
insert into media (id, article, archive) values ('80d768ef-6543-4cfe-94e6-fda1eb4452a6','foto gallipato', 'https://i.pinimg.com/564x/f8/19/94/f81994a18d2f74abf23c2ae79b1bceb2.jpg');
insert into media (id, article, archive) values ('80d768af-6543-4cfe-94e6-fda1eb4452a6','foto araña lobo', 'https://i.pinimg.com/564x/04/10/44/04104419e02e72560d0f0c6cff8a8be2.jpg');
insert into media (id, article, archive) values ('80d768ff-6543-4cfe-94e6-fda1eb4452a6','foto gineta', 'https://i.pinimg.com/564x/79/94/81/799481a982a56e439756668a19bf35aa.jpg');
insert into media (id, article, archive) values ('80d768ff-5543-4cfe-94e6-fda1eb4452a6','foto eagle', 'https://i.pinimg.com/564x/c6/31/8d/c6318d184cf1153eb4cf71db7937a214.jpg');

insert into user_data(id,profile_photo_id,current_location,user_id,exp) values ('80d762ef-831a-4cfe-94e6-fda1eb445564','80d768ef-6543-4cfe-94e6-fda1eb4452a6','aqui','80d768ef-831a-4cfe-94e6-fda1eb4452a6',0);

insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9410-fda1eb4452a6',1,0,99);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9411-fda1eb4452a6',2,100,299);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9412-fda1eb4452a6',3,300,499);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9413-fda1eb4452a6',4,500,999);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9414-fda1eb4452a6',5,1000,1499);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9415-fda1eb4452a6',6,1500,1999);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9416-fda1eb4452a6',7,2000,2999);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9417-fda1eb4452a6',8,3000,3999);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9418-fda1eb4452a6',9,4000,7999);
insert into level_table(id,level_nevel,from_exp,to_exp) values ('80d768ef-6543-4cfe-9419-fda1eb4452a6',10,8000,10000);

insert into specie(danger,type,id,media_id,scientific_name,description) values (2,1,'80d768ef-831a-4cfe-94e6-fda1eb445564','80d768ef-6543-4cfe-94e6-fda1eb4452a6','Pleurodelest walts','un gallipato to wapo');
insert into specie(danger,type,id,media_id,scientific_name,description) values (5,2,'80d768ef-831a-4cfe-94e6-fda1eb444464','80d768ff-5543-4cfe-94e6-fda1eb4452a6','American Eagle','una aguila wapas to wapo');
insert into specie(danger,type,id,media_id,scientific_name,description) values (5,7,'80d768ef-831a-4cfe-9426-fda1eb456464','80d768ff-6543-4cfe-94e6-fda1eb4452a6','Gineta','una gineta to wapa');
insert into specie(danger,type,id,media_id,scientific_name,description) values (0,9,'80d768ef-831a-4cfe-9426-fda1eb490464','80d768af-6543-4cfe-94e6-fda1eb4452a6','Araña Lobo','una araña to wapa');

insert into encounter(id,date,specie_id,user_data_id,location,description) values ('80d768ef-871a-4cfe-9426-fda1eb490464','12-12-2012','80d768ef-831a-4cfe-94e6-fda1eb445564','80d762ef-831a-4cfe-94e6-fda1eb445564','aqui','descripcion');
insert into encounter(id,date,specie_id,user_data_id,location,description) values ('80d768ef-871a-4cfe-9426-fda1eb490455','12-12-2012','80d768ef-831a-4cfe-94e6-fda1eb444464','80d762ef-831a-4cfe-94e6-fda1eb445564','aqui','descripcion');
insert into encounter(id,date,specie_id,user_data_id,location,description) values ('80d768ef-871a-4cfe-9426-fda1eb490495','12-12-2012','80d768ef-831a-4cfe-9426-fda1eb456464','80d762ef-831a-4cfe-94e6-fda1eb445564','aqui','descripcion');

insert into encounter_medias(encounter_id,medias_id) values ('80d768ef-871a-4cfe-9426-fda1eb490464','80d768ef-6543-4cfe-94e6-fda1eb4452a6');
insert into encounter_medias(encounter_id,medias_id) values ('80d768ef-871a-4cfe-9426-fda1eb490455','80d768af-6543-4cfe-94e6-fda1eb4452a6');
insert into encounter_medias(encounter_id,medias_id) values ('80d768ef-871a-4cfe-9426-fda1eb490495','80d768ff-6543-4cfe-94e6-fda1eb4452a6');

insert into article(id,approved,specie_, user_data_id,title,text,type) values ('80d768ef-871a-4cfe-9436-fda1eb490495',true,'80d768ef-831a-4cfe-94e6-fda1eb445564','80d762ef-831a-4cfe-94e6-fda1eb445564','Titulo wapo','texto wapo',0);

insert into saved_list(id,title,description) values ('80d768ef-971a-4cfe-9436-fda1eb490495','lista wapa','lista wapa molona');

insert into saved_list_species(saved_list_id,species_id) values ('80d768ef-971a-4cfe-9436-fda1eb490495','80d768ef-831a-4cfe-94e6-fda1eb445564');
insert into saved_list_species(saved_list_id,species_id) values ('80d768ef-971a-4cfe-9436-fda1eb490495','80d768ef-831a-4cfe-94e6-fda1eb444464');
insert into saved_list_species(saved_list_id,species_id) values ('80d768ef-971a-4cfe-9436-fda1eb490495','80d768ef-831a-4cfe-9426-fda1eb456464');
insert into saved_list_species(saved_list_id,species_id) values ('80d768ef-971a-4cfe-9436-fda1eb490495','80d768ef-831a-4cfe-9426-fda1eb490464');