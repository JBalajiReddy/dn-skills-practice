-- scenario : The bank needs to process monthly interest for all savings accounts.


CREATE TABLE accounts (
  account_id     NUMBER PRIMARY KEY,
  customer_name  VARCHAR2(100),
  account_type   VARCHAR2(20), -- e.g., 'savings', 'current'
  balance        NUMBER(10,2)
);

INSERT INTO accounts VALUES (1, 'Alice', 'savings', 10000.00);
INSERT INTO accounts VALUES (2, 'Bob', 'savings', 15000.00);
INSERT INTO accounts VALUES (3, 'Charlie', 'current', 20000.00);


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  UPDATE accounts
  SET balance = balance + (balance * 0.01)
  WHERE account_type = 'savings';

  COMMIT;
END;
/


SELECT * FROM accounts;
