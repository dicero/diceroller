/* config-overrides.js */
const { injectBabelPlugin } = require('react-app-rewired');
const rewireLess = require('react-app-rewire-less');
const rewireMobX = require('react-app-rewire-mobx');
module.exports = function override(config, env) {
    //do stuff with the webpack config...
    config = injectBabelPlugin(['import', { libraryName: 'antd', style: true }], config)
    config = rewireLess(config, env, {
        modifyVars: { "@primary-color": "#1DA57A" },
    });
    config = rewireMobX(config, env);
    return config;
  }