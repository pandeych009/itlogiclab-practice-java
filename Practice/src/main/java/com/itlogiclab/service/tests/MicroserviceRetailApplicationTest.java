package com.itlogiclab.service.tests;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.itlogiclab.service.microsvc.tests.MicroserviceRetailOperationImpl;

public class MicroserviceRetailApplicationTest {

	private static final Logger logger = LogManager.getLogger(MicroserviceRetailApplicationTest.class);

	public static void main(String[] args) {
		logger.debug("Testing the main method execution");
		Map<String, Object> res = MicroserviceRetailOperationImpl.getInstance().add();
		logger.info(res);
	}


}