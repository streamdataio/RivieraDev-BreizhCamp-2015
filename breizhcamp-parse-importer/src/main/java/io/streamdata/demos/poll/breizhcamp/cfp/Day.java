package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author ctranxuan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    private String title;
    private List<Proposal> proposals;

    public String getTitle() {
        return title;
    }

    public List<Proposal> getProposals() {
        return proposals;
    }

    @Override
    public String toString() {
        return "Day{" +
                "title='" + title + '\'' +
                ", proposals=" + proposals +
                '}';
    }
}
