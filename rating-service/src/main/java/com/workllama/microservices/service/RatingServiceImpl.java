package com.workllama.microservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workllama.microservices.api.ServiceLayerException;
import com.workllama.microservices.domain.rating.Rating;
import com.workllama.microservices.model.CreateRatingRequest;
import com.workllama.microservices.model.EntityType;
import com.workllama.microservices.model.ErrorCode;
import com.workllama.microservices.model.SuccessRecord;
import com.workllama.microservices.repository.RatingRepository;
import com.workllama.microservices.api.Error;

/**
 * @author Vivek Shukla
 */

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Autowired
	EntityManager entityManager;

	private static Log logger = LogFactory.getLog(RatingServiceImpl.class);
	private final String PREFIX = "RTG";

	/**
	 * Method createRating will merge the data into Rating table.
	 * 
	 * @author Vivek Shukla
	 * @param CreateRatingRequest
	 * @return CreateResponse
	 * @throws ServiceLayerException
	 */
	@Override
	@Transactional(rollbackFor = ServiceLayerException.class)
	public List<SuccessRecord> createRating(CreateRatingRequest createRatingRequest) throws ServiceLayerException {
		logger.info("Entered into RatingServiceImpl.createRating method with RatingReferenceID: "
				+ createRatingRequest.getRatingReferenceID());
		String uuid = null;
		Rating rating = new Rating();
		StringBuilder ratingUUID = null;
		try {
			uuid = UUID.randomUUID().toString();
			ratingUUID = new StringBuilder();
			ratingUUID.append(PREFIX);
			ratingUUID.append("-");
			ratingUUID.append(uuid);
			rating.setRatingUUID(ratingUUID.toString());
			rating.setReferenceId(createRatingRequest.getRatingReferenceID());
			rating.setEntityId(createRatingRequest.getEntityID());
			rating.setEntityType(EntityType.valueOf(createRatingRequest.getEntityType().name()).name());
			rating.setEntityOwner(createRatingRequest.getEntityOwner());
			rating.setReviewerId(createRatingRequest.getReviewerID());
			rating.setReviewerEntityOwner(createRatingRequest.getReviewerEntityOwner());
			rating.setReviewerEntityType(EntityType.valueOf(createRatingRequest.getReviewerEntityType().name()).name());
			rating.setRating(createRatingRequest.getRating());
			rating.setComment(createRatingRequest.getComment());
			rating.setCreatedDTTM(new Date());
			entityManager.persist(rating);
			entityManager.flush();
			SuccessRecord successRecord = new SuccessRecord();
			List<SuccessRecord> successRecordList = new ArrayList<>();
			successRecord.setUUID(ratingUUID.toString());
			successRecord.setReferenceID(createRatingRequest.getRatingReferenceID());
			successRecordList.add(successRecord);
			logger.info("Successfully created Rating record with UUID: " + ratingUUID.toString());
			return successRecordList;
		} catch (PersistenceException ex) {
			logger.error("Exception in RatingServiceImpl.createRating method " + ex);
			throw new ServiceLayerException(ex.getMessage())
					.withError(new Error(ErrorCode.BAD_REQUEST, ex.getMessage()));
		} catch (Exception e) {
			logger.error("Exception in RatingServiceImpl.createRating method " + e);
			throw new ServiceLayerException(e.getMessage())
					.withError(new Error(ErrorCode.OTHER_FAILURE, e.getMessage()));
		}
	}

	/**
	 * Method getRating will fetch the data from Rating table.
	 * 
	 * @author Vivek Shukla
	 * @param uuid
	 * @return com.workllama.microservices.model.Rating
	 */
	@Override
	public com.workllama.microservices.model.Rating getRating(String uuid) throws ServiceLayerException {
		logger.info("Entered into RatingServiceImpl.getRating method with UUID: " + uuid);
		com.workllama.microservices.model.Rating ratingModel = new com.workllama.microservices.model.Rating();

		Optional<Rating> rating = Optional.ofNullable(ratingRepository.findByRatingUUID(uuid));
		if (rating.isPresent()) {
			ratingModel.setUUID(rating.get().getRatingUUID());
			ratingModel.setEntityID(rating.get().getEntityId());
			ratingModel.setEntityOwner(rating.get().getEntityOwner());
			ratingModel.setEntityType(EntityType.valueOf(rating.get().getEntityType()));
			ratingModel.setReviewerID(rating.get().getReviewerId());
			ratingModel.setReviewerEntityOwner(rating.get().getReviewerEntityOwner());
			ratingModel.setReviewerEntityType(EntityType.valueOf(rating.get().getEntityType()));
			ratingModel.setReferenceID(rating.get().getReferenceId());
			ratingModel.setRating(rating.get().getRating());
			ratingModel.setComment(rating.get().getComment());
			ratingModel.setCreatedDTTM(rating.get().getCreatedDTTM());
			ratingModel.setUpdatedDTTM(rating.get().getUpdatedDTTM());
		} else {
			logger.error("No record found for uuid: " + uuid + " in Rating table.");
			throw new ServiceLayerException().withError(
					new Error(ErrorCode.NO_RECORD, "No record found for uuid: " + uuid + " in Rating table."));
		}
		return ratingModel;
	}

	/**
	 * RatingServiceImpl.updateRating will update the data of existing single
	 * matched record.
	 * 
	 * @author Vivek Shukla
	 * @param Rating,
	 *            UUID
	 * @return void
	 */
	@Override
	@Transactional(rollbackFor = ServiceLayerException.class)
	public void updateRating(com.workllama.microservices.model.Rating ratingBody, String uuid)
			throws ServiceLayerException {
		logger.info("Entered into RatingServiceImpl.updateRating method with UUID: " + uuid);
		try {
			Optional<Rating> rating = Optional.ofNullable(ratingRepository.findByRatingUUID(uuid));
			if (rating.isPresent()) {
				rating.get().setReferenceId(ratingBody.getReferenceID());
				rating.get().setEntityId(ratingBody.getEntityID());
				rating.get().setEntityType(EntityType.valueOf(ratingBody.getEntityType().name()).name());
				rating.get().setEntityOwner(ratingBody.getEntityOwner());
				rating.get().setReviewerId(ratingBody.getReviewerID());
				rating.get().setReviewerEntityOwner(ratingBody.getReviewerEntityOwner());
				rating.get()
						.setReviewerEntityType(EntityType.valueOf(ratingBody.getReviewerEntityType().name()).name());
				rating.get().setRating(ratingBody.getRating());
				rating.get().setComment(ratingBody.getComment());
				rating.get().setUpdatedDTTM(new Date());
				entityManager.merge(rating.get());
				entityManager.flush();
			} else {
				logger.error("No record found for uuid: " + uuid + " in Rating table.");
			}
		} catch (PersistenceException ex) {
			logger.error("Exception in RatingServiceImpl.updateRating method " + ex);
			throw new ServiceLayerException(ex.getMessage())
					.withError(new Error(ErrorCode.BAD_REQUEST, ex.getMessage()));
		} catch (Exception e) {
			logger.error("Exception in RatingServiceImpl.updateRating method " + e);
			throw new ServiceLayerException(e.getMessage())
					.withError(new Error(ErrorCode.OTHER_FAILURE, e.getMessage()));
		}
	}

}
