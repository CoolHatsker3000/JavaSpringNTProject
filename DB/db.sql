drop table tariff_info;
drop table tariff_attrs;
drop table user_info;
drop table user_attrs;
drop table users;
drop table tariffs;


create table tariffs(
  tariff_id INT PRIMARY KEY,
  tariff_name VARCHAR(20) unique
);

create table tariff_attrs(
  attr_id int CONSTRAINT attributes_pk primary KEY,
  attr_name varchar(20)
);

create table tariff_info(
  tariff_id int not null CONSTRAINT tariff_info_fk_tariffs REFERENCES tariffs(tariff_id),
  attr_id   int not null CONSTRAINT tariff_info_fk_attributes REFERENCES tariff_attrs(attr_id),
  attr_v    varchar(30) not null
);
create table users(
  user_id INT CONSTRAINT users_pk primary KEY,
  user_balance decimal(7,2) default 0
);

create table user_tariff(
  user_id INT not null CONSTRAINT users_tariffs_fk_users REFERENCES users(user_id),
  tariff_id int not null CONSTRAINT users_tariffs_fk_tariffs REFERENCES tariffs(tariff_id)
);



insert into tariffs values (1,'firstTar');
insert into tariffs values (2,'secondTar');
insert into tariffs values (3,'thirdTar');
insert into tariffs values (4,'fourthTar');

insert into tariff_attrs values (1,'mins');
insert into tariff_attrs values (2,'sms');
insert into tariff_attrs values (3,'traffic');
insert into tariff_attrs values (4,'payment');


insert into tariff_info values (1,1,'3000');
insert into tariff_info values (2,1,'1500');

insert into tariff_info values (2,2,'300');

insert into tariff_info values (2,3,'15');

insert into tariff_info values (1,4,'120.00');
insert into tariff_info values (2,4,'300');
insert into tariff_info values (3,4,'350.00');
insert into tariff_info values (4,4,'500');

insert into tariff_info values (3,1,'2000');
insert into tariff_info values (3,3,'10');

insert into tariff_info values (4,1,'5500');
insert into tariff_info values (4,2,'500');
insert into tariff_info values (4,3,'25');


insert into users values (000,5000);
insert into users values (9603334466,1000);
insert into users values (9997774466,2000);
insert into users values (9993332299,2000);

insert into user_tariff values (9603334466,2);
insert into user_tariff values (9997774466,4);
insert into user_tariff values (9993332299,3);




