package com.learn.interview.apis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class APICallRestaurantService {

	private static final Logger logger = LogManager.getLogger(APICallRestaurantService.class);
	
	public static final String PATTERN_WITH_ID = "/!\\id.+/";

	public static String str = "{\n"
			+ "  \"orderId\": 5,\n"
			+ "  \"orderDate\": \"13022023\",\n"
			+ "  \"orderTime\": \"140424\",\n"
			+ "  \"deliveryAddress\": {\n"
			+ "    \"line1\": \"2 Gatehall Dr\",\n"
			+ "    \"line2\": \"Third Floor\",\n"
			+ "    \"city\": \"Parsippany\",\n"
			+ "    \"state\": \"NJ\",\n"
			+ "    \"country\": \"United States\"\n"
			+ "  },\n"
			+ "  \"status\": \"PICKUPREADY\"\n"
			+ "}";

	private static void orderOperation() {
		//OrderRetailOperation.getInstance().get(1);
		//OrderRetailOperation.getInstance().getEnv();
		
		OrderOperation.getInstance().get(1);
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		orderOperation();
		//getMultiThreadedInvokation();
		//BillingOperations.getInstance().delete(PATTERN_WITH_ID);
	}

	private static void getMultiThreadedInvokation() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		executor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					logger.debug("Thread: "+Thread.currentThread().getId()+ " start creating and reading Orders");
					long start = System.currentTimeMillis();
					BillingOperations.getInstance().delete(null);;
					logger.debug("Thread: "+Thread.currentThread().getId()+ " Time to complete the add operation: "+(System.currentTimeMillis() - start));
					start=System.currentTimeMillis();
					BillingOperations.getInstance().get();
					logger.debug("Thread: "+Thread.currentThread().getId()+ " Time to complete the get operation: "+(System.currentTimeMillis() - start));
					
				}
			}
			
		});
		if(executor.isTerminated()) {
			executor.shutdownNow();
		}
	}
}






