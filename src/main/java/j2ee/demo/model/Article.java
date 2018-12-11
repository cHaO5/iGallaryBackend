package j2ee.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Article
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

public class Article   {
  @JsonProperty("Id")
  private Integer id = null;

  @JsonProperty("Title")
  private String title = null;

  @JsonProperty("Content")
  private String content = null;

  @JsonProperty("Creator")
  private Integer creator = null;

  @JsonProperty("LikeNum")
  private Integer likeNum = null;

  @JsonProperty("ForwardNum")
  private Integer forwardNum = null;

  @JsonProperty("FavoriteNum")
  private Integer favoriteNum = null;

  @JsonProperty("CommentNum")
  private Integer commentNum = null;

  @JsonProperty("Time")
  private String time = null;

  public Article id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "2312", value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Article title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
  **/
  @ApiModelProperty(example = "One more thing", required = true, value = "")
  @NotNull


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Article content(String content) {
    this.content = content;
    return this;
  }

  /**
   * Get content
   * @return content
  **/
  @ApiModelProperty(example = "Nothing", required = true, value = "")
  @NotNull


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Article creator(Integer creator) {
    this.creator = creator;
    return this;
  }

  /**
   * Get creator
   * @return creator
  **/
  @ApiModelProperty(example = "2344", required = true, value = "")
  @NotNull


  public Integer getCreator() {
    return creator;
  }

  public void setCreator(Integer creator) {
    this.creator = creator;
  }

  public Article likeNum(Integer likeNum) {
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

  public Article forwardNum(Integer forwardNum) {
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

  public Article favoriteNum(Integer favoriteNum) {
    this.favoriteNum = favoriteNum;
    return this;
  }

  /**
   * Get favoriteNum
   * @return favoriteNum
  **/
  @ApiModelProperty(example = "8", value = "")


  public Integer getFavoriteNum() {
    return favoriteNum;
  }

  public void setFavoriteNum(Integer favoriteNum) {
    this.favoriteNum = favoriteNum;
  }

  public Article commentNum(Integer commentNum) {
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

  public Article time(String time) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(this.id, article.id) &&
        Objects.equals(this.title, article.title) &&
        Objects.equals(this.content, article.content) &&
        Objects.equals(this.creator, article.creator) &&
        Objects.equals(this.likeNum, article.likeNum) &&
        Objects.equals(this.forwardNum, article.forwardNum) &&
        Objects.equals(this.favoriteNum, article.favoriteNum) &&
        Objects.equals(this.commentNum, article.commentNum) &&
        Objects.equals(this.time, article.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, creator, likeNum, forwardNum, favoriteNum, commentNum, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Article {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    likeNum: ").append(toIndentedString(likeNum)).append("\n");
    sb.append("    forwardNum: ").append(toIndentedString(forwardNum)).append("\n");
    sb.append("    favoriteNum: ").append(toIndentedString(favoriteNum)).append("\n");
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

