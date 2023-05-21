package com.learn.interview.apis.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.client.http.HttpMethods;
import com.learn.interview.apis.RetailOperations;
import com.learn.utils.PracticeUtils;

public class RestaurantOperations implements RetailOperations{

	private static final Logger logger = LogManager.getLogger(RestaurantOperations.class);
	
	public static final String RESTAURANT_PAYLOAD_FILE = "src/main/resources/restaurant_payload.json";
	
	public static RestaurantOperations _instance = null; 

	public static RestaurantOperations getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (RestaurantOperations.class) {
				if(Objects.isNull(_instance)) {
					_instance = new RestaurantOperations();
				}
			}
		}
		return _instance;
	}
	
	public String getPayload() throws FileNotFoundException, IOException {
		String restaurantPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(RESTAURANT_PAYLOAD_FILE)));
		return restaurantPayload;
	}
	
	
	@Override
	public Map<String, Object> create() {
		logger.debug("Executing create method: ");
		String path = ORDER_URL.concat(CREATE).concat(SEPARATOR).concat("v1");
		try {
			String payload = getPayload();
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.PUT);
		} catch (Exception e) {
			logger.error("Error occured while executing create operation: "+e.getMessage());
		}
		return null;
	}

	@Override
	public Map<String, Object> update(String payload) {
		logger.debug("Executing update method: ");
		String path = ORDER_URL.concat(SEPARATOR).concat(UPDATE);
		try {
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.POST);
		} catch (Exception e) {
			logger.error("Error occured while executing create operation: "+e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get(long id) {
		return get(String.valueOf(id));
	}

}
