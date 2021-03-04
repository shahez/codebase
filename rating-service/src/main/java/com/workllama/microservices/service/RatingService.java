package com.workllama.microservices.service;

import java.util.List;

import com.workllama.microservices.api.ServiceLayerException;
import com.workllama.microservices.model.CreateRatingRequest;
import com.workllama.microservices.model.Rating;
import com.workllama.microservices.model.SuccessRecord;

/**
 * @author Vivek Shukla
 */
public interface RatingService {

	List<SuccessRecord> createRating(CreateRatingRequest createRatingRequest) throws ServiceLayerException;

	Rating getRating(String uuid) throws ServiceLayerException;

	void updateRating(Rating rating, String uUID) throws ServiceLayerException;

}
