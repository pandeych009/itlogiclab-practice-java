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

public class OrderOperation implements RetailOperations{
	private static final Logger logger = LogManager.getLogger(OrderOperation.class);
	public static final String CREATE_ORDER_FILE_PATH = "src/main/resources/order.json";

	public static OrderOperation _instance = null; 

	public static OrderOperation getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (OrderOperation.class) {
				if(Objects.isNull(_instance)) {
					_instance = new OrderOperation();
				}
			}
		}
		return _instance;
	}

	

	public String getOrderPayload() throws FileNotFoundException, IOException {
		String orderPayload = PracticeUtils.readDataFromSource(new FileInputStream(new File(CREATE_ORDER_FILE_PATH)));
		return orderPayload;
	}

	@Override
	public Map<String, Object> create() {
		try {
			String payload = getOrderPayload();
			logger.debug(payload);
			logger.debug(ORDER_URL+CREATE);
			return PracticeUtils.sendPostRequest(ORDER_URL+CREATE, payload ,CONTENT_TYPE_JSON, HttpMethods.PUT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Map<String, Object> update(String payload) {
		try {
			logger.debug(payload);
			logger.debug(ORDER_URL+UPDATE);
			return PracticeUtils.sendPostRequest(ORDER_URL+UPDATE, payload ,CONTENT_TYPE_JSON, HttpMethods.POST);
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
		get(0);
		return null;
	}

	@Override
	public String get() {
		get(0);
		return null;
	}

	@Override
	public String get(long id) {
		String PATH = ORDER_URL;
		if(id == 0) {
			PATH = PATH+GETALL;
		}else PATH = PATH+GET;
		try {
			String result = PracticeUtils.sendGetRequest(PATH, CONTENT_TYPE_JSON);
			System.out.println(FileFormatConvertorUtils.prettyPrintJSON(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}