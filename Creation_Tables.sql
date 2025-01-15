create database if not exists amazon_El8alaba_db;
use amazon_El8alaba_db;

 create Table users
 (
     id                integer    primary key,
     firstname         varchar(60)              not null,
     lastname          varchar(60)              null,
     username          varchar(60) unique       not null,
     email             varchar(60) unique       not null,
     password          varchar(60)              not null check ( password like '^(?=.\d)(?=.[a-z])(?=.[A-Z])(?=.[a-zA-Z]).{8,}$'), #password should have digits,capital & small chars and more than 7 chars
     role              varchar(60)                       default 'CUSTOMER',
     creation_time     timestamp                not null,
     last_updated_time timestamp                not null
 );
 CREATE Table products (
    id                integer       primary key,
    name              varchar(60)               not null,
    manufacturer      varchar(60) ,
    production_date   date,
    expiration_date   date  ,
    unit_price        double,
    quantity          integer ,
    availability      bool  ,
    creation_time     timestamp ,
    last_updated_time timestamp
);

CREATE Table cart
(
    id                integer      primary key,
    total_price       double,
    total_products     integer,
    discount          double,
    creation_time     timestamp,
    last_updated_time timestamp,
    user_id           integer,
    CONSTRAINT FK_UserCart  FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE Table cart_item
(
  id                 integer       primary key,
  quantity           integer ,
  unit_price         double,
  total_price        integer,
  product_id         integer,
  Cart_id            integer,
  CONSTRAINT FK_Product_CartItem  FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT FK_Cart_CartItem  FOREIGN KEY (Cart_id) REFERENCES cart(id)

);
 CREATE Table orders
 (
   id                integer       PRIMARY KEY,
   total_price       double,
   order_time        timestamp,
   cart_id           integer,
   user_id           integer,
   CONSTRAINT FK_Cart_Orders  FOREIGN KEY (cart_id) REFERENCES cart(id),
   CONSTRAINT FK_User_Orders  FOREIGN KEY (user_id) REFERENCES users(id)
   );