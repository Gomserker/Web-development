create table weather01(
w_no number(5) primary key,
w_temp number(4,2) not null,
w_country varchar2(30 char) not null,
w_city varchar2(50 char) not null,
w_description varchar2(100 char) not null,
w_date date not null
);

create sequence weather01_seq;

insert into weather01 values (weather01_seq.nextval, 10.1, '한국', '영천', '좋음', sysdate);

select * from weather01;