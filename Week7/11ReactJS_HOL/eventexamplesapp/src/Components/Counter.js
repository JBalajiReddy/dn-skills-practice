import { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  const sayHello = () => {
    alert("Hello! Counter increased.");
  };

  const handleIncrement = () => {
    setCount(count + 1);
    sayHello();
  };

  return (
    <div>
      <h2>Counter: {count}</h2>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={() => setCount(count - 1)}>Decrement</button>
    </div>
  );
}

export default Counter;
