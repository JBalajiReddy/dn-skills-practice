import React, { useState } from "react";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";

function App() {
  const [view, setView] = useState("books");

  const renderComponent = () => {
    // Switch statement rendering
    switch (view) {
      case "books":
        return <BookDetails />;
      case "blogs":
        return <BlogDetails />;
      case "courses":
        return <CourseDetails />;
      default:
        return <h3>Select a view</h3>;
    }
  };

  return (
    <div className="App">
      <h1>Blogger App Dashboard</h1>

      <div>
        <button onClick={() => setView("books")}>Show Books</button>
        <button onClick={() => setView("blogs")}>Show Blogs</button>
        <button onClick={() => setView("courses")}>Show Courses</button>
      </div>

      <hr />

      {/* Ternary Rendering */}
      {view === "books" ? <p> Viewing Books</p> : null}

      {/* Logical AND Rendering */}
      {view === "blogs" && <p>Viewing Blogs</p>}

      {/* Inline IIFE rendering */}
      {(() => {
        if (view === "courses") return <p>Viewing Courses</p>;
        return null;
      })()}

      {/* Function-based rendering */}
      {renderComponent()}
    </div>
  );
}

export default App;
