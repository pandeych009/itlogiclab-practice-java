package com.itlogiclab.service.microsvc.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itlogiclab.utils.FileFormatConvertorUtils;
import com.itlogiclab.utils.PracticeUtils;

public class MicroserviceRetailOperationImpl implements MicroserviceRetailOperations {
	
	
	private static final Logger logger = LogManager.getLogger(MicroserviceRetailOperationImpl.class);

	
	public static MicroserviceRetailOperations _instance = null; 

	public static MicroserviceRetailOperations getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (MicroserviceRetailOperationImpl.class) {
				if(Objects.isNull(_instance)) {
					_instance = new MicroserviceRetailOperationImpl();
				}
			}
		}
		return _instance;
	}

	@Override
	public Map<String, Object> add() {
		// TODO Auto-generated method stub
		String URL =  ORDER_URL+CREATE;
		logger.info("URL: "+URL);
		try {
			String payload = PracticeUtils.readDataFromSource(new FileInputStream(new File(ORDER_REQ_PATH)));
			Map<String, Object> response = PracticeUtils.sendPostRequest(URL, payload, CONTENT_TYPE_JSON, "PUT");
			return response;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error occured while reading data: "+e.getMessage());
		}
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
		// TODO Auto-generated method stub
		try {
			String result = PracticeUtils.sendGetRequest(ORDER_URL+GET+"/"+id, CONTENT_TYPE_JSON);
			if(Objects.isNull(id))
				result = PracticeUtils.sendGetRequest(ORDER_URL+GET, CONTENT_TYPE_JSON);
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
		// TODO Auto-generated method stub
		return null;
	}

}
