import React, { useState } from 'react';
function CurrencyConvertor() {
  const [amount, setAmount] = useState('');
  const handleSubmit = (e) => {
    e.preventDefault();
    const converted = parseFloat(amount) * 80;
    alert(`Converting to Euro Amount is ${converted}`);
  };
  return (
    <div>
      <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Amount: </label>
          <input type="text" value={amount} onChange={(e) => setAmount(e.target.value)} />
        </div>
        <div>
          <label>Currency: </label>
          <input type="text" value="Euro" readOnly />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}
export default CurrencyConvertor;
