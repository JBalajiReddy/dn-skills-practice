function CourseDetails() {
  const courses = [
    { name: "React", status: "Ongoing" },
    { name: "Node.js", status: "Completed" },
  ];

  return (
    <div>
      <h2>Course Details</h2>
      <ul>
        {courses.map((course, idx) => (
          <li key={idx}>
            {course.name} - {course.status}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default CourseDetails;
