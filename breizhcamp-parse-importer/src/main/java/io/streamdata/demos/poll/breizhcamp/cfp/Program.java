package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author ctranxuan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Program {
    private List<Day> days;


    @JsonProperty("jours")
    public List<Day> getDays() {
        return days;
    }

    @Override
    public String toString() {
        return "Program{" +
                ", days=" + days +
                '}';
    }
}
