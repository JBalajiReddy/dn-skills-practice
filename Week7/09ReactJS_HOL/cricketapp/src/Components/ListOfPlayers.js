function ListOfPlayers() {
  const players = [
    { name: "Virat Kohli", score: 82 },
    { name: "Rohit Sharma", score: 45 },
    { name: "KL Rahul", score: 90 },
    { name: "Shreyas Iyer", score: 67 },
    { name: "Hardik Pandya", score: 30 },
    { name: "Jadeja", score: 55 },
    { name: "Bumrah", score: 76 },
    { name: "Chahal", score: 69 },
    { name: "Gill", score: 91 },
    { name: "Pant", score: 65 },
    { name: "Siraj", score: 72 },
  ];

  // Players with scores below 70 using arrow function
  const below70 = players.filter((player) => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>
      <ul>
        {players.map((p, i) => (
          <li key={i}>
            {p.name} - {p.score}
          </li>
        ))}
      </ul>
      <h2>Players with score below 70</h2>
      <ul>
        {below70.map((p, i) => (
          <li key={i}>
            {p.name} - {p.score}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ListOfPlayers;
