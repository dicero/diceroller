import React from 'react';
import {
    Route,
    Switch,
    Redirect
} from 'react-router-dom'
import Play from './component/Play/Play.js';
const Routers = () => {
    return (
        <Switch>
            <Route path="/" exact render={ () => (
                <Redirect to="/play" />
            )}/>
            <Route path="/play" exact component={Play} />
            {/* <Route path="/account" exact component={() => 'account'} /> */}
        </Switch>
    )
}

export default Routers;