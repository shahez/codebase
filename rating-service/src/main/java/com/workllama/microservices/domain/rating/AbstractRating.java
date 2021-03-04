package com.workllama.microservices.domain.rating;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Vivek Shukla
 */
@MappedSuperclass
public abstract class AbstractRating {

	@Id
	@Column(name = "RatingUUID")
	private String ratingUUID;

	@Column(name = "ReferenceId")
	private String referenceId;

	@Column(name = "EntityId")
	private String entityId;

	@Column(name = "EntityType")
	private String entityType;

	@Column(name = "EntityOwner")
	private String entityOwner;

	@Column(name = "ReviewerId")
	private String reviewerId;

	@Column(name = "ReviewerEntityType")
	private String reviewerEntityType;

	@Column(name = "ReviewerEntityOwner")
	private String reviewerEntityOwner;

	@Column(name = "Rating")
	private Float rating;

	@Column(name = "Comment")
	private String comment;

	@Column(name = "CreatedDTTM")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	private Date createdDTTM;

	@Column(name = "UpdatedDTTM")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	private Date updatedDTTM;

	public String getRatingUUID() {
		return ratingUUID;
	}

	public void setRatingUUID(String ratingUUID) {
		this.ratingUUID = ratingUUID;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public String getEntityOwner() {
		return entityOwner;
	}

	public void setEntityOwner(String entityOwner) {
		this.entityOwner = entityOwner;
	}

	public String getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(String reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getReviewerEntityType() {
		return reviewerEntityType;
	}

	public void setReviewerEntityType(String reviewerEntityType) {
		this.reviewerEntityType = reviewerEntityType;
	}

	public String getReviewerEntityOwner() {
		return reviewerEntityOwner;
	}

	public void setReviewerEntityOwner(String reviewerEntityOwner) {
		this.reviewerEntityOwner = reviewerEntityOwner;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedDTTM() {
		return createdDTTM;
	}

	public void setCreatedDTTM(Date createdDTTM) {
		this.createdDTTM = createdDTTM;
	}

	public Date getUpdatedDTTM() {
		return updatedDTTM;
	}

	public void setUpdatedDTTM(Date updatedDTTM) {
		this.updatedDTTM = updatedDTTM;
	}

}
