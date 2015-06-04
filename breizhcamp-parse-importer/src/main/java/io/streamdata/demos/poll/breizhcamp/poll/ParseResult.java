package io.streamdata.demos.poll.breizhcamp.poll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ctranxuan on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParseResult<T> {

    private List<T> results;

    public ParseResult() {
    }

    public ParseResult(Class<T> aClass) {
    }

    public List<T> getResults() {
        return results;
    }

    public static class QuestionResult extends ParseResult<Question> {
    }
}
