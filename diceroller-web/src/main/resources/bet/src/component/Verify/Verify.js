import React, { Component } from 'react';
import { Layout} from 'antd';
import './Verify.less';
import {
    Link
} from 'react-router-dom'
const {Content } = Layout;

class Verify extends Component {
    render() {
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
                <h2>认证 <Link to="/play"><span><svg class="account__close" width="16" height="16" viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg"><g fill="none" fill-rule="evenodd"><path d="m585 5.611l-1.611-1.611-6.389 6.389-6.389-6.389-1.611 1.611 6.389 6.389-6.389 6.389 1.611 1.611 6.389-6.389 6.389 6.389 1.611-1.611-6.389-6.389 6.389-6.389" transform="translate(-569-4)" fill="#fff"></path></g></svg></span></Link></h2>
                <Layout  >
                <Content style={{width:"910px",margin:"0 auto"}}>
                    <div>
                        <h3>F公平性</h3>
                        <p>Diceroller提供顶最优质的认证系统，可以让我们的用户确认每一次掷骰的公正性，并确保过程不受人为操纵。我们的随机数是通过两个种子生成的，一个是服务器种子，另一个是您的用户种子。服务器种子是在您确认自己的用户种子之前生成的，这确保了生成的服务器种子不会偏向我们。它们一起，再加上一个随机一次性数字（种子对下注次数），可以生成在0-99.99范围内的可证实随机的骰子数。</p>
                        <h3>种子</h3>
                        <p>通过可证实公平按钮，用户可以更改和验证使用的种子。您可点击页面上方可验证公平按钮旁边的 "随机"按钮实现这一功能。在您选择自己的种子之前，页面会显示服务器所有SHA256散列，其中所有数字都可以与您选择的种子配对使用。更改用户种子时也会显示之前的服务器种子，您可以通过这一过程看到该服务器种子的确是您之前选择的。</p>
                        <h3>骰子数</h3>
                        <p>Diceroller使用多步过程生成一个在0-99.99之间的骰子数。用户种子、服务器种子和一个随机一次性数值会通过 hmac-sha512(server_seed, client_seed-nonce) 结合，生成一个十六位字符串。随机一次性数值是您使用当前种子对的下注次数。该字符串的前五位会被用来生成一个0-1,048,575之间的骰子数。如果这个数字大于999,999，那么系统将跳过这一组字符，重复这一步骤，直到生成的数值小于1,000,000。假如发生没有任何五位满足条件的小概率事件，那么将取99.99作为骰子数。生成的满足条件的数字会除以10^2，生成一个0-99.99之间的数字。</p>
                        <h3>如何验证</h3>
                        <p>您可以使用第三方工具验证数字的公平性，或使用下列Node.js代码重新运行以上过程。运行结果将与您的骰子数一致。</p>
                        <pre className="verify__code">{seedCode}</pre>
                    </div>
                </Content>
            </Layout> 
            </div>
             
        )
    }
}

export default Verify;