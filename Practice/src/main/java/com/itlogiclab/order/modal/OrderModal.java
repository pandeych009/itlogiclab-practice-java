package com.itlogiclab.order.modal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlogiclab.order.enums.Types;
import com.itlogiclab.order.enums.Types.ORDER_STATUS;

public class OrderModal {
	
	private long orderId;
	
	private String orderDate;
	
	private String orderTime;
	
	private Address deliveryAddress;
	
	private Types.ORDER_STATUS status;
	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the orderTime
	 */
	public String getOrderTime() {
		return orderTime;
	}
	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	/**
	 * @return the deliveryAddress
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	/**
	 * @return the status
	 */
	public Types.ORDER_STATUS getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Types.ORDER_STATUS status) {
		this.status = status;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderModal [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", deliveryAddress=" + deliveryAddress + ", status=" + status + "]";
	}
	
	
	public String getJSON(OrderModal request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
		System.out.println(str);
		return str;
	}
	
	
	public static void main(String[] args) {
		OrderModal modal = new OrderModal();
		modal.setOrderDate("02/13/2023");
		modal.setOrderId(0);
		modal.setOrderTime("0710");
		modal.setStatus(ORDER_STATUS.INQUEUE);
	}
	
}
