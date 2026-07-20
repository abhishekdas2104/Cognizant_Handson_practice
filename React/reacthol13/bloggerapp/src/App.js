import React from 'react';
const courses = [
  { id: 1, cname: 'Angular', startdate: '4/5/2021' },
  { id: 2, cname: 'React', startdate: '6/3/20201' }
];
const books = [
  { id: 1, bname: 'Master React', price: 670 },
  { id: 2, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 3, bname: 'Mongo Essentials', price: 450 }
];
const blogs = [
  { id: 1, title: 'React Learning', author: 'Stephen Biz', content: 'Welcome to learning React!' },
  { id: 2, title: 'Installation', author: 'Schewzdenier', content: 'You can install React from npm.' }
];
function CourseDetails(props) {
  return (
    <div style={{ flex: 1, padding: '20px', textAlign: 'center' }}>
      <h2>Course Details</h2>
      {props.courses && props.courses.map(course => (
        <div key={course.id}>
          <h3>{course.cname}</h3>
          <p>{course.startdate}</p>
        </div>
      ))}
    </div>
  );
}
function BookDetails(props) {
  return (
    <div style={{ flex: 1, padding: '20px', textAlign: 'center', borderLeft: '3px solid green', borderRight: '3px solid green' }}>
      <h2>Book Details</h2>
      {props.books ? (
        props.books.map(book => (
          <div key={book.id}>
            <h3>{book.bname}</h3>
            <p>{book.price}</p>
          </div>
        ))
      ) : null}
    </div>
  );
}
function BlogDetails(props) {
  const showBlogs = props.blogs.length > 0;
  return (
    <div style={{ flex: 1, padding: '20px', textAlign: 'center' }}>
      <h2>Blog Details</h2>
      {showBlogs && props.blogs.map(blog => (
        <div key={blog.id}>
          <h3>{blog.title}</h3>
          <p><b>{blog.author}</b></p>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
}
function App() {
  return (
    <div style={{ display: 'flex', justifyContent: 'space-between', margin: '40px' }}>
      <CourseDetails courses={courses} />
      <BookDetails books={books} />
      <BlogDetails blogs={blogs} />
    </div>
  );
}
export default App;
