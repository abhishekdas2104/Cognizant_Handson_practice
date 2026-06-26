SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

-- Scenario 2
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog
    VALUES (:NEW.TransactionID, 'Transaction added', SYSDATE);
END;
/

-- Scenario 3
CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    bal NUMBER;
BEGIN
    SELECT Balance INTO bal
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.TransactionType = 'Withdrawal' AND :NEW.Amount > bal THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance');
    END IF;

    IF :NEW.TransactionType = 'Deposit' AND :NEW.Amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Invalid deposit amount');
    END IF;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE('Triggers created successfully.');
END;
/