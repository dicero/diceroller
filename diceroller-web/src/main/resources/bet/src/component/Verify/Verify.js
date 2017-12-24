import React, { Component } from 'react';
import { Layout} from 'antd';
import './Verify.less';
import {
    Link
} from 'react-router-dom';
import {observer, inject} from "mobx-react";
const {Content } = Layout;

@inject((allStores) => ({
    words: allStores.appStore.wordsToJs
}))@observer class Verify extends Component {
    
    render() {
        const {words} = this.props;
const seedCode = `//the seed pair itself
var clientSeed = "your client seed"; //dont forget to exclude the dash and the nonce!
var serverSeed = "your server seed";

//bet made with seed pair (excluding current bet)
var nonce      = 0;

//crypto lib for hmac function
var crypto = require('crypto');

var roll = function(key, text) {

    //create HMAC using server seed as key and client seed as message
    var hash = crypto.createHmac('sha512', key).update(text).digest('hex');

    var index = 0;

    var lucky = parseInt(hash.substring(index * 5, index * 5 + 5), 16);

    //keep grabbing characters from the hash while greater than
    while (lucky >= Math.pow(10, 6)) {
        index++;
        lucky = parseInt(hash.substring(index * 5, index * 5 + 5), 16);

        //if we reach the end of the hash, just default to highest number
        if (index * 5 + 5 > 128) {
            lucky = 99.99;
            break;
        }
    }

    lucky %= Math.pow(10, 4);
    lucky /= Math.pow(10, 2);

    return lucky;
}

console.log(roll(serverSeed, clientSeed+'-'+nonce));
`;
        return (
            <div className="verify">
                <h2>{words.verify.rz} <Link to="/play"><span><svg class="account__close" width="16" height="16" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg"><g fill="none" fill-rule="evenodd"><path d="m585 5.611l-1.611-1.611-6.389 6.389-6.389-6.389-1.611 1.611 6.389 6.389-6.389 6.389 1.611 1.611 6.389-6.389 6.389 6.389 1.611-1.611-6.389-6.389 6.389-6.389" transform="translate(-569-4)" fill="#fff"></path></g></svg></span></Link></h2>
                <Layout  >
                <Content style={{width:"910px",margin:"0 auto"}}>
                    <div>
                        <h3>{words.verify.h31}</h3>
                        <p>{words.verify.p1}</p>
                        <h3>{words.verify.h32}</h3>
                        <p>{words.verify.p2}</p>
                        <h3>{words.verify.h33}</h3>
                        <p>{words.verify.p3}</p>
                        <h3>{words.verify.h34}</h3>
                        <p>{words.verify.p4}</p>
                        <pre className="verify__code">{seedCode}</pre>
                    </div>
                </Content>
            </Layout> 
            </div>
             
        )
    }
}

export default Verify;