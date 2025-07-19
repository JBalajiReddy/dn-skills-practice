-- Scenario 3 : The bank wants to send reminders to customers whose loans are due within the next 30 days.

CREATE TABLE Loan (
    LoanID NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    DueDate DATE
);

INSERT INTO Loan VALUES (1, 'Anil', SYSDATE + 10);
INSERT INTO Loan VALUES (2, 'Suman', SYSDATE + 40);
INSERT INTO Loan VALUES (3, 'Rekha', SYSDATE + 5);
INSERT INTO Loan VALUES (4, 'Amit', SYSDATE - 1);

COMMIT;

BEGIN
    FOR rec IN (
        SELECT * FROM Loan
        WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || rec.LoanID ||
                             ' for customer ' || rec.CustomerName ||
                             ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/
