import React, { Component } from 'react';
import { Slider, InputNumber, Row, Col } from 'antd';

class RateSlider extends Component {
    render() {
      const {rate} = this.props;
      const {onChangeRate} = this.props;
      return (
        <Row>
          <Col span={24}>
            <Slider min={1} max={99} onChange={onChangeRate} value={rate} />
          </Col>
        </Row>
      );
    }
  }
  export default RateSlider;