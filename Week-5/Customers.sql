-- Creating the customer table
-- Customer table columns: id, fname, lname, email, password
-- SQL naming convention: tables are named plural of whatever data they are holding
create table customers (
-- column_name data_type constraints
-- serial is a sequence that returns to you the next int so your id is self incrementing
-- Primary Key is implicily not null and unique
id serial primary key,
-- not null cannot be empty/null 
-- the 50 in varchar represents the character length, you can only have max of 50 characters
first_name varchar(50) not null,
last_name varchar(50) not null,
-- unique means that each entry in this column is different from each other (a column with a unique constraint can have at most 1 null value)
email varchar(50) not null unique,
customer_password varchar(20) not null
);

-- editing existing table by adding an additional column
alter table customers add phone_number varchar(11) not null;
-- editing existing table by removing column
alter table customers drop phone_number;

-- adding data to my customers table aka seeding the customers table
-- seeding the db is adding dummy data to it 
-- NOTE: Strings in SQL unlike in Java are surrounded by single quotations ''
insert into customers (first_name, last_name, email, customer_password) values 
('Stephen', 'Pagdilao', 'stephen.pagdilao@revature.com', 'theDogFather'),
('Bruce', 'Wayne', 'iambatman@gotham.com', 'orphaned@7');

-- get all current customers
select * from customers; 
