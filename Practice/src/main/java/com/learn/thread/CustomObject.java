package com.learn.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomObject {
	
	private Map<String, Object> values;
	private long currentTime;
	
	
	/**
	 * @return the values
	 */
	public Map<String, Object> getValues() {
		return values;
	}

	/**
	 * @param values the values to set
	 */
	public void setValues(Map<String, Object> values) {
		this.values = values;
	}
	
	
	public void addValue(String key, Object value){
		if(Objects.isNull(values)){
			values = new HashMap<>();
		}
		 values.computeIfAbsent(key, k -> value);
	}

	/**
	 * @return the currentTime
	 */
	public long getCurrentTime() {
		return currentTime;
	}





	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}





	@Override
	public String toString() {
		return "CustomObject [values=" + values + ", currentTime=" + currentTime + "]";
	} 
	
}
