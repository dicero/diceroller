import React, { Component } from 'react';
import { Slider, InputNumber, Row, Col, Icon} from 'antd';

class RateSlider extends Component {
    render() {
      const {rate, betCount} = this.props;
      const {onChangeRate} = this.props;
      return (
        <Row style={{marginTop: "20px"}}>
          <Col span={24} >
            <Slider className="betCount" min={1} max={99} disabled={false} value={parseFloat(betCount)} />
          </Col>
          <Col span={24}>
            <Slider min={1} max={99} onChange={onChangeRate} value={parseFloat(rate)} />
          </Col>
        </Row>
      );
    }
  }
  export default RateSlider;