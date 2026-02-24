[https://vertabelo.com/blog/er-diagram-for-online-shop/](https://vertabelo.com/blog/er-diagram-for-online-shop/)

## Step 1 - Building a Conceptual Data Model

Identify the **Entities**
- **Customer**: This entity represents the customers who create an account to place orders on the online shopping platform.
- **Product**: Represents the set of products available for purchase on the platform.
- **Category**: Categories in which the products are grouped.
- **Order**: Product orders placed by customers.
- **Order_item**: Each item that is part of an order.
- **Payment**: The payment made by the customer once the order is completed.
- **Shipment**: Shipping information associated with an order, including delivery address and tracking information.
- **Cart**: The customer’s virtual basket or shopping cart, which stores items before they are purchased and become part of an order.
- **Wishlist**: Stores items chosen by the customer for possible future purchases.

![OnlineDesign01.JPG](pic/OnlineDesign01.JPG)

Identify the **Relationships between the Entities**
- A customer can place several orders. Therefore, between Customer and Order there must be a one-to-many relationship.
  - **Customer - Order --> one-to-many relationship**
- An order can contain one or several items, each of which represents a single product. Order_Item is a dependent entity of Order, since it has no reason to exist if an order does not exist. In addition, Order_Item is related to Product through a one-to-many relationship: each Order_Item is related to one Product, and a Product can be related to multiple Order_item
  - **Order - Order_item --> one-to-many relationship**
  - **Product - Order_item --> one-to-many relationship**
- An order is associated with one payment and one shipment, but each payment and each shipment can include multiple orders. For this reason, there are one-to-many relationships between Payment and Order and between Shipment and Order.
  - **Payment - Order --> one-to-many relationship**
  - **Shipment - Order --> one-to-many relationship**
- A product can belong to a single category: there is a one-to-many relationship between Product and Category.
  - **Category - Product --> one-to-many relationship**
- The shopping cart and the wish list are dependent entities of Customer, so both Cart and Wishlist maintain a dependency relationship with Customer. In turn, each instance of Cart and of Wishlist is related to a product, so both entities have many-to-one relationships with Product.
  - **Product - Card --> one-to-many relationship**
  - **Product - Wishlist --> one-to-many relationship**
  - **Customer - Card --> one-to-many relationship**
  - **Customer - Wishlist --> one-to-many relationship**

![OnlineDesign02.JPG](pic/OnlineDesign02.JPG)

## Step 2 - Build the Logical Model

After identifying the entities that compose it and sketching the conceptual model, we need to define the attributes that compose each entity

**Entity Contruction**

### Customer
- customer_id	integer
- first_name	string
- last_name	string
- email	string
- password	string
- address	string
- phone_number	string

### Cart
- cart_id	integer
- quantity	integer

### Wishlist
- wishlist_id	integer

### Product
- product_id	integer
- SKU	string
- description	string
- price	decimal
- stock	integer

### Category
- category_id	integer
- name	string

### Order
- order_id	integer
- order_date	date/time
- total_price	decimal

### Order_item
- order_item_id	integer
- quantity	integer
- price	decimal

### Payment
- payment_id	integer
- payment_date	date
- payment_method	string
- amount	decimal

### Shipment
- shipment_id	integer
- shipment_date	date
- address	string
- city	string
- state	string
- country	string
- zip_code	string


![OnlineDesign03.JPG](pic/OnlineDesign03.JPG)


## Step 3 - Build the Logical Model with PK and FK

### Customer
- customer_id **PK**

### Cart
- cart_id	**PK**
- Customer_customer_id **PK**
- Customer_customer_id **FK**
- Product_product_id **FK**

### Wishlist
- wishlist_id	**PK**
- Customer_customer_id **PK**
- Customer_customer_id **FK**
- Product_product_id **FK**


### Product
- product_id	**PK**
- Customer_category_id **FK**

### Category
- category_id	**PK**

### Order
- order_id	**PK**
- Customer_customer_id **FK**
- Payment_payment_id **FK**
- Shipment_shipment_id **FK**

### Order_item
- order_item_id	**PK**
- Order_order_id **PK**
- Product_product_id **FK**
- Order_order_id **FK**

### Payment
- payment_id	**PK**
- Customer_customer_id **FK**

### Shipment
- shipment_id	**PK**
- Customer_customer_id **FK**


![OnlineDesign04.JPG](pic/OnlineDesign04.JPG)

## Step 4 - Create sql-script

```sql
-- Table: Customer
CREATE TABLE Customer (
    customer_id int NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    address varchar(200) NOT NULL,
    phone_number varchar(100),
    CONSTRAINT Customer_pk PRIMARY KEY (customer_id)
);
-- Table: Shipment
CREATE TABLE Shipment (
    shipment_id int NOT NULL,
    shipment_date datetime NOT NULL,
    address varchar(200) NOT NULL,
    city varchar(100),
    state varchar(20),
    country varchar(50),
    zip_code varchar(10),
    CONSTRAINT Shipment_pk PRIMARY KEY (shipment_id)
);
-- Table: Order
CREATE TABLE Order (
    order_id int NOT NULL,
    order_date datetime NOT NULL,
    total_price decimal(10,2) NOT NULL,
    CONSTRAINT Order_pk PRIMARY KEY (order_id)
);
-- Table: Payment
CREATE TABLE Payment (
    payment_id int NOT NULL,
    payment_date datetime NOT NULL,
    payment_method varchar(100) NOT NULL,
    amount decimal(10,2),
    CONSTRAINT Payment_pk PRIMARY KEY (payment_id)
);
-- Table: Cart
CREATE TABLE Cart (
    cart_id int NOT NULL,
    quantity int NOT NULL,
    Customer_customer_id int NOT NULL,
    Product_product_id int NOT NULL,
    CONSTRAINT Cart_pk PRIMARY KEY (cart_id,Customer_customer_id)
);
-- Table: Wishlist
CREATE TABLE Wishlist (
    wishlist_id int NOT NULL,
    Customer_customer_id int NOT NULL,
    CONSTRAINT Wishlist_pk PRIMARY KEY (wishlist_id,Customer_customer_id)
);
-- Table: Product
CREATE TABLE Product (
    product_id int NOT NULL,
    SKU varchar(100) NOT NULL,
    description varchar(100) NOT NULL,
    price decimal(10,2) NOT NULL,
    stock int NOT NULL,
    address varchar(200) NOT NULL,
    CONSTRAINT Product_pk PRIMARY KEY (product_id)
);

-- Table: Order_Item
CREATE TABLE Order_Item (
    order_item_id int NOT NULL,
    quantity int NOT NULL,
    price decimal(10,2) NOT NULL,
    Order_order_id int,
    CONSTRAINT Order_Item_pk PRIMARY KEY (order_item_id,Order_order_id)
);

-- Table: Category
CREATE TABLE Category (
    category_id int NOT NULL,
    name varchar(100) NOT NULL,
    CONSTRAINT Category_pk PRIMARY KEY (category_id)
);
 
-- Reference: Cart_Customer (table: Cart)
ALTER TABLE Cart ADD CONSTRAINT Cart_Customer FOREIGN KEY Cart_Customer (Customer_customer_id)
REFERENCES Customer (customer_id);
 
-- Reference: Cart_Product (table: Cart)
ALTER TABLE Cart ADD CONSTRAINT Cart_Product FOREIGN KEY Cart_Product (Product_product_id)
REFERENCES Product (product_id);

-- Reference: Wishlist_Customer (table: Wishlist)
ALTER TABLE Wishlist ADD CONSTRAINT Wishlist_Customer FOREIGN KEY Wishlist_Customer (Customer_customer_id)
REFERENCES Customer (customer_id);

-- Reference: Wishlist_Product (table: Wishlist)
ALTER TABLE Wishlist ADD CONSTRAINT Wishlist_Product FOREIGN KEY Wishlist_Product (Product_product_id)
REFERENCES Product (product_id);

-- Reference: Shipment_Customer (table: Shipment)
ALTER TABLE Shipment ADD CONSTRAINT Shipment_Customer FOREIGN KEY Shipment_Customer (Customer_customer_id)
REFERENCES Customer (customer_id);

-- Reference: Product_Category (table: Product)
ALTER TABLE Product ADD CONSTRAINT Product_Category FOREIGN KEY Product_Category (Category_category_id)
REFERENCES Category (category_id);

-- Reference: Payment_Customer (table: Payment)
ALTER TABLE Payment ADD CONSTRAINT Payment_Customer FOREIGN KEY Payment_Customer (Customer_customer_id)
REFERENCES Customer (customer_id);

-- Reference: Order_Item_Product (table: Order_Item)
ALTER TABLE Order_Item ADD CONSTRAINT Order_Item_Product FOREIGN KEY Order_Item_Product (Product_product_id)
REFERENCES Product (product_id);

-- Reference: Order_Item_Order (table: Order_Item)
ALTER TABLE Order_Item ADD CONSTRAINT Order_Item_Order FOREIGN KEY Order_Item_Order (Order_order_id)
REFERENCES Order (order_id);

-- Reference: Order_Customer (table: Order)
ALTER TABLE Order ADD CONSTRAINT Order_Customer FOREIGN KEY Order_Customer (Customer_customer_id)
REFERENCES Customer (customer_id);

-- Reference: Order_Shipment (table: Order)
ALTER TABLE Order ADD CONSTRAINT Order_Shipment FOREIGN KEY Order_Shipment (Shipment_shipment_id)
REFERENCES Shipment (shipment_id);

-- Reference: Order_Payment (table: Order)
ALTER TABLE Order ADD CONSTRAINT Order_Payment FOREIGN KEY Order_Payment (Payment_payment_id)
REFERENCES Payment (payment_id);
```

