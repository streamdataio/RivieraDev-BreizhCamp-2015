package io.streamdata.demos.poll.breizhcamp.poll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ctranxuan on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vote {
  private String objectId;
  private String questionId;
  private String optionId;

  public String getObjectId() {
    return objectId;
  }

  @JsonProperty("question_id")
  public String getQuestionId() {
    return questionId;
  }

    @JsonProperty("option_id")
  public String getOptionId() {
    return optionId;
  }

  @Override
  public String toString() {
    return "Vote{" +
        "objectId='" + objectId + '\'' +
        ", questionId='" + questionId + '\'' +
        ", optionId='" + optionId + '\'' +
        '}';
  }
}
