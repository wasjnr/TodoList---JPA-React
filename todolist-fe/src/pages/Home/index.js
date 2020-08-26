import React, { Component } from "react";
import api from "../../services/api";

import { BrowserRouter as Router, Route } from "react-router-dom";

import Todos from "../../components/Todos";
import Header from "../../components/layout/Header";
import AddTodo from "../../components/AddTodo";
import About from "../About/index";

import "./style.css";

class Home extends Component {
  state = {
    todos: [],
  };

  componentDidMount() {
    api.get("/todo").then((res) => this.setState({ todos: res.data }));
    console.log(
      api.get("/todo").then((res) => this.setState({ todos: res.data }))
    );
  }

  markComplete = (id) => {
    this.setState({
      todos: this.state.todos.map((todo) => {
        if (todo.id === id) todo.completed = !todo.completed;
        return todo;
      }),
    });
  };

  delTodo = (id) => {
    api.delete(`/todo/${id}`).then((res) =>
      this.setState({
        todos: [...this.state.todos.filter((todo) => todo.id !== id)],
      })
    );
  };

  addTodo = (description) => {
    api
      .post("/todo", {
        description: description,
        completed: false,
      })
      .then((res) =>
        this.setState({
          todos: [...this.state.todos, res.data],
        })
      );
  };

  render() {
    return (
      <Router>
        <div className="Home">
          <div className="container">
            <Header />
            <br />
            <Route
              exact
              path="/"
              render={(props) => (
                <React.Fragment>
                  <AddTodo addTodo={this.addTodo} />
                  <Todos
                    todos={this.state.todos}
                    markComplete={this.markComplete}
                    delTodo={this.delTodo}
                  />
                </React.Fragment>
              )}
            />

            <Route path="/about" component={About} />
          </div>
        </div>
      </Router>
    );
  }
}

export default Home;
