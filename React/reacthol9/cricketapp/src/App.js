import React from 'react';
import { ListofPlayers, Scorebelow70 } from './ListofPlayers';
import { OddPlayers, EvenPlayers, ListofIndianPlayers, IndianPlayers } from './IndianPlayers';
const players = [
  { name: 'Sachin', score: 95 },
  { name: 'Rohit', score: 85 },
  { name: 'Virat', score: 90 },
  { name: 'Dhoni', score: 75 },
  { name: 'Jadeja', score: 65 },
  { name: 'Bumrah', score: 45 },
  { name: 'Rahul', score: 80 },
  { name: 'Shami', score: 55 },
  { name: 'Pandya', score: 70 },
  { name: 'Ashwin', score: 60 },
  { name: 'Pant', score: 72 }
];
const IndianTeam = ['Sachin', 'Rohit', 'Virat', 'Dhoni', 'Jadeja', 'Bumrah'];
function App() {
  var flag = true;
  if (flag === true) {
    return (
      <div>
        <h1> List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1> List of Players having Scores Less than 70 </h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <div>
          <h1> Indian Team </h1>
          <h1> Odd Players </h1>
          {OddPlayers(IndianTeam)}
          <hr />
          <h1> Even Players</h1>
          {EvenPlayers(IndianTeam)}
        </div>
        <hr />
        <div>
          <h1> List of Indian Players Merged:</h1>
          <ListofIndianPlayers IndianPlayers={IndianPlayers} />
        </div>
      </div>
    );
  }
}
export default App;
