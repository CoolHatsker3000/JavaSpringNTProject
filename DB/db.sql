drop table tariff_info;
drop table tariff_attrs;
drop table user_tariff;
drop table users;
drop table tariffs;
drop sequence tariffs_sequence;
drop sequence tariff_attrs_sequence;
drop sequence user_sequence;


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
  user_password varchar(20) not null,
  user_balance decimal(7,2) default 0
);

create table user_tariff(
  user_id INT not null CONSTRAINT users_tariffs_fk_users REFERENCES users(user_id),
  tariff_id int not null CONSTRAINT users_tariffs_fk_tariffs REFERENCES tariffs(tariff_id)
);

create sequence tariffs_sequence start with 1;
create sequence tariff_attrs_sequence start with 1;
create sequence user_sequence start with 1;

create or replace trigger tariff_attrs_to_insert
  before insert on tariff_attrs
  for each row
  begin
    select tariff_attrs_sequence.nextval
    into :new.attr_id
    from dual;
  end;
  /

create or replace trigger tariffs_to_insert
  before insert on tariffs
  for each row
  begin
    select tariffs_sequence.nextval
    into :new.tariff_id
    from dual;
  end;
  /
  
  


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


insert into users (user_id,user_password,user_balance) values (000,'pass0',5000);
insert into users values (9603334466,'pass1',1000);
insert into users values (9997774466,'pass2',2000);
insert into users values (9993332299,'pass3',2000);

insert into user_tariff values (9603334466,2);
insert into user_tariff values (9997774466,4);
insert into user_tariff values (9993332299,3);




