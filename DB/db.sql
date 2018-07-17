drop table users;
drop table tariffs;

create table tariffs(
  tariff_id INT PRIMARY KEY,
  tariff_name VARCHAR(20) unique,
  mins INT default 1000,
  sms int default 100,
  traffic int default 5,
  payment decimal(5,2)
);

create table users(
  user_id INT CONSTRAINT users_pk primary KEY,
  phone_number VARCHAR2(10),
  user_balance decimal(7,2) default 0,
  tariff_id int
    CONSTRAINT users_fk 
    REFERENCES tariffs(tariff_id)
);

insert into tariffs (tariff_id, tariff_name,mins,payment) values (1,'firstTar',3000,120.00);
insert into tariffs (tariff_id, tariff_name,mins,sms,traffic,payment) values (2,'secondTar',1500,300,15,300);
insert into tariffs (tariff_id, tariff_name,mins,traffic,payment) values (3,'thirdTar',2000,10,350.00);
insert into tariffs (tariff_id, tariff_name,mins,sms,traffic,payment) values (4,'fourthTar',5500,500,25,500);


insert into users values (1,'000',5000,null);
insert into users values (2,'9603334466',1000,2);
insert into users values (3,'9997774466',2000,4);
insert into users values (4,'9993332299',2000,3);


