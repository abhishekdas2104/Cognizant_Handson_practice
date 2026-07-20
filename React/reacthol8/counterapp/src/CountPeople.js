import React from 'react';
class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0,
      c: 0
    };
  }
  updateEntry() {
    this.setState((prevState, props) => {
      return { entrycount: prevState.entrycount + 1 };
    });
  }
  updateExit() {
    this.setState((prevState, props) => {
      return { exitcount: prevState.exitcount + 1 };
    });
  }
  render() {
    return (
      <div>
        <button onClick={() => this.updateEntry()}>Login</button>
        <span> {this.state.entrycount} People Entered!!! </span>
        <button onClick={() => this.updateExit()}>Exit</button>
        <span> {this.state.exitcount} People Left!!!</span>
      </div>
    );
  }
}
export default CountPeople;
