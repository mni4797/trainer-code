# So what's left of P0?

It's been a wonderful week. We've added a customer, searched for a customer by their id, placed an order with multiple line items and different quantities for each product; what's next? What's next is the remainder of the functionalities:

- Getting order history of a customer
  - Get all the orders the customer has placed (including the line items )
  - Select order_id, total_price, product_name, price, quantity from
    customers inner join orders on customers.id = orders.customer_id inner join line_items on orders.id = line_items.order_id inner join products on line_items.product_id = products.id where customer_id = 1
- Show inventory when placing an order
  - select \* from inventories inner join products on products.id = inventories.product_id
  - Include the added complexity of stock per product
- Replenish the inventory
  - update the quantity colummn of the inventory table
  - updating the quantity column of your inventory table when the quantity is less than 5
  - update inventories set quantity = 20 where quantiy < 5
- Build interactive UI that presents the end user a collection of options to choose from

Couple of extra data types that could help along the way:
Inventory class/table that associates products with stock
