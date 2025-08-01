import { useState } from "react";

function CurrencyConvertor() {
  const [rupees, setRupees] = useState("");
  const [euro, setEuro] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    setEuro((parseFloat(rupees) / 90).toFixed(2)); // Example rate
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        type="number"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
        placeholder="Enter Rupees"
      />
      <button type="submit">Convert</button>
      {euro && (
        <p>
          {rupees} INR = {euro} EUR
        </p>
      )}
    </form>
  );
}

export default CurrencyConvertor;
