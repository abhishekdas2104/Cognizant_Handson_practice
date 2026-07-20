import React from 'react';
import EmployeeCard from './EmployeeCard';
function EmployeesList() {
  const employees = [
    { id: 1, name: 'Alice Smith', role: 'Software Engineer' },
    { id: 2, name: 'Bob Jones', role: 'Product Manager' }
  ];
  return (
    <div>
      <h3>Employees List</h3>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} name={emp.name} role={emp.role} />
      ))}
    </div>
  );
}
export default EmployeesList;
