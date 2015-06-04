package io.streamdata.demos.poll.breizhcamp.poll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ctranxuan on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {

    private String title;
    private String objectId;

    public Question() {
    }

    public Question(String title) {
        this.title = title;
    }

    public String getObjectId() {
        return objectId;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
