import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';
function App() {
  const [theme, setTheme] = useState('light');
  const toggleTheme = () => {
    setTheme(prev => (prev === 'light' ? 'dark' : 'light'));
  };
  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ padding: '20px' }}>
        <h2>Employee Management Portal</h2>
        <button onClick={toggleTheme}>Toggle Theme</button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}
export default App;
