package io.streamdata.demos.poll.breizhcamp;

import io.streamdata.demos.poll.breizhcamp.cfp.BreizhCamp;
import io.streamdata.demos.poll.breizhcamp.cfp.Speaker;
import io.streamdata.demos.poll.breizhcamp.poll.Option;
import io.streamdata.demos.poll.breizhcamp.poll.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@SpringBootApplication
public class BreizhcampParseApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(BreizhcampParseApplication.class);
    public static final String PARSE_QUESTION_API_URL = "https://api.parse.com/1/classes/Question";
    public static final String PARSE_OPTION_API_URL = "https://api.parse.com/1/classes/Option";
    public static final String X_PARSE_APPLICATION_ID_HEADER = "X-Parse-Application-Id";
    public static final String X_PARSE_REST_API_KEY_HEADER = "X-Parse-REST-API-Key";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";

    @Value("${parse.applicationId}")
    private String parseApplicationId;

    @Value("${parse.restApiKey}")
    private String parseRestApiKey;


    private RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        SpringApplication.run(BreizhcampParseApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        createTalkQuestion();
        createSpeakerQuestion();
        System.exit(0);
    }

    private void createSpeakerQuestion() {
        Question question;
        question = postQuestion(new Question("Who is the best speaker?"));

        Speaker[] speakers;
        speakers = restTemplate.getForObject("http://cfp.breizhcamp.org/api/conferences/BreizhCamp2015/speakers",
                Speaker[].class);

        List<Speaker> tenSpeakers;
        tenSpeakers = Arrays.asList(speakers);

        Collections.shuffle(tenSpeakers);

        tenSpeakers
                .stream()
                .limit(10)
                .forEach(s -> {
                    LOGGER.info("creating option {} for question {}", s, question);
                    Option option;
                    option = new Option(s.getFirstName() + " " + s.getLastName(), question);

                    postOption(option);
                });
    }

    private void createTalkQuestion() {
        Question question;
        question = postQuestion(new Question("Which is the best talk?"));

        BreizhCamp breizhCamp;
        breizhCamp = restTemplate.getForObject("http://www.breizhcamp.org/json/schedule.json", BreizhCamp.class);

        breizhCamp.getProgram().getDays().stream()
                .flatMap(d -> d.getProposals().stream())
                .filter(p -> !"break".equals(p.getFormat()))
                .limit(10)
                .forEach(p -> {
                    LOGGER.info("creating option {} for question {}", p, question);
                    Option option;
                    option = new Option(p.getTitle(), question);

                    postOption(option);
                });
    }


    private Question postQuestion(Question aQuestion) {
        checkNotNull(aQuestion, "aQuestion cannot be null");
        return postObject(PARSE_QUESTION_API_URL, aQuestion, Question.class);
    }

    private Option postOption(Option anOption) {
        checkNotNull(anOption, "anOption cannot be null");
        return postObject(PARSE_OPTION_API_URL, anOption, Option.class);
    }

    private <T> T postObject(String aUrl, T aParseClass, Class<T> aClass) {
        checkNotNull(aParseClass, "aQuestion cannot be null");
        checkNotNull(aClass, "aClass cannot be null");
        checkNotNull(aUrl, "aUrl cannot be null");

        HttpHeaders headers;
        headers = new HttpHeaders();
        headers.add(X_PARSE_APPLICATION_ID_HEADER, parseApplicationId);
        headers.add(X_PARSE_REST_API_KEY_HEADER, parseRestApiKey);
        headers.add(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE);


        HttpEntity<?> httpEntity;
        httpEntity = new HttpEntity<>(aParseClass, headers);

        T result;
        result = restTemplate.postForObject(aUrl, httpEntity, aClass);

        return result;
    }


}
