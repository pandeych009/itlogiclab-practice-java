package com.learn.interview.apis;

import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.learn.utils.FileFormatConvertorUtils;
import com.learn.utils.PracticeUtils;

public class OrderRetailOperation  implements RetailOperations{
	
	private static final Logger logger = LogManager.getLogger(OrderRetailOperation.class);
	
	public static OrderRetailOperation _instance = null; 

	public static OrderRetailOperation getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (OrderRetailOperation.class) {
				if(Objects.isNull(_instance)) {
					_instance = new OrderRetailOperation();
				}
			}
		}
		return _instance;
	}

	

	@Override
	public Map<String, Object> create() {
		
		return null;
	}

	@Override
	public Map<String, Object> update(String payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String get(String id) {
		try {
			String result = PracticeUtils.sendGetRequest(ORDER_KUBE_URL+GET, CONTENT_TYPE_JSON);
			logger.debug(FileFormatConvertorUtils.prettyPrintJSON(result));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String get() {
		return get(null);
	}

	@Override
	public String get(long id) {
		try {
			String result = PracticeUtils.sendGetRequest(ORDER_KUBE_URL+GET+"/"+id, CONTENT_TYPE_JSON);
			logger.debug(FileFormatConvertorUtils.prettyPrintJSON(result));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getEnv() {
		
		String PATH = ORDER_KUBE_URL+"getEnv";
		logger.debug("Path to URL: "+PATH);
		try {
			String result = PracticeUtils.sendGetRequest(PATH, "text/plain");//text/plain
			logger.debug("Output: "+result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

}
