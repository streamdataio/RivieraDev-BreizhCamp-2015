// spec.js
describe('Protractor Poll Demo App', function() {
  var totalVotes = 30;
  var repeatSameVotesMin = 5;
  var sleepBetweenVotes = 1000;
  var questionId = 'ie1gHWLX7Y';

  it('should vote', function() {
    browser.get('http://localhost:8080/#/poll/' + questionId)
      .then(function () {
        browser.sleep(5000);

        var allOptions = element.all(by.tagName('label'));

        allOptions.count().then(function(optionsCount) {
          var i = 0;

          while (i < (totalVotes / repeatSameVotesMin)) {
            var index = Math.floor((Math.random() * optionsCount));

            for (var j = 0; j < Math.max(repeatSameVotesMin, Math.floor((Math.random() * 10))); j++) {
              var optionSelected = allOptions.get(index);
              optionSelected.click();

              element(by.css('input[type="submit"]')).click();
              browser.sleep(sleepBetweenVotes);
            }

            i= i + 1;
          }
        });

        expect(browser.getTitle()).toEqual('Poll - Voting done simply in real-times');
      });

  });
});
