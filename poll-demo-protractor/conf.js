// conf.js

// An example configuration file.
exports.config = {
  directConnect: true,

  // Capabilities to be passed to the webdriver instance.
  capabilities: {
    'browserName': 'chrome'
  },

  chromeDriver: './node_modules/protractor/selenium/chromedriver',

  // Framework to use. Jasmine 2 is recommended.
  framework: 'jasmine2',

  // Options to be passed to Jasmine.
  jasmineNodeOpts: {
    defaultTimeoutInterval: 36000000
  },

  seleniumAddress: 'http://localhost:4444/wd/hub',
  specs: ['spec.js']
};


