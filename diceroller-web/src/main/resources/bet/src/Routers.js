import React from 'react';
import {
    Route,
    Switch,
    Redirect
} from 'react-router-dom'
import Play from './component/Play/Play.js';
import Verify from './component/Verify/Verify.js';
const Routers = () => {
    return (
        <Switch>
            <Route path="/" exact render={ () => (
                <Redirect to="/play" />
            )}/>
            <Route path="/play" exact component={Play} />
            <Route path="/verify" exact component={Verify} />
            
            {/* <Route path="/account" exact component={() => 'account'} /> */}
        </Switch>
    )
}

export default Routers;