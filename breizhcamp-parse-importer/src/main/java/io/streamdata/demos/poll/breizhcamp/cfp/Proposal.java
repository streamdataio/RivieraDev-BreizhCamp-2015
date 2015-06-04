package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ctranxuan
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proposal {
    private String id;
    private String title;
    private String format;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "Proposal{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
