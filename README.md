# Splitwise
 command line splitwise app

==========================

 SQL Tables:
 
create database splitwise;

create table user(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(50) NOT NULL,
   passcode VARCHAR(20) NOT NULL,
   PRIMARY KEY ( id )
);

insert into user (name, passcode) values ('Lokesh', '123');

create table friends(
 user INT NOT NULL,
 friend INT NOT NULL,
 PRIMARY KEY ( user, friend )
);

create table user_group(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(20) NOT NULL,
   user INT NOT NULL,
   PRIMARY KEY ( id )
);

create table group_friend(
 group_id INT NOT NULL,
 friend INT NOT NULL,
 PRIMARY KEY ( group_id, friend )
);

select f.user user, f.friend friend, g.friend gf, g.group_id gid from friends f LEFT JOIN group_friend g ON f.friend = g.friend WHERE g.group_id <> 4 OR g.group_id IS NULL AND f.user = 1;

create table finance(
 user INT NOT NULL,
 friend INT NOT NULL,
 group_id INT,
 amount INT,
 PRIMARY KEY ( user, friend, group_id )
);

Insert into finance (user, friend, group_id, amount) values (1, 1, 0, 100);

 