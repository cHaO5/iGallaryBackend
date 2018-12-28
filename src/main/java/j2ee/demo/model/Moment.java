package j2ee.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Moment
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Entity
public class Moment   {
  @Id
  @GeneratedValue
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("Creator")
  private Integer creator = null;

  @JsonProperty("Content")
  private String content = null;

  @JsonProperty("LikeNum")
  private Integer likeNum = null;

  @JsonProperty("ForwardNum")
  private Integer forwardNum = null;

  @JsonProperty("FavouriteNum")
  private Integer favouriteNum = null;

  @JsonProperty("CommentNum")
  private Integer commentNum = null;

  @JsonProperty("Time")
  private String time = null;

  @JsonProperty("Tag")
  private String tags = null;

  public Moment id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1111", value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Moment creator(Integer creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Get creator
   * @return creator
  **/
  @ApiModelProperty(example = "2312", required = true, value = "")
  @NotNull


  public Integer getCreator() {
    return creator;
  }

  public void setCreator(Integer creator) {
    this.creator = creator;
  }

  public Moment content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(example = "Hello world", required = true, value = "")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Moment likeNum(Integer likeNum) {
    this.likeNum = likeNum;
    return this;
  }

  /**
   * Get likeNum
   * @return likeNum
  **/
  @ApiModelProperty(example = "12", value = "")


  public Integer getLikeNum() {
    return likeNum;
  }

  public void setLikeNum(Integer likeNum) {
    this.likeNum = likeNum;
  }

  public Moment forwardNum(Integer forwardNum) {
    this.forwardNum = forwardNum;
    return this;
  }

  /**
   * Get forwardNum
   * @return forwardNum
  **/
  @ApiModelProperty(example = "6", value = "")


  public Integer getForwardNum() {
    return forwardNum;
  }

  public void setForwardNum(Integer forwardNum) {
    this.forwardNum = forwardNum;
  }

  public Moment favouriteNum(Integer favouriteNum) {
    this.favouriteNum = favouriteNum;
    return this;
  }

  /**
   * Get favouriteNum
   * @return favouriteNum
  **/
  @ApiModelProperty(example = "8", value = "")


  public Integer getFavouriteNum() {
    return favouriteNum;
  }

  public void setFavouriteNum(Integer favouriteNum) {
    this.favouriteNum = favouriteNum;
  }

  public Moment commentNum(Integer commentNum) {
    this.commentNum = commentNum;
    return this;
  }

  /**
   * Get commentNum
   * @return commentNum
  **/
  @ApiModelProperty(example = "2", value = "")


  public Integer getCommentNum() {
    return commentNum;
  }

  public void setCommentNum(Integer commentNum) {
    this.commentNum = commentNum;
  }

  public Moment time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(example = "1985-04-12T23:20:50.52Z", value = "")


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Moment moment = (Moment) o;
    return Objects.equals(this.id, moment.id) &&
        Objects.equals(this.creator, moment.creator) &&
        Objects.equals(this.content, moment.content) &&
        Objects.equals(this.likeNum, moment.likeNum) &&
        Objects.equals(this.forwardNum, moment.forwardNum) &&
        Objects.equals(this.favouriteNum, moment.favouriteNum) &&
        Objects.equals(this.commentNum, moment.commentNum) &&
        Objects.equals(this.time, moment.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creator, content, likeNum, forwardNum, favouriteNum, commentNum, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Moment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    likeNum: ").append(toIndentedString(likeNum)).append("\n");
    sb.append("    forwardNum: ").append(toIndentedString(forwardNum)).append("\n");
    sb.append("    favouriteNum: ").append(toIndentedString(favouriteNum)).append("\n");
    sb.append("    commentNum: ").append(toIndentedString(commentNum)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

