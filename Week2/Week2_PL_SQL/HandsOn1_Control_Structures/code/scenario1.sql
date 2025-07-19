-- Scenario 1 : The bank wants to apply a discount to loan interest rates for customers above 60 years old.

CREATE TABLE customers (
  customer_id     NUMBER PRIMARY KEY,
  name            VARCHAR2(100),
  age             NUMBER,
  balance         NUMBER(10,2),
  isvip           VARCHAR2(5) DEFAULT 'FALSE',
  interest_rate   NUMBER(5,2) 
);

INSERT INTO customers VALUES (1, 'Alice', 65, 15000.00, 'FALSE', 7.5);
INSERT INTO customers VALUES (2, 'Bob', 45, 8000.00,  'FALSE', 6.0);
INSERT INTO customers VALUES (3, 'Charlie', 70, 12000.00, 'FALSE', 8.0);
INSERT INTO customers VALUES (4, 'David', 30, 5000.00, 'FALSE', 6.5);
INSERT INTO customers VALUES (5, 'Eve', 62, 11000.00, 'FALSE', 7.0);

BEGIN
  FOR cust_rec IN (SELECT customer_id, age FROM customers) LOOP
    IF cust_rec.age > 60 THEN
      UPDATE customers
      SET interest_rate = interest_rate - 1
      WHERE customer_id = cust_rec.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/

SELECT * FROM customers;
