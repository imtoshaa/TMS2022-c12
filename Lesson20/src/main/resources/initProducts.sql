--------------------------------------------------------
--  DDL for schema students_db
--------------------------------------------------------
DROP SCHEMA IF EXISTS products_db;
CREATE SCHEMA IF NOT EXISTS products_db;

--------------------------------------------------------
--  DDL for Table students_db
--------------------------------------------------------
DROP TABLE IF EXISTS products_db.products;
CREATE TABLE IF NOT EXISTS products_db.products
(
    id       INT          NOT NULL AUTO_INCREMENT,
    name     VARCHAR(45)  NOT NULL,
    info     VARCHAR(500) NOT NULL,
    price    DOUBLE       NOT NULL,
    quantity INT          NOT NULL,
    inStock  BIT          NOT NULL,
    PRIMARY KEY (id)
);

--------------------------------------------------------
--  DML for Table students_db
--------------------------------------------------------
INSERT INTO products_db.products(name, info, price, quantity, inStock)
VALUES ('Orange', 'some info 1', 40.1, 12, 1);
INSERT INTO products_db.products(name, info, price, quantity, inStock)
VALUES ('Potato', 'some info 2', 15.2, 9, 0);
INSERT INTO products_db.products(name, info, price, quantity, inStock)
VALUES ('Cucumber', 'some info 3', 112, 1, 1);