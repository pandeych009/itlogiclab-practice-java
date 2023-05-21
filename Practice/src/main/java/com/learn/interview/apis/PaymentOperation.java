package com.learn.interview.apis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import com.google.api.client.http.HttpMethods;
import com.learn.utils.FileFormatConvertorUtils;
import com.learn.utils.PracticeUtils;

public class PaymentOperation implements RetailOperations {

	@Override
	public Map<String, Object> create() {
		String path = BASE_PATH.concat(SEPARATOR).concat(CREATE_OPER);
		try {
			String payload = getPayload(); 
			System.out.println("=====>CREATE OPERATION PAYLOAD ====> "+payload);
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.PUT);
		} catch (Exception e) {
			System.err.println("Error occured while create Delivery: "+e.getMessage());
		}
		return null;
	}

	@Override
	public Map<String, Object> update(String payload) {
		String path=BASE_PATH.concat(SEPARATOR).concat(UPDATE_OPER);
		try {
			System.out.println("=====>UPDATE OPERATION PAYLOAD ====> "+payload);
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.POST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public String get(String id) {
		String response = findAll(id);
		if(Objects.isNull(response))
			System.err.println("No response for id: "+id +" in the DB");
		
		return response;
	}

	@Override
	public String get() {
		return findAll(null);
	}

	public String findAll(String id){

		String path=BASE_PATH.concat(SEPARATOR).concat(GET_OPER);
		if(Objects.nonNull(id)) {
			path = BASE_PATH.concat(SEPARATOR).concat(GET_OPER).concat(SEPARATOR).concat(id);
		}

		try {
			String result = PracticeUtils.sendGetRequest(path, CONTENT_TYPE_JSON);
			System.out.println(FileFormatConvertorUtils.prettyPrintJSON(result));
			return result;
		} catch (Exception e) {
			System.err.println("Error occured while get operation: "+e.getMessage());
		}
		return null;
	}




	public static String HOST = "localhost";
	public static String PORT = "20004";
	public static String CONTEXT = "/payment/api/";

	public static String CREATE_OPER = "create";
	public static String UPDATE_OPER = "update";
	public static String GET_OPER = "get";

	public static String BASE_PATH = "http://".concat(HOST).concat(":").concat(PORT).concat(CONTEXT);

	public static final String CREATE_PAYMENT_FILE_PATH = "src/main/resources/payment.json";

	public static String SEPARATOR = "/";
	public static String CONTENT_TYPE_JSON = "application/json";


	public static PaymentOperation _instance = null; 

	public static PaymentOperation getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (PaymentOperation.class) {
				if(Objects.isNull(_instance)) {
					_instance = new PaymentOperation();
				}
			}
		}
		return _instance;
	}



	public String getPayload() throws FileNotFoundException, IOException {
		String createPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_PAYMENT_FILE_PATH)));
		return createPayload;
	}
	public static final String RESPONSE_CODE = "RESPONSE_CODE";
	public static final String RESPONSE = "RESPONSE_OBJECT";
	
	@SuppressWarnings("unchecked")
	public void testOperations() {
		//String createOrderPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_ORDER_FILE_PATH)));
		getInstance().get();	
		Map<String, Object> response = getInstance().create();
		Integer createResponse = (Integer) response.get(RESPONSE_CODE);
		if(createResponse == 200) {
			response = getInstance().handleUpdateRequest(response, "PENDING", "PAID");
			getInstance().get();
			getInstance().handleUpdateRequest(response, "CC", "DB");				
		}
		
		getInstance().get();
	}
	
	
	@SuppressWarnings("unchecked")
	private Map<String, Object> handleUpdateRequest(Map<String, Object> response, String value, String updateEnumTo) {

		Integer statusCode = (Integer) response.get(RESPONSE_CODE);
		if(statusCode == 200) {
			String responseObject = (String) response.get(RESPONSE);
			String updatePayload = responseObject.replace(value, updateEnumTo);
			System.out.println("Updated-request: \n"+updatePayload);
			response = getInstance().update(updatePayload);		
		}
		return response;
	}

	@Override
	public String get(long id) {
		return get(String.valueOf(id));
	}

}
