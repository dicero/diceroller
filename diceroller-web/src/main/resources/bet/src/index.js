import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import {Provider} from 'mobx-react';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter as Router
} from 'react-router-dom';
import AppStore from './Store/AppStore.js';
import DialogStore from './Store/DialogStore.js';
ReactDOM.render(
    <Router>
        <Provider appStore = {new AppStore()} dialogStore = {new DialogStore()}>
            <App />
        </Provider>
    </Router>,

    document.getElementById('root')
);
registerServiceWorker();
