import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';
function EmployeeCard({ name, role }) {
  const theme = useContext(ThemeContext);
  return (
    <div style={{ border: '1px solid #ccc', padding: '10px', margin: '10px', borderRadius: '5px' }}>
      <h4>{name}</h4>
      <p>{role}</p>
      <button className={theme === 'dark' ? 'btn-dark' : 'btn-light'}>
        View Details
      </button>
    </div>
  );
}
export default EmployeeCard;
