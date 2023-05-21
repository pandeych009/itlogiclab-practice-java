package com.learn.interview.apis.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VarArgTestSvcImpl implements VarArgTestSvc {

	private static final Logger logger = LogManager.getLogger(VarArgTestSvcImpl.class);

	public static VarArgTestSvc _instance = null; 

	public static VarArgTestSvc getInstance() {
		if(Objects.isNull(_instance)) {
			synchronized (VarArgTestSvcImpl.class) {
				if(Objects.isNull(_instance)) {
					_instance = new VarArgTestSvcImpl();
				}
			}
		}
		return _instance;
	}

	@Override
	public String service(String name, String... values) {
		List<String> strValues = new ArrayList<String>();
		for(String str: values) {
			strValues.add(str);
		}
		
		return service(name, strValues);
	}

	@Override
	public String service(String name, List<String> strValues) {
		for(String str: strValues) {
			logger.debug("Name: "+name+", values: : "+str.toString());
		}
		return null;
	}

}
