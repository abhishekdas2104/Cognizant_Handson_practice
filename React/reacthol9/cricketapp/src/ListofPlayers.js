import React from 'react';
export function ListofPlayers({ players }) {
  return (
    <div>
      {players.map((item) => {
        return (
          <div key={item.name}>
            <li>Mr. {item.name}<span> {item.score} </span></li>
          </div>
        );
      })}
    </div>
  );
}
export function Scorebelow70({ players }) {
  const players70 = [];
  players.map((item) => {
    if (item.score <= 70) {
      players70.push(item);
    }
    return null;
  });
  return (
    <div>
      {players70.map((item) => (
        <div key={item.name}>
          <li>Mr. {item.name}<span> {item.score} </span></li>
        </div>
      ))}
    </div>
  );
}
