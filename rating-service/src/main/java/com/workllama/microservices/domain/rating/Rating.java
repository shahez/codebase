package com.workllama.microservices.domain.rating;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Vivek Shukla
 */

@Entity(name = "Rating")
@Table(name = "Rating")
@Configurable

public class Rating extends AbstractRating {

}
