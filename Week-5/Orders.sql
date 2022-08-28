-- create products table

create table products (id serial primary key, product_name varchar(50) not null, -- 10 length of the number, 2 is how many digits you can have after decimal point
 price decimal(10,2) not null);

-- create orders table

create table orders(customer_id int references customers(id), id serial primary key, total_price decimal(10,2) not null);

-- create line items table as junction table

create table line_items(id serial primary key, product_id int references products(id), order_id int references orders(id), quantity int not null);

-- seed products table
-- insert into products (product_name, price) values ('Coconut Vinegar', 5.99), ('Cane Sugar Vinegar', 4.99), ('White vinegar', 2.99);

select *
from products;


select *
from customers;


select *
from orders;


select *
from line_items;

-- place an order : Stephen buys 2 coco vinegar and a white vinegar

insert into orders (customer_id, total_price)
values (1,
        14.97) returning id;


insert into line_items (product_id, order_id, quantity)
values (1, 1, 2), (3, 1, 1);

-- retrieve Stephen's order history

select *
from customers
inner join orders on customers.id = orders.customer_id
where customer_id = 1