package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ctranxuan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
    private Program program;

    @JsonProperty("programme")
    public Program getProgram() {
        return program;
    }
}
