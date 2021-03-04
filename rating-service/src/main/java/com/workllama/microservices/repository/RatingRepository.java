package com.workllama.microservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.workllama.microservices.domain.rating.Rating;

/**
 * @author Vivek Shukla
 */

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {

	Rating findByRatingUUID(String UUID);

}
