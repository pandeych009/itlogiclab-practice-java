package com.learn.interview.apis.operations;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VarArgsMethodTest {

	private static final Logger logger = LogManager.getLogger(VarArgsMethodTest.class);
	
	
	public static void main(String[] args) {
		VarArgTestSvcImpl.getInstance().service("Chandan", "Pandey", "myName", String.valueOf(System.currentTimeMillis()), "varargs", "chandan");
	}
	
	public void testV1(String name, String... values) {
		for(String str: values) {
			logger.debug("Name: "+name+", values: : "+str);
		}
		
		testV1(name, values);

	}


	public void testV1(String name, int random, String[] values) {


	}
}
