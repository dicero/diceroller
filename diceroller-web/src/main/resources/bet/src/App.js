import React, { Component } from 'react';
import { Layout, Spin } from 'antd';
import './App.less';

import NavMenu from './component/Header/NavMenu.js'
import PageFooter from './component/Footer/PageFooter.js'
import Routers from './Routers.js';
import {observer, inject} from "mobx-react";
import Advise from './component/dialog/Advise.js';

const { Header, Footer, Content } = Layout;

@inject((allStores) => ({
    loading: allStores.dialogStore.loading
}))@observer class App extends Component {
	render() {
		return (
			<div className="App">
				{this.props.loading && <div className="loading"></div>}
				<Advise/>
				<Layout>
					<Header style={{ position: 'fixed', width: '100%' }}>
						<NavMenu></NavMenu>	
					</Header>
					<Content style={{marginTop: 64 }}>
						<Routers/>
					</Content>
					<Footer style={{ textAlign: 'center' }}><PageFooter/></Footer>
				</Layout>
				
			</div>
		);
	}
}

export default App;
