package com.workllama.microservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.workllama.microservices.model.SuccessRecord;
//import com.fasterxml.jackson.annotation.JsonCreator;
//import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
//import javax.validation.constraints.*;

/**
 * CreateResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-10T11:18:11.603Z[GMT]")
public class CreateResponse   {
  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("data")
  @Valid
  private List<SuccessRecord> data = null;

  public CreateResponse status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Status
   * @return status
  **/
  @ApiModelProperty(value = "Status")
  
    public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public CreateResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * status description message
   * @return description
  **/
  @ApiModelProperty(value = "status description message")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public CreateResponse data(List<SuccessRecord> data) {
    this.data = data;
    return this;
  }

  public CreateResponse addDataItem(SuccessRecord dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<SuccessRecord>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Data that holds ReferenceId along with the generated identifers during create.
   * @return data
  **/
  @ApiModelProperty(value = "Data that holds ReferenceId along with the generated identifers during create.")
      @Valid
    public List<SuccessRecord> getData() {
    return data;
  }

  public void setData(List<SuccessRecord> data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateResponse createResponse = (CreateResponse) o;
    return Objects.equals(this.status, createResponse.status) &&
        Objects.equals(this.description, createResponse.description) &&
        Objects.equals(this.data, createResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, description, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateResponse {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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
