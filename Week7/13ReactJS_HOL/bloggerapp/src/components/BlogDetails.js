function BlogDetails() {
  const blogs = ["React Hooks", "ES6 Features", "JSX Tips"];

  return (
    <div>
      <h2>Blog Details</h2>
      <ul>
        {blogs.map((blog, index) => (
          <li key={index}>{blog}</li>
        ))}
      </ul>
    </div>
  );
}

export default BlogDetails;
