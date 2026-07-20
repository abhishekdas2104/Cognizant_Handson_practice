import React, { Component } from 'react';
class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      person: null,
      loading: true
    };
  }
  async componentDidMount() {
    const url = "https://api.randomuser.me/";
    const response = await fetch(url);
    const data = await response.json();
    this.setState({ person: data.results[0], loading: false });
    console.log(data.results[0]);
  }
  render() {
    if (this.state.loading) {
      return <div>Loading...</div>;
    }
    const { name, picture } = this.state.person;
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2>{name.title} {name.first} {name.last}</h2>
        <img src={picture.large} alt="User profile" />
      </div>
    );
  }
}
export default Getuser;
