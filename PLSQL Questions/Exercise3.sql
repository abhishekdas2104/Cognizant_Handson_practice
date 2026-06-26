SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 1 / 100)
    WHERE AccountType = 'Savings';

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest added to savings accounts.');
END;
/

-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    deptName VARCHAR2,
    bonusPercent NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * bonusPercent / 100)
    WHERE Department = deptName;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Employee bonus updated.');
END;
/

-- Scenario 3
CREATE OR REPLACE PROCEDURE TransferFunds(
    fromAcc NUMBER,
    toAcc NUMBER,
    amount NUMBER
)
IS
    bal NUMBER;
BEGIN
    SELECT Balance
    INTO bal
    FROM Accounts
    WHERE AccountID = fromAcc;

    IF bal >= amount THEN
        UPDATE Accounts
        SET Balance = Balance - amount
        WHERE AccountID = fromAcc;

        UPDATE Accounts
        SET Balance = Balance + amount
        WHERE AccountID = toAcc;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Amount transferred successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;
END;
/

BEGIN
    ProcessMonthlyInterest;
    UpdateEmployeeBonus('IT', 10);
    TransferFunds(1, 2, 100);
END;
/