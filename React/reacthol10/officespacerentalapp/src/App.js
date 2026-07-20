import React from 'react';
const sr = 'https://images.unsplash.com/photo-1497366216548-37526070297c?w=400';
const officeList = [
  { Name: 'DBS', Rent: 50000, Address: 'Chennai' },
  { Name: 'TechHub', Rent: 75000, Address: 'Bangalore' },
  { Name: 'WorkNest', Rent: 45000, Address: 'Mumbai' }
];
function App() {
  const element = 'Office Space';
  const jsxatt = <img src={sr} width="25%" height="25%" alt="Office Space" />;
  return (
    <div>
      <h1>{element} , at Affordable Range</h1>
      {jsxatt}
      {officeList.map((ItemName, index) => {
        let colors = [];
        if (ItemName.Rent <= 60000) {
          colors.push('red');
        } else {
          colors.push('green');
        }
        return (
          <div key={index}>
            <h2>Name: {ItemName.Name}</h2>
            <h3 style={{ color: colors[0] }}>Rent: Rs. {ItemName.Rent}</h3>
            <h3>Address: {ItemName.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}
export default App;
