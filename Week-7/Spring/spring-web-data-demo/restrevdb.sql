--drop table restaurants
--drop table reviews

create table restaurants(
id serial primary key,
name varchar(100) not null
);

create table reviews(
id serial primary key,
rating decimal(4,2) not null,
restuarant_id int references restaurants(id) 
);