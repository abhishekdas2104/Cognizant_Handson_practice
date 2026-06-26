SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    fromAcc NUMBER,
    toAcc NUMBER,
    amt NUMBER
)
IS
    bal NUMBER;
BEGIN
    SELECT Balance INTO bal
    FROM Accounts
    WHERE AccountID = fromAcc;

    IF bal >= amt THEN
        UPDATE Accounts
        SET Balance = Balance - amt
        WHERE AccountID = fromAcc;

        UPDATE Accounts
        SET Balance = Balance + amt
        WHERE AccountID = toAcc;

        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
        ROLLBACK;
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error while transferring funds.');
        ROLLBACK;
END;
/

-- Scenario 2
CREATE OR REPLACE PROCEDURE UpdateSalary(
    empId NUMBER,
    percentInc NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * percentInc / 100)
    WHERE EmployeeID = empId;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
        ROLLBACK;
    ELSE
        COMMIT;
        DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
    END IF;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error while updating salary.');
        ROLLBACK;
END;
/

-- Scenario 3
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    cId NUMBER,
    cName VARCHAR2,
    cDob DATE,
    cBal NUMBER
)
IS
BEGIN
    INSERT INTO Customers(CustomerID, Name, DOB, Balance, LastModified)
    VALUES(cId, cName, cDob, cBal, SYSDATE);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');
        ROLLBACK;

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error while adding customer.');
        ROLLBACK;
END;
/


BEGIN
    DBMS_OUTPUT.PUT_LINE('Fund Transfer');
    SafeTransferFunds(1, 2, 200);

    DBMS_OUTPUT.PUT_LINE('Salary Update');
    UpdateSalary(1, 10);

    DBMS_OUTPUT.PUT_LINE('Add Customer');
    AddNewCustomer(
        3,
        'Supriya Dutta',
        TO_DATE('2003-03-25','YYYY-MM-DD'),
        5000
    );
END;
/