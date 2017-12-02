import React, { Component } from 'react';
import { Slider, InputNumber, Row, Col, Icon} from 'antd';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
  chance: allStores.appStore.chance,
  diceRoll: allStores.appStore.diceRoll,
  rollOver: allStores.appStore.rollOver,
  changeChance: allStores.appStore.changeChance,
  showMark: allStores.appStore.showMark,
  marks: allStores.appStore.marks
}))@observer class RateSlider extends Component {
    constructor(props) {
      super(props)
    }
    tipFormatter(value) {
      return this.props.diceRoll;
    }
    onChange(value) {
      let chance;
      if(this.props.rollOver) {
        if (value >= 2&&value<=99) {
          chance = 100-value;
        } else {
          chance = Number(this.props.chance);
        }
      } else {
        if (value >= 2&&value<=99) {
          chance = Number(value);
        } else {
          chance = Number(this.props.chance)
        }
      }
      this.props.changeChance(chance)
    }
    render() {
      const {diceRoll, rollOver} = this.props;
      let min, max;
      const marks = {
        0: {
          style: {
            color: '#ffffff',
            marginLeft: "-45%",
            left: "5px"
          },
          label: 0,
        },
        100: {
          style: {
            color: '#ffffff',
            left:'99%'
          },
          label: 100
        }
      }
      if (rollOver) {
        min = 2;
        max = 99;
      } else {
        min = 1;
        max = 98;
      }
      return (
        <div style={{marginTop: "70px", position: 'relative'}}>
          <div className="sliderWarp">
            <div className="slider" style={{margin: "0px 6px"}}>
              <span className={this.props.showMark? "marks" : "marks no"} style={{left: `${this.props.marks}%`}}>{this.props.marks}</span>
            </div>
          </div>
          <Row >
            <Col span={24} >
              <div className={rollOver? '':' is-reversed'} style={{overflow: "hidden"}}>
              
              <Slider marks={marks} min={0} max={101} onChange={this.onChange.bind(this)} tipFormatter={this.tipFormatter.bind(this)} value={parseFloat(diceRoll)} />
              </div>
            </Col>
          </Row>
        </div>
      );
    }
  }
  export default RateSlider;