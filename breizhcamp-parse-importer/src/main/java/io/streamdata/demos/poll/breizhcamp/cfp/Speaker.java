package io.streamdata.demos.poll.breizhcamp.cfp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by ctranxuan on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Speaker {
    private String lastName;
    private String firstName;
    private String avatarURL;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", avatarURL='" + avatarURL + '\'' +
                '}';
    }
}
