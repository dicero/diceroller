import React from 'react';
import {
    Route,
    Switch,
    Redirect
} from 'react-router-dom'
import Play from './component/Play/Play.js';
import Verify from './component/Verify/Verify.js';
import Settings from './component/Settings/Settings.js';
import Contract from './component/Contract/Contract.js';
const Routers = () => {
    return (
        <Switch>
            <Route path="/" exact render={ () => (
                <Redirect to="/play" />
            )}/>
            <Route path="/play" exact component={Play} />
            <Route path="/verify" exact component={Verify} />
            <Route path="/account/settings" exact component={Settings} />
            <Route path="/Contract" exact component={Contract} />
            {/* <Route path="/account" exact component={() => 'account'} /> */}
        </Switch>
    )
}

export default Routers;