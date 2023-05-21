package com.learn.interview.apis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.api.client.http.HttpMethods;
import com.learn.utils.FileFormatConvertorUtils;
import com.learn.utils.PracticeUtils;

public class BillingOperations implements RetailOperations{

	private static final Logger logger = LogManager.getLogger(BillingOperations.class);
	
	public static final String CREATE_BILLING_FILE_PATH = "src/main/resources/billing_request.json";

	public static String SEPARATOR = "/";
	public static String CONTENT_TYPE_JSON = "application/json";


	public static BillingOperations _instance = null; 

	public static BillingOperations getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (BillingOperations.class) {
				if(Objects.isNull(_instance)) {
					_instance = new BillingOperations();
				}
			}
		}
		return _instance;
	}



	public String getBillingPayload() throws FileNotFoundException, IOException {
		String createBillingPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_BILLING_FILE_PATH)));
		return createBillingPayload;
	}
	

	@Override
	public Map<String, Object> create() {
		String path = BILL_URL.concat(CREATE);
		try {
			String payload = getPayload(); 
			logger.debug("=====>CREATE OPERATION PAYLOAD ====> "+payload);
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.PUT);
		} catch (Exception e) {
			logger.error("Error occured while create billing: "+e.getMessage());
		}
		return null;
		
	}

	@Override
	public Map<String, Object> update(String payload) {
		String path=BILL_URL.concat(UPDATE);
		try {
			logger.debug("=====>UPDATE OPERATION PAYLOAD ====> "+payload);
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.POST);
		} catch (Exception e) {
			logger.error("Error occured while update billing: "+e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(String id) {
		String path=BILL_URL.concat(DELETE);
		try {
			logger.debug("=====>DELETE OPERATION ====> ");
			PracticeUtils.sendGetRequest(path, HttpMethods.DELETE);
		} catch (Exception e) {
			logger.error("Error occured while update billing: "+e.getMessage());
		}
	}
	

	@Override
	public String get() {
		return get(null);
	}
	
	@Override
	public String get(String id) {
		String result = findAllBilling(id);
		if(Objects.isNull(result))
			logger.error("No response for id: "+id +" in the DB");
		return result;
	}
	
	@Override
	public String get(long id) {
		return get(String.valueOf(id));
	}
	
	
	public String findAllBilling(String id){
		
		String path=BILL_URL.concat(GETALL);
		if(Objects.nonNull(id)) {
			path = BILL_URL.concat(GET).concat(SEPARATOR).concat(id);
		}

		try {
			String result = PracticeUtils.sendGetRequest(path, CONTENT_TYPE_JSON);
			logger.debug(FileFormatConvertorUtils.prettyPrintJSON(result));
			return result;
		} catch (Exception e) {
			System.err.println("Error occured while get operation: "+e.getMessage());
		}
		return null;
	}
	
	public String getPayload() throws FileNotFoundException, IOException {
		String createPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_BILLING_FILE_PATH)));
		return createPayload;
	}
	
	public static final String RESPONSE_CODE = "RESPONSE_CODE";
	public static final String RESPONSE = "RESPONSE_OBJECT";
	
	
	@SuppressWarnings("unchecked")
	public void testOperations() {
		getInstance().get();	
		Map<String, Object> response = getInstance().create();
		Integer createResponse = (Integer) response.get(RESPONSE_CODE);
		if(createResponse == 200) {
			response = getInstance().handleUpdateRequest(response, "S", "P");
			getInstance().handleUpdateRequest(response, "P", "C");				
		}
		
		getInstance().get();
	}
	
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> handleUpdateRequest(Map<String, Object> response, String value, String updateEnumTo) {

		Integer statusCode = (Integer) response.get(RESPONSE_CODE);
		if(statusCode == 200) {
			String responseObject = (String) response.get(RESPONSE);
			String updatePayload = responseObject.replace(value, updateEnumTo);
			logger.debug("Updated-request: \n"+updatePayload);
			response = getInstance().update(updatePayload);		
		}
		return response;
	}

}
