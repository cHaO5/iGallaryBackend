package j2ee.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Forward
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Entity
public class Forward   {
  @Id
  @JsonProperty("Creator")
  private Integer creator = null;

  @JsonProperty("MomentId")
  private Integer momentId = null;

  public Forward creator(Integer creator) {
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

  public Forward momentId(Integer momentId) {
    this.momentId = momentId;
    return this;
  }

  /**
   * Get momentId
   * @return momentId
  **/
  @ApiModelProperty(example = "1144", required = true, value = "")
  @NotNull


  public Integer getMomentId() {
    return momentId;
  }

  public void setMomentId(Integer momentId) {
    this.momentId = momentId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Forward forward = (Forward) o;
    return Objects.equals(this.creator, forward.creator) &&
        Objects.equals(this.momentId, forward.momentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(creator, momentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Forward {\n");
    
    sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
    sb.append("    momentId: ").append(toIndentedString(momentId)).append("\n");
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

