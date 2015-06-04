package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ctranxuan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BreizhCamp {
    private String title;
    private Program program;

    public String getTitle() {
        return title;
    }

    @JsonProperty("programme")
    public Program getProgram() {
        return program;
    }

    @Override
    public String toString() {
        return "BreizhCamp{" +
                "title='" + title + '\'' +
                ", program=" + program +
                '}';
    }
}
