SET SERVEROUTPUT ON;

-- Scenario 1
DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT c.Name, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE MONTHS_BETWEEN(SYSDATE, t.TransactionDate) < 1;
BEGIN
    DBMS_OUTPUT.PUT_LINE('Monthly Statements');

    FOR rec IN GenerateMonthlyStatements LOOP
        DBMS_OUTPUT.PUT_LINE(
            rec.Name || ' - ' || rec.TransactionType || ' - ' || rec.Amount
        );
    END LOOP;
END;
/

-- Scenario 2
DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID
        FROM Accounts;
BEGIN
    FOR rec IN ApplyAnnualFee LOOP
        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = rec.AccountID;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual fee applied.');
END;
/

-- Scenario 3
DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID
        FROM Loans;
BEGIN
    FOR rec IN UpdateLoanInterestRates LOOP
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = rec.LoanID;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated.');
END;
/