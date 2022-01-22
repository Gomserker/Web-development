create table coffee2(
c_name varchar2 (10 char) not null,
c_price number(4) not null
);

insert into coffee2 values ('test', 1000);
insert into coffee2 values ('test2', 2000);

select * from coffee2;