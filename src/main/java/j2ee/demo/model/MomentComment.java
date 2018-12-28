package j2ee.demo.model;

import java.sql.Date;
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
 * MomentCommentMapper
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Entity
public class MomentComment   {
  @Id
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("MomentId")
  private Integer momentId = null;

  @JsonProperty("SenderId")
  private Integer senderId = null;

  @JsonProperty("Content")
  private String content = null;

  @JsonProperty("QuoteId")
  private Integer quoteId = null;

  @JsonProperty("CreateTime")
  private Date createTime = null;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public MomentComment momentId(Integer momentId) {
    this.momentId = momentId;
    return this;
  }

  /**
   * Get momentId
   * @return momentId
  **/
  @ApiModelProperty(example = "3123", required = true, value = "")
  @NotNull


  public Integer getMomentId() {
    return momentId;
  }

  public void setMomentId(Integer momentId) {
    this.momentId = momentId;
  }

  public MomentComment senderId(Integer senderId) {
    this.senderId = senderId;
    return this;
  }

  /**
   * Get senderId
   * @return senderId
  **/
  @ApiModelProperty(example = "3123", required = true, value = "")
  @NotNull


  public Integer getSenderId() {
    return senderId;
  }

  public void setSenderId(Integer senderId) {
    this.senderId = senderId;
  }

  public MomentComment content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(example = "好棒呀", required = true, value = "")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public MomentComment quoteId(Integer quoteId) {
    this.quoteId = quoteId;
    return this;
  }

  /**
   * 回复的 comment 的 Id
   * @return quoteId
  **/
  @ApiModelProperty(example = "32", value = "回复的 comment 的 Id")


  public Integer getQuoteId() {
    return quoteId;
  }

  public void setQuoteId(Integer quoteId) {
    this.quoteId = quoteId;
  }

  public MomentComment createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

  /**
   * Get createTime
   * @return createTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MomentComment momentComment = (MomentComment) o;
    return Objects.equals(this.momentId, momentComment.momentId) &&
        Objects.equals(this.senderId, momentComment.senderId) &&
        Objects.equals(this.content, momentComment.content) &&
        Objects.equals(this.quoteId, momentComment.quoteId) &&
        Objects.equals(this.createTime, momentComment.createTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(momentId, senderId, content, quoteId, createTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MomentCommentMapper {\n");
    
    sb.append("    momentId: ").append(toIndentedString(momentId)).append("\n");
    sb.append("    senderId: ").append(toIndentedString(senderId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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

