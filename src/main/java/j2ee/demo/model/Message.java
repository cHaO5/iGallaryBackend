package j2ee.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Message
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Entity
public class Message   {
  @Id
  @JsonProperty("SenderId")
  private Integer senderId = null;

  @JsonProperty("ReceiverId")
  private Integer receiverId = null;

  @JsonProperty("CreateTime")
  private OffsetDateTime createTime = null;

  @JsonProperty("Content")
  private String content = null;

  public Message senderId(Integer senderId) {
    this.senderId = senderId;
    return this;
  }

  /**
   * Get senderId
   * @return senderId
  **/
  @ApiModelProperty(example = "123213", required = true, value = "")
  @NotNull


  public Integer getSenderId() {
    return senderId;
  }

  public void setSenderId(Integer senderId) {
    this.senderId = senderId;
  }

  public Message receiverId(Integer receiverId) {
    this.receiverId = receiverId;
    return this;
  }

  /**
   * Get receiverId
   * @return receiverId
  **/
  @ApiModelProperty(example = "123213", required = true, value = "")
  @NotNull


  public Integer getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(Integer receiverId) {
    this.receiverId = receiverId;
  }

  public Message createTime(OffsetDateTime createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * Get createTime
   * @return createTime
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getCreateTime() {
    return createTime;
  }

  public void setCreateTime(OffsetDateTime createTime) {
    this.createTime = createTime;
  }

  public Message content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(example = "太棒惹", required = true, value = "")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Message message = (Message) o;
    return Objects.equals(this.senderId, message.senderId) &&
        Objects.equals(this.receiverId, message.receiverId) &&
        Objects.equals(this.createTime, message.createTime) &&
        Objects.equals(this.content, message.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(senderId, receiverId, createTime, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Message {\n");
    
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    receiverId: ").append(toIndentedString(receiverId)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

