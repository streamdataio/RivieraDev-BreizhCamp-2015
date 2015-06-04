package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by ctranxuan on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Speakers {
    private List<Speaker> speakers;

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "speakers=" + speakers +
                '}';
    }
}
