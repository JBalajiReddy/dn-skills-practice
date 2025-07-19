-- scenario 2 : The bank wants to implement a bonus scheme for employees based on their performance.


CREATE TABLE employees (
  emp_id      NUMBER PRIMARY KEY,
  name        VARCHAR2(100),
  department  VARCHAR2(50),
  salary      NUMBER(10,2)
);

INSERT INTO employees VALUES (101, 'John', 'IT', 50000);
INSERT INTO employees VALUES (102, 'Jane', 'HR', 45000);
INSERT INTO employees VALUES (103, 'Mark', 'IT', 55000);

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_dept VARCHAR2,
  p_bonus_percent NUMBER
) AS
BEGIN
  UPDATE employees
  SET salary = salary + (salary * (p_bonus_percent / 100))
  WHERE department = p_dept;

  COMMIT;
END;
/

SELECT * FROM employees;
