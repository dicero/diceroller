import React, { Component } from 'react';
import './Footer.less';
import { Link } from 'react-router-dom';
import {observer, inject} from "mobx-react";

@inject((allStores) => ({
    words: allStores.appStore.wordsToJs
}))@observer class PageFooter extends Component {
    
    render() {
        const {words, setLanguageCf} = this.props;
        return (
            <footer className="component-footer">
                <div className="container">
                    <div>
                        <ul className="left">
                            <li>
                                <Link to="/play">
                                {words.foot.zy}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.bk}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.gpx}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.faq}
                                </Link>
                            </li>
                        </ul>
                        <ul className="left">
                            <li>
                                <Link to="/play">
                                {words.foot.tj}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.bz}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.lxwm}
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
                                {words.foot.Forum}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.ytflt}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.facebook}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.Twitter}
                                </Link>
                            </li>
                        </ul>
                        <ul className="right">
                            <li>
                                <Link to="/play">
                                {words.foot.Reddit}
                                </Link>
                            </li>
                            <li>
                                <Link to="/play">
                                {words.foot.bccmyf}
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
