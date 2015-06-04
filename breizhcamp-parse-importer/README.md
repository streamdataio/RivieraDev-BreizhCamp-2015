This is a simple SpringBoot project that feeds [Parse] (https://www.parse.com/) with BreizhCamp data according to the 
structure define by the [streamdata.io](http://streamdata.io) poll-demo (https://github.com/streamdataio/poll-demo).

*Pre-requisites*: a parse account with the data structure defined in the [poll-demo](https://github.com/streamdataio/poll-demo).

*Steps*:
* fill in the `src/main/resources/application.properties` with your Parse keys
* start the main java defined in `BreizhcampParseApplication`
 
Your parse backend should have been filled in with a question about BreizhCamp talks and one about speakers. 


