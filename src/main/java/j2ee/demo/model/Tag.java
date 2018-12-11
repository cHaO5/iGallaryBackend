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
 * Tag
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-12-10T17:01:42.314Z[GMT]")

@Entity
public class Tag   {
  @Id
  @JsonProperty("Tagname")
  private String tagname = null;

  public Tag tagname(String tagname) {
    this.tagname = tagname;
    return this;
  }

  /**
   * Get tagname
   * @return tagname
  **/
  @ApiModelProperty(example = "galgame", required = true, value = "")
  @NotNull


  public String getTagname() {
    return tagname;
  }

  public void setTagname(String tagname) {
    this.tagname = tagname;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tag tag = (Tag) o;
    return Objects.equals(this.tagname, tag.tagname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tagname);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tag {\n");
    
    sb.append("    tagname: ").append(toIndentedString(tagname)).append("\n");
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

