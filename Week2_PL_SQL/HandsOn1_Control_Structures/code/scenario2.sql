-- Scenario 2 : A customer can be promoted to VIP status based on their balance.

CREATE TABLE customers (
  customer_id    NUMBER PRIMARY KEY,
  name           VARCHAR2(100),
  balance        NUMBER(10,2),
  isvip          VARCHAR2(5) DEFAULT 'FALSE' -- Store as 'TRUE' or 'FALSE'
);

INSERT INTO customers VALUES (1, 'Alice', 15000.00, 'FALSE');
INSERT INTO customers VALUES (2, 'Bob', 8000.00, 'FALSE');
INSERT INTO customers VALUES (3, 'Charlie', 12000.00, 'FALSE');
INSERT INTO customers VALUES (4, 'David', 5000.00, 'FALSE');
INSERT INTO customers VALUES (5, 'Eve', 11000.00, 'FALSE');


BEGIN
  FOR cust_rec IN (SELECT customer_id, balance FROM customers) LOOP
    IF cust_rec.balance > 10000 THEN
      UPDATE customers
      SET isvip = 'TRUE'
      WHERE customer_id = cust_rec.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;
/


SELECT * FROM customers;
