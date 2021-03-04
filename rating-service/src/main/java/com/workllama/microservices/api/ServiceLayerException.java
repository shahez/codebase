/**
 * 
 */
package com.workllama.microservices.api;

import java.util.LinkedList;
import java.util.List;
import com.workllama.microservices.api.Error;

/**
 * @author Vivek Shukla
 *
 */
public class ServiceLayerException extends Exception {

	/**
	 * 
	 */
	List<Error> listErrors;

	public ServiceLayerException(String msg) {
		super(msg);
	}

	public ServiceLayerException() {
	}

	public ServiceLayerException withError(Error error) {
		if (listErrors == null) {
			listErrors = new LinkedList<>();
		}
		listErrors.add(error);
		return this;
	}

	public List<Error> getListErrors() {
		return listErrors;
	}

}
