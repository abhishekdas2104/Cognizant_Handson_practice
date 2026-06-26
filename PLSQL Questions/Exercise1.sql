SET SERVEROUTPUT ON;

BEGIN
    -- Scenario 1
    FOR c IN (
        SELECT CustomerID, Name, DOB
        FROM Customers
    ) LOOP
        IF MONTHS_BETWEEN(SYSDATE, c.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE('Discount applied to ' || c.Name);
        END IF;
    END LOOP;

    -- Scenario 2
    FOR c IN (
        SELECT CustomerID, Name, Balance
        FROM Customers
    ) LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;

            DBMS_OUTPUT.PUT_LINE(c.Name || ' is now VIP');
        END IF;
    END LOOP;

    -- Scenario 3
    FOR l IN (
        SELECT c.Name, l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Loan of ' || l.Name ||
            ' is due on ' || TO_CHAR(l.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;

    COMMIT;
END;
/