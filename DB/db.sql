drop table tariff_info;
drop table tariff_attrs;
drop table user_info;
drop table user_attrs;
drop table users;
drop table tariffs;





create table tariffs(
  tariff_id INT PRIMARY KEY,
  tariff_name VARCHAR(20) unique,
  payment decimal(10,2)
);

create table tariff_attrs(
  attr_id int CONSTRAINT attributes_pk primary KEY,
  attr_name varchar(20)
);

create table tariff_info(
  tariff_id int CONSTRAINT tariff_info_fk_tariffs REFERENCES tariffs(tariff_id),
  attr_id   int CONSTRAINT tariff_info_fk_attributes REFERENCES tariff_attrs(attr_id),
  attr_v    varchar(30) not null
);
create table users(
  user_id INT CONSTRAINT users_pk primary KEY,
  user_balance decimal(7,2) default 0,
  tariff_id int
    CONSTRAINT users_fk 
    REFERENCES tariffs(tariff_id)
);

create table user_attrs(
  attr_id int CONSTRAINT user_attrs_pk primary KEY,
  attr_name varchar(20) unique
);

create table user_info(
  user_id CONSTRAINT user_info_fk_users REFERENCES users(user_id),
  attr_id CONSTRAINT user_info_fk_user_attrs REFERENCES user_attrs(attr_id),
  attr_v VARCHAR(30)
);

insert into tariffs values (1,'firstTar',120.00);
insert into tariffs values (2,'secondTar',300);
insert into tariffs values (3,'thirdTar',350.00);
insert into tariffs values (4,'fourthTar',500);

insert into tariff_attrs values (1,'mins');
insert into tariff_attrs values (2,'sms');
insert into tariff_attrs values (3,'traffic');


insert into tariff_info values (1,1,'3000');

insert into tariff_info values (2,1,'1500');
insert into tariff_info values (2,2,'300');
insert into tariff_info values (2,3,'15');

insert into tariff_info values (3,1,'2000');
insert into tariff_info values (3,3,'10');

insert into tariff_info values (4,1,'5500');
insert into tariff_info values (4,2,'500');
insert into tariff_info values (4,3,'25');


insert into users values (000,5000,null);
insert into users values (9603334466,1000,2);
insert into users values (9997774466,2000,4);
insert into users values (9993332299,2000,3);


insert into user_attrs values (1,'fn');
insert into user_attrs values (2,'ln');


insert into user_info values (9603334466,1,'Andrey');
insert into user_info values (9603334466,2,'Ivanov');
insert into user_info values (9997774466,1,'Dusya');
insert into user_info values (9997774466,2,'Nehaeva');


