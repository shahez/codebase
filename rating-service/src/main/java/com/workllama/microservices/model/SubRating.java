package com.workllama.microservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * SubRating
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-10T11:18:11.603Z[GMT]")
public class SubRating   {
  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    QUESTION("question"),
    
    CHOICE("choice"),
    
    RATING("rating");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("Type")
  private TypeEnum type = null;

  @JsonProperty("ReferenceID")
  private String referenceID = null;

  @JsonProperty("Description")
  private String description = null;

  @JsonProperty("ValueText")
  private String valueText = null;

  @JsonProperty("ValueNumber")
  private Float valueNumber = null;

  public SubRating type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")
  
    public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public SubRating referenceID(String referenceID) {
    this.referenceID = referenceID;
    return this;
  }

  /**
   * external system generated reference ID for the subrating.
   * @return referenceID
  **/
  @ApiModelProperty(value = "external system generated reference ID for the subrating.")
  
    public String getReferenceID() {
    return referenceID;
  }

  public void setReferenceID(String referenceID) {
    this.referenceID = referenceID;
  }

  public SubRating description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Title associated with the subrating.
   * @return description
  **/
  @ApiModelProperty(value = "Title associated with the subrating.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public SubRating valueText(String valueText) {
    this.valueText = valueText;
    return this;
  }

  /**
   * Text value associated with the sub rating.
   * @return valueText
  **/
  @ApiModelProperty(value = "Text value associated with the sub rating.")
  
    public String getValueText() {
    return valueText;
  }

  public void setValueText(String valueText) {
    this.valueText = valueText;
  }

  public SubRating valueNumber(Float valueNumber) {
    this.valueNumber = valueNumber;
    return this;
  }

  /**
   * Numeric value associated with the sub rating.
   * @return valueNumber
  **/
  @ApiModelProperty(value = "Numeric value associated with the sub rating.")
  
    public Float getValueNumber() {
    return valueNumber;
  }

  public void setValueNumber(Float valueNumber) {
    this.valueNumber = valueNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubRating subRating = (SubRating) o;
    return Objects.equals(this.type, subRating.type) &&
        Objects.equals(this.referenceID, subRating.referenceID) &&
        Objects.equals(this.description, subRating.description) &&
        Objects.equals(this.valueText, subRating.valueText) &&
        Objects.equals(this.valueNumber, subRating.valueNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, referenceID, description, valueText, valueNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubRating {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referenceID: ").append(toIndentedString(referenceID)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    valueText: ").append(toIndentedString(valueText)).append("\n");
    sb.append("    valueNumber: ").append(toIndentedString(valueNumber)).append("\n");
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
