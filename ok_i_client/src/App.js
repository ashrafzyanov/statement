import { BrowserRouter as Router, Route } from 'react-router-dom';
import StatementChoseView from './StatementChoseView';
import StatementParamFillView from './StatementParamFillView';
function App() {
    return (
        <Router>
                <Route exact path="/">
                    <StatementChoseView />
                </Route>
                <Route path="/statements/:id">
                    <StatementParamFillView />
                </Route>
        </Router>
        )
}
export default App;
