function SyntheticButton() {
  const handleClick = (event) => {
    alert("I was clicked");
  };

  return <button onClick={handleClick}>OnPress</button>;
}

export default SyntheticButton;
