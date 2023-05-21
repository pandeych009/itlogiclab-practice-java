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

public class OrderOperationTest {

	public static String INGRESS_HOST="itlogiclabs-api-local.com";
	
	public static String HOST = "itlogiclabs-api-local.com";
	public static String PORT = "30002";
	public static String CONTEXT = "/order/kube/api/";
	
	public static String BASE_PATH = PORT.isEmpty() ? "http://"+HOST+CONTEXT : "http://"+HOST+":"+PORT+CONTEXT;

	public static String BASE_GET_PATH = "http://localhost:30002/order/api";

	public static final String CREATE_ORDER_FILE_PATH = "src/main/resources/order.json";
	

	public static String SEPARATOR = "/";
	public static String CONTENT_TYPE_JSON = "application/json";
	
	public static String CREATE_OPER = "add";
	public static String UPDATE_OPER = "update";
	public static String GETALL_OPER = "get";

	
	private static OrderOperationTest _instance = null; 

	public static OrderOperationTest getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (OrderOperationTest.class) {
				if(Objects.isNull(_instance)) {
					_instance = new OrderOperationTest();
				}
			}
		}
		return _instance;
	}


	public void getOrder() {
		getOrder(null);
	}

	public void getOrder(Long id) {
		String path = "http://localhost:20001/order/api/";

		if(Objects.isNull(id)) {
			path = BASE_GET_PATH+SEPARATOR+"getAllOrder";
		}else path = BASE_GET_PATH+SEPARATOR+"getOrder"+SEPARATOR+id;

		try {
			String result = PracticeUtils.sendGetRequest(path, CONTENT_TYPE_JSON);
			System.out.println(FileFormatConvertorUtils.prettyPrintJSON(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Map<String, Object> createOrder(String payload) {
		String path = BASE_GET_PATH+"/createOrder";
		try {
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.PUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> updateOrder(String payload) {
		String path=BASE_GET_PATH+"/updateOrder";
		try {
			return PracticeUtils.sendPostRequest(path, payload, CONTENT_TYPE_JSON, HttpMethods.POST);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public void handleUpdateRequest(Map<String, Object> response, String update) {

		Integer statusCode = (Integer) response.get("RESPONSE_CODE");
		if(statusCode == 200) {
			String responseObject = (String) response.get("RESPONSE_OBJECT");
			String updatePayload = responseObject.replace("INQUEUE", update);
			System.out.println("Updates-payload: \n"+updatePayload);
			response = getInstance().updateOrder(updatePayload);		
		}
		response.keySet().forEach(System.out::print);
	}

}

class OrderKubeOperations{

	public static String HOST = "itlogiclabs-api-local.com";
	public static String PORT = "";
	public static String CONTEXT = "/order/kube/api/";

	public static String CREATE_OPER = "createOrder";
	public static String UPDATE_OPER = "updateOrder";
	public static String GETALL_OPER = "getAllOrder";
	public static String GET_OPER = "getOrder";

	public static String BASE_PATH = PORT.isEmpty() ? "http://"+HOST+CONTEXT : "http://"+HOST+":"+PORT+CONTEXT;

	public static final String CREATE_ORDER_FILE_PATH = "src/main/resources/order.json";
	public static String SEPARATOR = "/";
	public static String CONTENT_TYPE_JSON = "application/json";

	private static OrderKubeOperations _instance = null; 

	public static OrderKubeOperations getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (OrderKubeOperations.class) {
				if(Objects.isNull(_instance)) {
					_instance = new OrderKubeOperations();
				}
			}
		}
		return _instance;
	}


	public Map<String, Object> createBill() {
		String path = BASE_PATH+CREATE_OPER;
		try {
			String payload = getOrderPayload();
			System.out.println(payload);
			System.out.println(path);
			return PracticeUtils.sendPostRequest(path, payload , CONTENT_TYPE_JSON, HttpMethods.PUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public String getOrderPayload() throws FileNotFoundException, IOException {
		String createBillingPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_ORDER_FILE_PATH)));
		return createBillingPayload;
	}

}
