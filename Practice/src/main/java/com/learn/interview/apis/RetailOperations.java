package com.learn.interview.apis;

import java.util.Map;

public interface RetailOperations {
	
	public static final String HOST = "localhost";
	
	public static final String ORDER_PORT = "50128";
	public static final String ORDER_CONTEXT = "/order/api/";
	
	public static final String ORDER_KUBE_PORT = "59370";
	public static final String ORDER_KUBE_CONTEXT = "/order/kube/api/";
	
	public static final String BILL_PORT = "20002";
	public static String BILL_CONTEXT = "/billing/api/";
	
	public static final String DELIVERY_PORT = "20003";
	public static final String DELIVERY_CONTEXT = "/delivery/api/";
	
	public static final String PAYMENT_PORT = "20004";
	public static final String PAYMENT_CONTEXT = "/payment/api/";
	
	
	public static final String BILL_URL = "http://".concat(HOST).concat(":").concat(BILL_PORT).concat(BILL_CONTEXT);
	public static final String ORDER_URL = "http://".concat(HOST).concat(":").concat(ORDER_PORT).concat(ORDER_CONTEXT);
	public static final String ORDER_KUBE_URL = "http://".concat(HOST).concat(":").concat(ORDER_KUBE_PORT).concat(ORDER_KUBE_CONTEXT);
	public static final String PAYMENT_URL = "http://".concat(HOST).concat(":").concat(PAYMENT_PORT).concat(PAYMENT_CONTEXT);
	public static final String DELIVERY_URL = "http://".concat(HOST).concat(":").concat(DELIVERY_PORT).concat(DELIVERY_CONTEXT);
	
	
	public static final String CREATE = "add";
	public static final String UPDATE = "update";
	public static final String GETALL = "get";
	public static final String GET = "get";
	public static final String DELETE = "delete";
	
	public static final String SEPARATOR = "/";
	public static final String CONTENT_TYPE_JSON = "application/json";
	
	public Map<String, Object> create();
	
	public Map<String, Object> update(String payload);
	
	public void delete(String id);
	
	public String get(String id);
	
	public String  get();
	
	public String get(long id);
	
	public default String getEnv() {
		
		return null;
	}
	
	
}