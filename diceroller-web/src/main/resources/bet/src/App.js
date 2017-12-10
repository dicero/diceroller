import React, { Component } from 'react';
import { Layout } from 'antd';
import './App.less';

import NavMenu from './component/Header/NavMenu.js'
import PageFooter from './component/Footer/PageFooter.js'
import Routers from './Routers.js';

const { Header, Footer, Content } = Layout;

class App extends Component {
	render() {
		return (
			<div className="App">
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
