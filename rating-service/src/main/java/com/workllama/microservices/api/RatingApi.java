package com.workllama.microservices.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workllama.microservices.model.CreateRatingRequest;
import com.workllama.microservices.model.CreateResponse;
import com.workllama.microservices.model.Error;
import com.workllama.microservices.model.Rating;
import com.workllama.microservices.model.SuccessRecord;
import com.workllama.microservices.service.RatingService;
import com.workllama.microservices.service.RatingServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-10T11:18:11.603Z[GMT]")
@Api(value = "rating", description = "The rating API")
@RestController
@RequestMapping("/api/v1")
public class RatingApi {

	private static Log logger = LogFactory.getLog(RatingServiceImpl.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	RatingService ratingService;

	@org.springframework.beans.factory.annotation.Autowired
	public RatingApi(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	/**
	 * Method createRating will call RatingServiceImpl.createRating method to merge
	 * the data into Rating table.
	 * 
	 * @author Vivek Shukla
	 * @param CreateRatingRequest
	 * @return ResponseEntity<CreateResponse>
	 */
	@ApiOperation(value = "Post a new rating", nickname = "createRating", notes = "", response = CreateResponse.class, tags = {
			"RatingAPI", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created. Response contains the WorkLLama generated UUID for the given Rating.", response = CreateResponse.class),
			@ApiResponse(code = 400, message = "Bad request; request contains invalid data", response = Error.class),
			@ApiResponse(code = 401, message = "Access token is missing or invalid"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@RequestMapping(value = "/rating", produces = { "*/*", "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<CreateResponse> createRating(
			@ApiParam(value = "Rating details ", required = true) @Valid @RequestBody CreateRatingRequest createRatingRequest) {
		logger.info("Entered RatingApi.createRating method...");
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			CreateResponse response = new CreateResponse();
			try {
				List<SuccessRecord> successRecordList = ratingService.createRating(createRatingRequest);
				response.setData(successRecordList);
				response.setDescription("Rating record created successfully");
				response.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<CreateResponse>(response, HttpStatus.OK);
			} catch (ServiceLayerException e) {
				logger.error("Exception in RatingApi.createRating method " + e);
				List<com.workllama.microservices.api.Error> ilist = e.getListErrors();
				response.setDescription(ilist.get(0).getDescription());
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return new ResponseEntity<CreateResponse>(response, HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				logger.error("Exception in RatingApi.createRating method " + e);
				response.setDescription(e.getMessage());
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return new ResponseEntity<CreateResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<CreateResponse>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Method getRating will call RatingServiceImpl.getRating method to fetch the
	 * data from Rating table.
	 * 
	 * @author Vivek Shukla
	 * @param UUID
	 * @return ResponseEntity<Rating>
	 */
	@ApiOperation(value = "Get rating details", nickname = "getRating", notes = "", response = Rating.class, tags = {
			"RatingAPI", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully created. Response contains the WorkLLama generated UUID for the given Rating.", response = Rating.class),
			@ApiResponse(code = 400, message = "Bad request; request contains invalid data", response = Error.class),
			@ApiResponse(code = 401, message = "Access token is missing or invalid"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@RequestMapping(value = "/rating/{UUID}", produces = { "*/*", "application/json" }, method = RequestMethod.GET)
	public ResponseEntity<Rating> getRating(
			@ApiParam(value = "UUID of the rating to return", required = true) @PathVariable("UUID") String UUID) {
		logger.info("Entered RatingApi.getRating method with UUID: " + UUID);
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				Rating rating = ratingService.getRating(UUID);
				return new ResponseEntity<Rating>(rating, HttpStatus.OK);
			} catch (ServiceLayerException e) {
				logger.error("Exception in RatingApi.updateRating method " + e);
				return new ResponseEntity<Rating>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				logger.error("Exception in RatingApi.getRating method " + e);
				return new ResponseEntity<Rating>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Rating>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Method updateRating will call RatingApi.updateRating method to update data of
	 * existing single matched record.
	 * 
	 * @author Vivek Shukla
	 * @param Rating,
	 *            UUID
	 * @return ResponseEntity<Void>
	 */
	@ApiOperation(value = "Update rating details", nickname = "updateRating", notes = "", tags = { "RatingAPI", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated."),
			@ApiResponse(code = 400, message = "Bad request; request contains invalid data", response = Error.class),
			@ApiResponse(code = 401, message = "Access token is missing or invalid"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@RequestMapping(value = "/rating/{UUID}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PUT)
	public ResponseEntity<Void> updateRating(
			@ApiParam(value = "Rating details, Only Rating and SubRatings could be modified", required = true) @Valid @RequestBody Rating rating,
			@ApiParam(value = "UUID of the rating to return", required = true) @PathVariable("UUID") String UUID) {
		logger.info("Entered RatingApi.updateRating method with UUID: " + UUID);
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			try {
				ratingService.updateRating(rating, UUID);
				return new ResponseEntity<Void>(HttpStatus.OK);
			} catch (ServiceLayerException e) {
				logger.error("Exception in RatingApi.updateRating method " + e);
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			} catch (Exception e) {
				logger.error("Exception in RatingApi.updateRating method " + e);
				return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
