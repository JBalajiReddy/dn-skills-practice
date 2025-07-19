-- scenario 3 : : Customers should be able to transfer funds between their accounts.



CREATE TABLE accounts (
  account_id     NUMBER PRIMARY KEY,
  customer_name  VARCHAR2(100),
  account_type   VARCHAR2(20), -- e.g., 'savings', 'current'
  balance        NUMBER(10,2)
);

INSERT INTO accounts VALUES (1, 'Alice', 'savings', 10000.00);
INSERT INTO accounts VALUES (2, 'Bob', 'savings', 15000.00);
INSERT INTO accounts VALUES (3, 'Charlie', 'current', 20000.00);
INSERT INTO accounts VALUES (4, 'David', 'savings', 8000.00);
INSERT INTO accounts VALUES (5, 'Eve', 'savings', 3000.00);

CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_acc_id NUMBER,
  p_to_acc_id   NUMBER,
  p_amount      NUMBER
) AS
  v_balance NUMBER;
BEGIN
  -- Check if sufficient balance exists
  SELECT balance INTO v_balance
  FROM accounts
  WHERE account_id = p_from_acc_id
  FOR UPDATE;

  IF v_balance < p_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
  END IF;

  -- Deduct from source
  UPDATE accounts
  SET balance = balance - p_amount
  WHERE account_id = p_from_acc_id;

  -- Add to target
  UPDATE accounts
  SET balance = balance + p_amount
  WHERE account_id = p_to_acc_id;

  COMMIT;
END;
/


SELECT account_id, customer_name, balance FROM accounts
WHERE account_id IN (1, 5);


