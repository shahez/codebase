package com.workllama.microservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonCreator;
//import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
//import javax.validation.Valid;
//import javax.validation.constraints.*;

/**
 * SuccessRecord
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-10T11:18:11.603Z[GMT]")
public class SuccessRecord   {
  @JsonProperty("referenceID")
  private String referenceID = null;

  @JsonProperty("UUID")
  private String UUID = null;

  public SuccessRecord referenceID(String referenceID) {
    this.referenceID = referenceID;
    return this;
  }

  /**
   * External system generated reference ID received as part of the request.
   * @return referenceID
  **/
  @ApiModelProperty(value = "External system generated reference ID received as part of the request.")
  
    public String getReferenceID() {
    return referenceID;
  }

  public void setReferenceID(String referenceID) {
    this.referenceID = referenceID;
  }

  public SuccessRecord UUID(String UUID) {
    this.UUID = UUID;
    return this;
  }

  /**
   * WorkLLama generated UUID for the obtained request, this is the ID to be used for future correspondence.
   * @return UUID
  **/
  @ApiModelProperty(value = "WorkLLama generated UUID for the obtained request, this is the ID to be used for future correspondence.")
  
    public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessRecord successRecord = (SuccessRecord) o;
    return Objects.equals(this.referenceID, successRecord.referenceID) &&
        Objects.equals(this.UUID, successRecord.UUID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenceID, UUID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessRecord {\n");
    
    sb.append("    referenceID: ").append(toIndentedString(referenceID)).append("\n");
    sb.append("    UUID: ").append(toIndentedString(UUID)).append("\n");
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
