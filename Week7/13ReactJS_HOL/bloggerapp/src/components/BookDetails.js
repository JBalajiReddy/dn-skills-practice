function BookDetails() {
  const books = [
    { id: 1, title: "Atomic Habits", author: "James Clear" },
    { id: 2, title: "The Alchemist", author: "Paulo Coelho" },
  ];

  return (
    <div>
      <h2>Book Details</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
            {book.title} by {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default BookDetails;
