import React from 'react';
class Cart extends React.Component {
  render() {
    return (
      this.props.item.map((item) => {
        return (
          <tr key={item.itemname}>
            <td>{item.itemname}</td>
            <td>{item.price}</td>
          </tr>
        );
      })
    );
  }
}
export default Cart;
