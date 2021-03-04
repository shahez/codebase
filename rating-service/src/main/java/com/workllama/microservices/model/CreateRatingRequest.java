package com.workllama.microservices.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CreateRatingRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-10T11:18:11.603Z[GMT]")
public class CreateRatingRequest   {
  @JsonProperty("EntityID")
  private String entityID = null;

  @JsonProperty("EntityType")
  private EntityType entityType = null;

  @JsonProperty("EntityOwner")
  private String entityOwner = null;

  @JsonProperty("ReviewerID")
  private String reviewerID = null;

  @JsonProperty("ReviewerEntityType")
  private EntityType reviewerEntityType = null;

  @JsonProperty("ReviewerEntityOwner")
  private String reviewerEntityOwner = null;

  @JsonProperty("RatingReferenceID")
  private String ratingReferenceID = null;

  @JsonProperty("Rating")
  private Float rating = null;

  @JsonProperty("Comment")
  private String comment = null;

  @JsonProperty("CreatedDTTM")
  private OffsetDateTime createdDTTM = null;

  @JsonProperty("UpdatedDTTM")
  private OffsetDateTime updatedDTTM = null;

  @JsonProperty("SubRatings")
  @Valid
  private List<SubRating> subRatings = null;

  public CreateRatingRequest entityID(String entityID) {
    this.entityID = entityID;
    return this;
  }

  /**
   * ID of the entity being reviewed e.g. JobPostingID
   * @return entityID
  **/
  @ApiModelProperty(required = true, value = "ID of the entity being reviewed e.g. JobPostingID")
      @NotNull

    public String getEntityID() {
    return entityID;
  }

  public void setEntityID(String entityID) {
    this.entityID = entityID;
  }

  public CreateRatingRequest entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

  /**
   * Get entityType
   * @return entityType
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    @Valid
    public EntityType getEntityType() {
    return entityType;
  }

  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }

  public CreateRatingRequest entityOwner(String entityOwner) {
    this.entityOwner = entityOwner;
    return this;
  }

  /**
   * Could be the company to which entity belongs ..g. CompanyCode to which JobPostingID belong to.
   * @return entityOwner
  **/
  @ApiModelProperty(value = "Could be the company to which entity belongs ..g. CompanyCode to which JobPostingID belong to.")
  
    public String getEntityOwner() {
    return entityOwner;
  }

  public void setEntityOwner(String entityOwner) {
    this.entityOwner = entityOwner;
  }

  public CreateRatingRequest reviewerID(String reviewerID) {
    this.reviewerID = reviewerID;
    return this;
  }

  /**
   * Entity which is reviewing. e.g. CandidateID
   * @return reviewerID
  **/
  @ApiModelProperty(required = true, value = "Entity which is reviewing. e.g. CandidateID")
      @NotNull

    public String getReviewerID() {
    return reviewerID;
  }

  public void setReviewerID(String reviewerID) {
    this.reviewerID = reviewerID;
  }

  public CreateRatingRequest reviewerEntityType(EntityType reviewerEntityType) {
    this.reviewerEntityType = reviewerEntityType;
    return this;
  }

  /**
   * Get reviewerEntityType
   * @return reviewerEntityType
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public EntityType getReviewerEntityType() {
    return reviewerEntityType;
  }

  public void setReviewerEntityType(EntityType reviewerEntityType) {
    this.reviewerEntityType = reviewerEntityType;
  }

  public CreateRatingRequest reviewerEntityOwner(String reviewerEntityOwner) {
    this.reviewerEntityOwner = reviewerEntityOwner;
    return this;
  }

  /**
   * Could be the company to which reviewer belongs. i.e. the candidate company.
   * @return reviewerEntityOwner
  **/
  @ApiModelProperty(value = "Could be the company to which reviewer belongs. i.e. the candidate company.")
  
    public String getReviewerEntityOwner() {
    return reviewerEntityOwner;
  }

  public void setReviewerEntityOwner(String reviewerEntityOwner) {
    this.reviewerEntityOwner = reviewerEntityOwner;
  }

  public CreateRatingRequest ratingReferenceID(String ratingReferenceID) {
    this.ratingReferenceID = ratingReferenceID;
    return this;
  }

  /**
   * External system generated RatingID if applicable.
   * @return ratingReferenceID
  **/
  @ApiModelProperty(value = "External system generated RatingID if applicable.")
  
    public String getRatingReferenceID() {
    return ratingReferenceID;
  }

  public void setRatingReferenceID(String ratingReferenceID) {
    this.ratingReferenceID = ratingReferenceID;
  }

  public CreateRatingRequest rating(Float rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Rating value
   * @return rating
  **/
  @ApiModelProperty(required = true, value = "Rating value")
      @NotNull

    public Float getRating() {
    return rating;
  }

  public void setRating(Float rating) {
    this.rating = rating;
  }

  public CreateRatingRequest comment(String comment) {
    this.comment = comment;
    return this;
  }

  /**
   * Comment associated with the rating.
   * @return comment
  **/
  @ApiModelProperty(value = "Comment associated with the rating.")
  
    public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public CreateRatingRequest createdDTTM(OffsetDateTime createdDTTM) {
    this.createdDTTM = createdDTTM;
    return this;
  }

  /**
   * Date and time on which rating is posted.
   * @return createdDTTM
  **/
  @ApiModelProperty(value = "Date and time on which rating is posted.")
  
    @Valid
    public OffsetDateTime getCreatedDTTM() {
    return createdDTTM;
  }

  public void setCreatedDTTM(OffsetDateTime createdDTTM) {
    this.createdDTTM = createdDTTM;
  }

  public CreateRatingRequest updatedDTTM(OffsetDateTime updatedDTTM) {
    this.updatedDTTM = updatedDTTM;
    return this;
  }

  /**
   * Date and time on which rating is last updated.
   * @return updatedDTTM
  **/
  @ApiModelProperty(value = "Date and time on which rating is last updated.")
  
    @Valid
    public OffsetDateTime getUpdatedDTTM() {
    return updatedDTTM;
  }

  public void setUpdatedDTTM(OffsetDateTime updatedDTTM) {
    this.updatedDTTM = updatedDTTM;
  }

  public CreateRatingRequest subRatings(List<SubRating> subRatings) {
    this.subRatings = subRatings;
    return this;
  }

  public CreateRatingRequest addSubRatingsItem(SubRating subRatingsItem) {
    if (this.subRatings == null) {
      this.subRatings = new ArrayList<SubRating>();
    }
    this.subRatings.add(subRatingsItem);
    return this;
  }

  /**
   * Get subRatings
   * @return subRatings
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<SubRating> getSubRatings() {
    return subRatings;
  }

  public void setSubRatings(List<SubRating> subRatings) {
    this.subRatings = subRatings;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateRatingRequest createRatingRequest = (CreateRatingRequest) o;
    return Objects.equals(this.entityID, createRatingRequest.entityID) &&
        Objects.equals(this.entityType, createRatingRequest.entityType) &&
        Objects.equals(this.entityOwner, createRatingRequest.entityOwner) &&
        Objects.equals(this.reviewerID, createRatingRequest.reviewerID) &&
        Objects.equals(this.reviewerEntityType, createRatingRequest.reviewerEntityType) &&
        Objects.equals(this.reviewerEntityOwner, createRatingRequest.reviewerEntityOwner) &&
        Objects.equals(this.ratingReferenceID, createRatingRequest.ratingReferenceID) &&
        Objects.equals(this.rating, createRatingRequest.rating) &&
        Objects.equals(this.comment, createRatingRequest.comment) &&
        Objects.equals(this.createdDTTM, createRatingRequest.createdDTTM) &&
        Objects.equals(this.updatedDTTM, createRatingRequest.updatedDTTM) &&
        Objects.equals(this.subRatings, createRatingRequest.subRatings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entityID, entityType, entityOwner, reviewerID, reviewerEntityType, reviewerEntityOwner, ratingReferenceID, rating, comment, createdDTTM, updatedDTTM, subRatings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateRatingRequest {\n");
    
    sb.append("    entityID: ").append(toIndentedString(entityID)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    entityOwner: ").append(toIndentedString(entityOwner)).append("\n");
    sb.append("    reviewerID: ").append(toIndentedString(reviewerID)).append("\n");
    sb.append("    reviewerEntityType: ").append(toIndentedString(reviewerEntityType)).append("\n");
    sb.append("    reviewerEntityOwner: ").append(toIndentedString(reviewerEntityOwner)).append("\n");
    sb.append("    ratingReferenceID: ").append(toIndentedString(ratingReferenceID)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
    sb.append("    createdDTTM: ").append(toIndentedString(createdDTTM)).append("\n");
    sb.append("    updatedDTTM: ").append(toIndentedString(updatedDTTM)).append("\n");
    sb.append("    subRatings: ").append(toIndentedString(subRatings)).append("\n");
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
