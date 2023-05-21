package com.learn.interview.apis.operations;

import java.util.List;

public interface VarArgTestSvc {
	
	public String service(String name, String... values);
	
	public String service(String name, List<String> values);

}
