import React, { Component } from "react";
import PropTypes from "prop-types";

export class AddTodo extends Component {
  state = {
    description: "",
  };

  onSubmit = (e) => {
    e.preventDefault();
    this.props.addTodo(this.state.description);
    this.setState({ description: "" });
    window.location.reload(false);
  };

  onChange = (e) => this.setState({ description: e.target.value });

  render() {
    return (
      <form onSubmit={this.onSubmit} style={{ display: "flex" }}>
        <input
          type="text"
          name="description"
          style={{ flex: "10", padding: "5px" }}
          placeholder="Add Todo..."
          value={this.state.description}
          onChange={this.onChange}
        />
        <input
          type="submit"
          value="Submit"
          className="btn btn-primary"
          style={{ flex: "1" }}
        />
      </form>
    );
  }
}

// PropTypes
AddTodo.propTypes = {
  addTodo: PropTypes.func.isRequired,
};

export default AddTodo;
