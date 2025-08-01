import "./App.css";

function App() {
  const officeSpaces = [
    {
      name: "WeWork",
      rent: 55000,
      address: "Mumbai",
    },
    {
      name: "Awfis",
      rent: 75000,
      address: "Bangalore",
    },
    {
      name: "Regus",
      rent: 60000,
      address: "Hyderabad",
    },
  ];

  const getRentStyle = (rent) => {
    return {
      color: rent < 60000 ? "red" : "green",
    };
  };

  return (
    <div className="App">
      <h1>Office Space Rental App</h1>

      <img
        src="https://cdn.sanity.io/images/uqxwe2qj/production/62db3c671745e98cb27690dff96f8033d2bb7f35-2048x1010.jpg"
        width="25%"
        height="25%"
        alt="Office"
        style={{ margin: "20px", borderRadius: "10px" }}
      />

      <h2>Available Offices</h2>
      {officeSpaces.map((office, index) => (
        <div
          key={index}
          style={{ border: "1px solid #ccc", margin: "10px", padding: "10px" }}
        >
          <p>
            <strong>Name:</strong> {office.name}
          </p>
          <p>
            <strong>Address:</strong> {office.address}
          </p>
          <p style={getRentStyle(office.rent)}>
            <strong>Rent:</strong> ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
