import React, { Component } from 'react';
import './Footer.less';
import { Link } from 'react-router-dom';

class PageFooter extends Component {
    render() {
        return (
            <footer className="component-footer">
                <div className="container">
                    <div>
                        <ul className="left">
                            <li>
                                <Link to="/play">
                                主页
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                博客
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                公平性
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                FAQ
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                ZH
                                </Link>
                            </li>
                        </ul>
                        <ul className="left">
                            <li>
                                <Link to="/play">
                                推荐
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                帮助
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                联系我们
                                </Link>
                            </li>
                        </ul>
                    </div>
                    <Link to="/play" className="logo">  
                        <div className="footer-logo">
                            {/* <img src="../../images/logo.svg" alt="logo"/> */}
                            <span>© 2013 - 2017 Diceroller.</span>
                        </div>
                    </Link>
                    <div>
                        <ul className="right">
                            <li>
                                <Link to="/play">
                                    Forum
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                    比特币论坛
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                    facebook
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                    Twitter
                                </Link>
                            </li>
                        </ul>
                        <ul className="right">
                            <li>
                                <Link to="/play">
                                    Reddit
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                    博彩沉迷预防
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </footer>
        )
    }
}

export default PageFooter;
