import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import {Provider} from 'mobx-react';
import registerServiceWorker from './registerServiceWorker';
import {
    BrowserRouter as Router
} from 'react-router-dom';
import RootStore from './Store/RootStore.js';
const rootStore = new RootStore()
const {appStore, dialogStore} = rootStore;
ReactDOM.render(
    <Router>
        <Provider appStore = {appStore} dialogStore = {dialogStore}>
            <App />
        </Provider>
    </Router>,

    document.getElementById('root')
);
registerServiceWorker();
