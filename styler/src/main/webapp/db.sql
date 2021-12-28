create table item(
i_no varchar2(20 char) primary key,
i_color varchar2(20 char) not null,
i_price varchar2(200 char) not null,
i_type varchar2(200 char) not null,
i_typeDetail varchar2(200 char) not null,
i_post varchar2(20 char) not null

);

CREATE sequence item_seq;

insert into item values(item_seq.nextval, 'color', '2000', '����', '��������', '1');


select * from item;

create table users(
u_id varchar2(200 char) primary key,
u_pw varchar2(20 char) not null,
u_name varchar2(20 char) not null,
u_nickname varchar2(200 char) not null,
u_email varchar2(200 char) not null,
u_gender varchar2(200 char) not null,
u_style varchar2(200 char) not null,
u_profileImg varchar2(1000 char) not null,
u_typeOfManager varchar2(200 char) not null,
u_checkPoint varchar2(200 char) not null
);



insert into users values('���̵�', '���', '�̸�', '�г���', '�̸���', '����', '������', '����.jpg', '0', '1');

select * from users;

create table post_daily(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(20 char) not null,
p_good varchar2(20 char) not null,
p_top varchar2(200 char) not null,
p_pants varchar2(200 char) not null,
p_shoes varchar2(200 char) not null,
p_accessary varchar2(300 char) not null,
p_hashtag varchar2(300 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_item varchar2(300 char) not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null
);

CREATE sequence post_daily_seq;

insert into post_daily values(post_daily_seq.nextval, 'title','text', '���ƿ�', '����', '����', '�Ź�', '�Ǽ�����', '�ؽ��±�', '�̹���', sysdate, '������t', '�ڸ�Ʈt', 'userT');

select * from post_daily;

create table post_review(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(20 char) not null,
p_good varchar2(20 char) not null,
p_top varchar2(200 char) not null,
p_pants varchar2(200 char) not null,
p_shoes varchar2(200 char) not null,
p_accessary varchar2(300 char) not null,
p_hashtag varchar2(300 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_item varchar2(300 char) not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null
);

CREATE sequence post_review_seq;

insert into post_review values(post_review_seq.nextval, 'title','text', '���ƿ�', '����', '����', '�Ź�', '�Ǽ�����', '�ؽ��±�', '�̹���', sysdate, '������t', '�ڸ�Ʈt', 'userT');

select * from post_review;

create table comments(
c_no varchar2(20 char) primary key,
c_text varchar2(20 char) not null,
c_date date not null,
c_users varchar2(200 char) not null,
c_post varchar2(200 char) not null
);

CREATE sequence comments_seq;

insert into comments values(comments_seq.nextval, '����', sysdate, '����t', '����Ʈt');

select * from comments;

create table post(
p_no varchar2(20 char) primary key,
p_title varchar2(20 char) not null,
p_text varchar2(20 char) not null,
p_img varchar2(300 char) not null,
p_date date not null,
p_comment varchar2(300 char) not null,
p_user varchar2(300 char) not null
);

CREATE sequence post_seq;

drop sequence post_seq;

insert into post values(post_seq.nextval, 'ŷ��11','text', '�̹���', sysdate, '�ڸ�Ʈt', 'userT');

select * from post;

drop table POST;

select * from ( select rownum num, P.* from (select * from post order by p_date desc) P)"
						+ " where num between 1 and 33;
						
delete post where p_no=23;
						