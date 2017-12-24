import React, { Component } from 'react';
import {Tabs} from 'antd';
import {observer, inject} from "mobx-react";
import {velocityHelpers, VelocityTransitionGroup} from 'velocity-react';
import 'velocity-animate/velocity.ui'
const TabPane = Tabs.TabPane;
const duration = 500;
const Animations = {
    // Register these with UI Pack so that we can use stagger later.
    In: velocityHelpers.registerEffect({
      calls: [
        [{
          transformPerspective: [ 800, 800 ],
          transformOriginX: [ '50%', '50%' ],
          transformOriginY: [ '100%', '100%' ],
          marginBottom: 0,
          opacity: 1,
          rotateX: [0, 130],
        }, 1, {
          easing: 'ease-out',
          display: 'block',
        }]
      ],
    }),
  
    Out: velocityHelpers.registerEffect({
      calls: [
        [{
          transformPerspective: [ 800, 800 ],
          transformOriginX: [ '50%', '50%' ],
          transformOriginY: [ '0%', '0%' ],
          marginBottom: -30,
          opacity: 0,
          rotateX: -70,
        }, 1, {
          easing: 'ease-out',
          display: 'block',
        }]
      ],
    }),
  };
  const enterAnimation = {
    animation: Animations.In,
    stagger: duration,
    duration: duration,
    backwards: true,
    display: 'block',
    style: {
      // Since we're staggering, we want to keep the display at "none" until Velocity runs
      // the display attribute at the start of the animation.
      display: 'none',
    },
  };
  const leaveAnimation = {
    animation: Animations.Out,
    stagger: duration,
    duration: duration,
    backwards: true,
  };
  const groupStyle = {
	display: "flex",
    flexDirection: "column",
    width: "100%"
  };
@inject((allStores) => ({
    myStakes: allStores.appStore.myStakesToJs,
    allStakes: allStores.appStore.allStakesToJs,
    highStakes: allStores.appStore.highStakesToJs,
    queryStakeById: allStores.dialogStore.queryStakeById,
    words: allStores.appStore.wordsToJs
}))@observer class BetLists extends Component {
	buildLi(data) {
		return data.map((item, index) => {
			let changeAmtTag ; 
			if (item.fundType === 'FO') {
				changeAmtTag = <span className="red">{item.changeAmtTag.slice(1)}</span>
			} else {
				changeAmtTag = <span className="green">{item.changeAmtTag.slice(1)}</span>
			}
		  return (
			<li key={item.stakeId}>
				<span>
					<a onClick={this.props.queryStakeById.bind(this, item.stakeId)}>
					{item.stakeId}
					</a>
				</span>
				<span>{item.username}</span>
				<span>{item.createTime}</span>
				<span>{item.amt}</span>
				<span>{item.payout}</span>
				<span>{item.targetTag}</span>
				<span>{item.randomResult}</span>
				{changeAmtTag}
			</li>
			)
	  })
	}
    render() {
          const {words} = this.props;
          const title = [words.betLists.yzid, words.betLists.yh, words.betLists.sj, words.betLists.yz, words.betLists.pc, words.betLists.yx, words.betLists.tz, words.betLists.yl];
          const titleItem = title.map((item, index) => {
              return <strong key={item}><span>{item}</span></strong>
          })
		  const myStakesItems = this.buildLi(this.props.myStakes)
		  const allStakesItems = this.buildLi(this.props.allStakes)
		  const highStakesItems = this.buildLi(this.props.highStakes)
          return(
            
            <div style={{background: "#ffffff", paddingTop: '30px'}}>
                <div className="betLists">
                    <Tabs defaultActiveKey="1">
                        <TabPane tab={words.betLists.wdyz} key="1">
							<VelocityTransitionGroup
								component='ul'
								style={groupStyle} 
								enter={enterAnimation} 
								leave={leaveAnimation}
							>
                                <li>{titleItem}</li>
                                {myStakesItems}
                            </VelocityTransitionGroup> 
                        </TabPane>
                        <TabPane tab={words.betLists.syyz} key="2">
							<VelocityTransitionGroup
								component='ul'
								style={groupStyle} 
								enter={enterAnimation} 
								leave={leaveAnimation}
							>
                                <li>{titleItem}</li>
                                {allStakesItems}
                            </VelocityTransitionGroup> 
                            {/* <Table pagination={false} columns={columns} dataSource={this.props.allStakes} /> */}
                        </TabPane>
                        <TabPane tab={words.betLists.dedzwj} key="3">
						<VelocityTransitionGroup
								component='ul'
								style={groupStyle} 
								enter={enterAnimation} 
								leave={leaveAnimation}
							>
                                <li>{titleItem}</li>
                                {highStakesItems}
                            </VelocityTransitionGroup> 
                            {/* <Table pagination={false} columns={columns} dataSource={this.props.highStakes} /> */}
                        </TabPane>
                    </Tabs>
                </div>
            </div>
        )
    }
}
export default BetLists;