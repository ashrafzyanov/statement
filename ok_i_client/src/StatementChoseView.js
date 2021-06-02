import React from 'react';
import { BrowserRouter as Router, Link, Route, Switch } from 'react-router-dom';
import StatementParamFillView from './StatementParamFillView';
export default class StatementChoseView extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            statements: null
        }
    }

    componentDidMount() {
        fetch("./server/api/statement")
            .then(res => res.json())
            .then(statements => {
                this.setState({statements})
            })
    }

    render() {
        const {statements} = this.state;
        return (
            <Router>
            <div>
            <h3>Statement</h3>
            <ul>
            {statements ? (
                statements.map(statement => (
                    <li>
                    <Link to={location => `/statements/${statement.id}`}>
                        {statement.name}
                    </Link>
                    </li>
                ))
            ) : (
                <div>Loading...</div>
            )}
            <Switch>
                <Route path="/statements/:id" children={<StatementParamFillView />}></Route>
            </Switch>
            </ul>
            </div>
            </Router>
        )
    }
    
}