package com.itlogiclab.service.microsvc.tests;

import java.util.Map;

public interface MicroserviceRetailOperations {

	public static final String ORDER_REQ_PATH = "src/main/resources/order_ms.json"; 
	
	public static final String HOST = "localhost";

	public static final String ORDER_PORT = "20001";
	public static final String ORDER_CONTEXT = "/order/";

	public static final String PAYMENT_PORT = "20004";
	public static final String PAYMENT_CONTEXT = "/payment/api/";


	public static final String ORDER_URL = "http://".concat(HOST).concat(":").concat(ORDER_PORT).concat(ORDER_CONTEXT);
	public static final String PAYMENT_URL = "http://".concat(HOST).concat(":").concat(PAYMENT_PORT).concat(PAYMENT_CONTEXT);


	public static final String CREATE = "add";
	public static final String UPDATE = "update";
	public static final String GETALL = "get";
	public static final String GET = "get";
	public static final String DELETE = "delete";

	public static final String SEPARATOR = "/";
	public static final String CONTENT_TYPE_JSON = "application/json";

	public Map<String, Object> add();

	public Map<String, Object> update(String payload);

	public void delete(String id);

	public String get(String id);

	public String  get();

	public String get(long id);

	
}
