SET SERVEROUTPUT ON;

-- Scenario 1
CREATE OR REPLACE FUNCTION CalculateAge(
    dob DATE
)
RETURN NUMBER
IS
    age NUMBER;
BEGIN
    age := FLOOR(MONTHS_BETWEEN(SYSDATE, dob) / 12);
    RETURN age;
END;
/

-- Scenario 2
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    loanAmt NUMBER,
    interestRate NUMBER,
    years NUMBER
)
RETURN NUMBER
IS
    totalAmt NUMBER;
    emi NUMBER;
BEGIN
    totalAmt := loanAmt + (loanAmt * interestRate * years / 100);
    emi := totalAmt / (years * 12);
    RETURN emi;
END;
/

-- Scenario 3
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    accId NUMBER,
    amt NUMBER
)
RETURN VARCHAR2
IS
    bal NUMBER;
BEGIN
    SELECT Balance
    INTO bal
    FROM Accounts
    WHERE AccountID = accId;

    IF bal >= amt THEN
        RETURN 'TRUE';
    ELSE
        RETURN 'FALSE';
    END IF;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(
        'Age : ' ||
        CalculateAge(
            TO_DATE('2004-04-21','YYYY-MM-DD')
        )
    );

    DBMS_OUTPUT.PUT_LINE(
        'Monthly Installment : ' ||
        CalculateMonthlyInstallment(
            500000,
            10,
            5
        )
    );

    DBMS_OUTPUT.PUT_LINE(
        'Sufficient Balance : ' ||
        HasSufficientBalance(
            1,
            500
        )
    );
END;
/