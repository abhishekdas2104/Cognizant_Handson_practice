SET SERVEROUTPUT ON;

CREATE OR REPLACE PACKAGE CustomerManagement AS
    PROCEDURE AddCustomer;
    FUNCTION GetBalance RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS
    PROCEDURE AddCustomer IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('New customer added.');
    END;
    FUNCTION GetBalance RETURN NUMBER IS
    BEGIN
        RETURN 1000;
    END;

END;
/

CREATE OR REPLACE PACKAGE EmployeeManagement AS
    PROCEDURE HireEmployee;
    FUNCTION AnnualSalary RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS
    PROCEDURE HireEmployee IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Employee hired.');
    END;
    FUNCTION AnnualSalary RETURN NUMBER IS
    BEGIN
        RETURN 70000 * 12;
    END;
END;
/

CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenAccount;
    FUNCTION TotalBalance RETURN NUMBER;
END;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS
    PROCEDURE OpenAccount IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Account opened.');
    END;
    FUNCTION TotalBalance RETURN NUMBER IS
    BEGIN
        RETURN 5000;
    END;
END;
/

BEGIN
    CustomerManagement.AddCustomer;
    DBMS_OUTPUT.PUT_LINE(
        'Balance = ' ||
        CustomerManagement.GetBalance
    );
    EmployeeManagement.HireEmployee;
    DBMS_OUTPUT.PUT_LINE(
        'Annual Salary = ' ||
        EmployeeManagement.AnnualSalary
    );
    AccountOperations.OpenAccount;
    DBMS_OUTPUT.PUT_LINE(
        'Total Balance = ' ||
        AccountOperations.TotalBalance
    );
END;
/