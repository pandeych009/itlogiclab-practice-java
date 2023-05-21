package com.learn.interview.apis;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.google.api.client.http.HttpMethods;
import com.learn.utils.FileFormatConvertorUtils;
import com.learn.utils.PracticeUtils;

public class ApiCall {



	public static void sendPostRequest() {
		String postUrl="http://localhost:20003/worksheet/api/createWorksheet";
		try {
			InputStream stream = new FileInputStream(new File("src/main/resources/PostRequestData.dat"));
			String payload = PracticeUtils.readDataFromSource(stream);
			PracticeUtils.sendPostRequest(postUrl, payload, "application/json", HttpMethods.PUT);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void sendPostRequest(int result) {
		String postUrl="http://localhost:20003//question/api/createQ";
		try {
			InputStream stream = new FileInputStream(new File("src/main/resources/Question.json"));
			String payload = PracticeUtils.readDataFromSource(stream);
			PracticeUtils.sendPostRequest(postUrl, payload, "application/json", HttpMethods.PUT);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
//		sendPostRequest(0);
//		String path = "http://localhost:20003//question/api/getAll";
//		String linearRsponse = PracticeUtils.sendGetRequest(path, "application/json");
//		System.out.println(JSONUtils.prettyPrintJSON(linearRsponse));
		
		//doCallDockerImage();
		//sendPostRequest(0);
		//doGetCallDockerImage();
		//doGetCallApiGategway();
		
		
		//getOrders();
		

		//handleOrderOperations();
		//PaymentOperation.getInstance().testOperations();

		//		for(int i=0;i<10;i++) {
		//			Map<String, Object> orderResponse 		= OrderOperation.getInstance().createOrder(); //In-queue
		//		}


		//RestaurantOperations.getInstance().create();


		//		Map<String, Object> billResponse 		= BillingOperations.getInstance().create();
		//		Map<String, Object> paymentResponse 	= PaymentOperation.getInstance().create();
		//		Map<String, Object> deliveryResponse 	= DeliveryOperations.getInstance().create();
		//		
		//OrderOperation.getInstance().getOrder();
		//OrderOperation.getInstance().pushEvent();
		//	OrderOperation.getInstance().getEvent();

		//
		//BillingOperations.getInstance().create();
		//BillingOperations.getInstance().get();
		//	String payload = BillingOperations.getInstance().get(33);
		//	String update = payload.replace("\"orderId\":1,", "\"orderId\":3,");
		//	
		//BillingOperations.getInstance().update(update);

		//BillingOperations.getInstance().get(33);





		//	BillingOperations.getInstance().testOperations();
		//	DeliveryOperations.getInstance().testDeliveryOperations();

		//DeliveryOperations.getInstance().get();

		//getInstance().getOrder();
		//getInstance().getDelivery();
		//String createDeliveryPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_DELIVERY_FILE_PATH)));
		//System.out.println(createDeliveryPayload);
		//getInstance().createDelivery(createDeliveryPayload);
		//getInstance().updateDelivery(createDeliveryPayload);
		//getInstance().getDelivery();

		//OrderOperation.getInstance().testOrderOperations();
		
	}
	
	public static void doGetCallApiGategway() {
		String path = "http://localhost:5001/question/api/getAll";
		//path = "http://localhost:20003/question/api/getAll";
		
		path="http://localhost:5001/api/question/api/getAll";
		try {
			String result = PracticeUtils.sendGetRequest(path, "application/json");
			System.out.println(FileFormatConvertorUtils.prettyPrintJSON(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void doCallDockerImage() {
		String path = "http://0.0.0.0:4000/question/api/createQ";
		try {
			InputStream stream = new FileInputStream(new File("src/main/resources/Question.json"));
			String payload = PracticeUtils.readDataFromSource(stream);
			PracticeUtils.sendPostRequest(path, payload, "application/json", HttpMethods.PUT);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void doGetCallDockerImage() {
		String path = "http://172.25.0.1:4000/question/api/getAll";
		try {
			String result = PracticeUtils.sendGetRequest(path, "application/json");
			System.out.println(FileFormatConvertorUtils.prettyPrintJSON(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void getDelivery() {
		String path="http://localhost:20003//delivery/api/getDeliery/{}";
		path="http://localhost:20003//delivery/api/getAllDeliery";
		try {
			String result = PracticeUtils.sendGetRequest(path, "application/json");
			System.out.println(FileFormatConvertorUtils.prettyPrintJSON(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void postDelivery(String fileName) {
		String path = "http://localhost:20003//delivery/api/createNewDeliery";
		path="http://localhost:20003//delivery/api/updateDeliery";
		
		
		try {
			//"src/main/resources/Question.json" filenameExample
			InputStream stream = new FileInputStream(new File(fileName));
			String payload = PracticeUtils.readDataFromSource(stream);
			PracticeUtils.sendPostRequest(path, payload, "application/json", HttpMethods.PUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
