This a simple protractor test that simulates user voting for a given question.
This targets the poll-demo (https://github.com/streamdataio/poll-demo) by [streamdata.io](http://streamdata.io).

*Pre-requisites*: 
* a parse account with the data structure defined in the [poll-demo](https://github.com/streamdataio/poll-demo)
* a running instance of poll-demo
* protractor installed

```npm install protractor
./node_modules/protractor/bin/webdriver-manager update```

*Steps*:
* replace the value of the `questionId` with the one of your poll-demo question in the file `spec.js`
* run protractor
 
```./node_modules/protractor/bin/protractor conf.js```


*Note*: protractor is configured to run with Chrome by default.
