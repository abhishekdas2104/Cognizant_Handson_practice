import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';
class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 5
    };
  }
  handleIncrement() {
    this.setState((state) => ({ counter: state.counter + 1 }));
    this.sayHello();
  }
  handleDecrement() {
    this.setState((state) => ({ counter: state.counter - 1 }));
  }
  sayHello() {
    alert("Hello! Member1");
  }
  sayWelcome(msg) {
    alert(msg);
  }
  handleSyntheticEvent(e) {
    alert("I was clicked");
  }
  render() {
    return (
      <div>
        <p>{this.state.counter}</p>
        <button onClick={() => this.handleIncrement()}>Increment</button>
        <br />
        <button onClick={() => this.handleDecrement()}>Decrement</button>
        <br />
        <button onClick={() => this.sayWelcome("welcome")}>Say welcome</button>
        <br />
        <button onClick={(e) => this.handleSyntheticEvent(e)}>Click on me</button>
        <hr />
        <CurrencyConvertor />
      </div>
    );
  }
}
export default App;
