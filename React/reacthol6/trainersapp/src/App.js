import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetails from './TrainerDetails';
function App() {
  return (
    <BrowserRouter>
      <h1>My Academy Trainers App</h1>
      <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/trainers" element={<TrainersList />} />
        <Route path="/trainers/:id" element={<TrainerDetails />} />
      </Routes>
    </BrowserRouter>
  );
}
export default App;
