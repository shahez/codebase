package com.workllama.microservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.workllama.microservices.model.ErrorRecord;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Error
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-10T11:18:11.603Z[GMT]")
public class Error   {
  @JsonProperty("errors")
  @Valid
  private List<ErrorRecord> errors = null;

  public Error errors(List<ErrorRecord> errors) {
    this.errors = errors;
    return this;
  }

  public Error addErrorsItem(ErrorRecord errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<ErrorRecord>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * List of errors occured while performing the operation
   * @return errors
  **/
  @ApiModelProperty(value = "List of errors occured while performing the operation")
      @Valid
    public List<ErrorRecord> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorRecord> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.errors, error.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
