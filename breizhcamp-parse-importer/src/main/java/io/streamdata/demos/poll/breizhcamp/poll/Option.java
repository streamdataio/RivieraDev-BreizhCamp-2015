package io.streamdata.demos.poll.breizhcamp.poll;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by ctranxuan on 04/06/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Option {
  private String objectId;
  private String title;
  private String questionId;

  public  Option() {

  }

  public Option(String aTitle, Question aQuestion) {
    title = aTitle;
    questionId = aQuestion.getObjectId();
  }

  @JsonProperty("question_id")
  public String getQuestionId() {
    return questionId;
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
    return "Option{" +
        "objectId='" + objectId + '\'' +
        ", title='" + title + '\'' +
        ", questionId='" + questionId + '\'' +
        '}';
  }
}
